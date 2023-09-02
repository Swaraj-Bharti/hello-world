package com.test.practice.games.board.tile;

import com.test.practice.games.board.Direction;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@EqualsAndHashCode
public  class GenericTile<R,L extends TwoDimensionalPoint> implements Tile<R,L> {

    private final R data;
    private  L location;
    private final Map<Direction,Tile<R,L>> directionsMap = new HashMap<>();

    public GenericTile(R data) {
        this.data = data;
    }

    public GenericTile(R data, L location) {
        this.data = data;
        this.location = location;
    }

    public Tile<R,L> getAdjacentTileByDirection(Direction direction) {
        return  directionsMap.get(direction);
    }

    public void linkAdjacentTileByDirection(Direction direction, Tile<R, L> t) {
        directionsMap.putIfAbsent(direction,t);
    }
    protected void updateLocation (L l){
        this.location = l;
    }

    @Override
    public String toString() {
        return Objects.toString(data) ;
    }

}
