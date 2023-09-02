package com.test.practice.games.board;

import com.test.practice.games.board.tile.GenericTile;
import com.test.practice.games.board.tile.Tile;
import com.test.practice.games.board.tile.TwoDimensionalPoint;

import java.util.ArrayList;
import java.util.Objects;

public class FixedSizeBoard<R,L extends TwoDimensionalPoint, T extends GenericTile<R,L>> extends AbstractBoard<R,L,T> {
    private final ArrayList<ArrayList<T>> board;
    private final int rows;
    private final int columns;

    public FixedSizeBoard(int rows, int columns) {
        if (rows > 0 && columns > 0) {
            this.rows = rows;
            this.columns = columns;
            this.board = initializeBoard();
        } else {
            throw new IllegalArgumentException("dimensions must be greater than 0");
        }
    }

    private ArrayList<ArrayList<T>> initializeBoard(){
        ArrayList<ArrayList<T>> tempBoard = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            ArrayList<T> element = new ArrayList<>(columns);
            tempBoard.add(i, element);
            for (int j = 0; j < columns; j++) {
                element.add(j,null);
            }

        }
       return tempBoard;
    }

    public T getTile(int x, int y) {
        boolean isWithinRange = isWithinRange(x, y);
        T tile = null;
        if (isWithinRange) {
            ArrayList<T> rowX = board.get(x);
            if (rowX != null) {
                tile = rowX.get(y);
            }
        }
        return tile;
    }

    private boolean isWithinRange(int x, int y) {
        return (x < rows && x >= 0) && (y < columns && y >= 0);
    }

    public void render() {
        System.out.println(board);
    }

    public boolean add(T tile) {
        if (tile != null) {
            for (int i = 0; i < rows ; i++) {
                ArrayList<T> rowTiles =  rowTiles = board.get(i);;
                if (rowTiles !=null) {
                    for (int j = 0; j < columns; j++) {
                        T rTile = rowTiles.get(j);
                        if (rTile == null) {
                            rowTiles.add(j, tile);
                            updateAdjacent(i, j);
                            return true;
                        }
                    }
                }else{
                    rowTiles = new ArrayList<>(columns);
                    rowTiles.add(0,tile);
                    updateAdjacent(i, 0);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean add( R data, int x, int y) {
        if (isWithinRange(x, y)) {
            T rTile = (T) new GenericTile<>(data);
            ArrayList<T> rowTiles = board.get(x);
            if (rowTiles != null) {
                if (rowTiles.get(y) == null) {
                    rowTiles.add(y, rTile);
                    updateAdjacent(x, y);
                    return true;
                }
            }else{
                rowTiles = new ArrayList<>(columns);
                rowTiles.add(y,rTile);
                updateAdjacent(x, y);
                return true;
            }
        }
        return false;
    }
}
