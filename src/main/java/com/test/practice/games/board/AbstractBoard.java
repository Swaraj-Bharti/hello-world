package com.test.practice.games.board;

import com.test.practice.games.board.tile.GenericTile;
import com.test.practice.games.board.tile.Location;
import com.test.practice.games.board.tile.Tile;
import com.test.practice.games.board.tile.TwoDimensionalPoint;

public abstract class AbstractBoard<R,P extends TwoDimensionalPoint, S extends GenericTile<R,P>> implements Board<R,P,S>{

    protected void updateAdjacent(int i, int j) {
            S ct = getTile(i,j);
            // #0
            updateAdjacent(i + 1, j, ct, Direction.UP);
            // #1
            updateAdjacent(i + 1, j + 1, ct, Direction.UP_RIGHT);
            // #2
            updateAdjacent(i, j + 1, ct, Direction.RIGHT);
            // #3
            updateAdjacent(i - 1, j + 1, ct, Direction.DOWN_RIGHT);
            // #4
            updateAdjacent(i - 1, j, ct, Direction.DOWN);
            // #5
            updateAdjacent(i - 1, j - 1, ct, Direction.DOWN_LEFT);
            // #6
            updateAdjacent(i, j - 1, ct, Direction.LEFT);
            // #7
            updateAdjacent(i + 1, j - 1, ct, Direction.UP_LEFT);
    }

    private void updateAdjacent(int i, int j, S ct, Direction direction) {
            S t = getTile(i,j);
            if (t != null) {
                ct.linkAdjacentTileByDirection(direction, t);
                // establish reverse relationship
                t.linkAdjacentTileByDirection(direction.getReverseDirection(), ct);
            }
    }
}
