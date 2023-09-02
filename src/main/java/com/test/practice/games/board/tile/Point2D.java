package com.test.practice.games.board.tile;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Point2D implements TwoDimensionalPoint{
    private final int x;
    private final int y;

    @Override
    public String toString() {
        return "(" +
                 + x +
                ", " + y +
                ')';
    }
}
