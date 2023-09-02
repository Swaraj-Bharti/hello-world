package com.test.practice.games.board.tile;

import com.test.practice.games.board.Direction;

public interface Tile<T, L extends Location > {
    T getData();
    Tile<T,L> getAdjacentTileByDirection(Direction direction);

    L getLocation();
}
