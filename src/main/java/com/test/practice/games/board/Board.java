package com.test.practice.games.board;

import com.test.practice.games.board.tile.Tile;
import com.test.practice.games.board.tile.TwoDimensionalPoint;

public interface Board<R, P extends TwoDimensionalPoint, T extends Tile<R,P>>{
    T getTile(int x, int y);
    void render();

    boolean add( T t);

    boolean add( R data,int x, int y);

}
