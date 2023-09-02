package com.test.practice.games.board;

import com.test.practice.games.board.tile.Point2D;
import com.test.practice.games.board.tile.TwoDimensionalPoint;
import com.test.practice.games.board.tile.TwoDimensionalTile;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExtensibleBoard<R,L extends TwoDimensionalPoint> extends AbstractBoard<R,L,TwoDimensionalTile<R,L>>{

    private final Map<L, TwoDimensionalTile<R,L>> positionTileMap = new LinkedHashMap<>();
    @Override
    public TwoDimensionalTile<R,L> getTile(int x, int y) {
        return positionTileMap.get((L)new Point2D(x,y));
    }

    @Override
    public void render() {
        System.out.println(positionTileMap);
    }

    @Override
    public boolean add(TwoDimensionalTile<R,L> tile) {
        if(tile !=null ){
            L position = tile.getLocation();
            TwoDimensionalTile<R,L> absent = positionTileMap.putIfAbsent(position, tile);
            updateAdjacent(position.getX(),position.getY());
            return absent == null;
        }
        return false;
    }

    public boolean addTileRelativeTo(TwoDimensionalTile<R,L> refTile, R data , Direction direction) {
        if(refTile !=null ){
            L position = relativePosition(refTile.getLocation(),direction);
            TwoDimensionalTile<R,L> absent = positionTileMap.putIfAbsent(position, new TwoDimensionalTile<>(data,position));
            updateAdjacent(position.getX(),position.getY());
            return absent == null;
        }
        return false;
    }

    private L relativePosition(L ref , Direction d){
        if(ref !=null){
            int x = ref.getX();
            int y = ref.getY();

            switch (d) {
                case UP -> x = x + 1;
                case UP_RIGHT -> {
                    x = x + 1;
                    y = y + 1;
                }
                case RIGHT -> y = y + 1;
                case DOWN_RIGHT -> {
                    x = x - 1;
                    y = y + 1;
                }
                case DOWN -> x = x - 1;
                case DOWN_LEFT -> {
                    x = x - 1;
                    y = y - 1;
                }
                case LEFT -> y = y - 1;
                case UP_LEFT -> {
                    x = x + 1;
                    y = y - 1;
                }
                default -> {
                    x = x;
                    y = y;
                }
            }
            return (L) new Point2D(x,y);
        }
        return null;
    }

    public boolean add( R data, int x, int y) {
        L point = (L)new Point2D(x,y);
        return add(new TwoDimensionalTile<>(data, point));
    }

    @Override
    public String toString() {
        return "ExtensibleBoard{" +
                  positionTileMap +
                '}';
    }
}

