package com.test.practice.games.board;

import com.test.practice.games.board.tile.Tile;
import com.test.practice.games.board.tile.TwoDimensionalPoint;

public interface ComposableBoard<R, P extends TwoDimensionalPoint, T extends Tile<R,P>>  extends Board<R, P,T>{

    boolean add(ComposableBoard <R,P,T> board);

}
