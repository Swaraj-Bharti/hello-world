package com.test.practice.games.board.tile;

import com.test.practice.games.board.Direction;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;

@Getter
@EqualsAndHashCode(callSuper = true)
public class TwoDimensionalTile<R,P extends TwoDimensionalPoint> extends GenericTile<R,P> {

    public TwoDimensionalTile(R data, int x, int y) {
        super(data);
        super.updateLocation((P) new Point2D(x,y));
    }

    public TwoDimensionalTile(R data, P point) {
        super(data,point);
    }

    @Override
    public void linkAdjacentTileByDirection(Direction direction, Tile<R,P> t) {
        if( t instanceof TwoDimensionalTile<R,P>) {
            super.linkAdjacentTileByDirection(direction, t);
        }
    }
}

