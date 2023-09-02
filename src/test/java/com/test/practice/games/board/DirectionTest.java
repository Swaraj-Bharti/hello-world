package com.test.practice.games.board;

import com.test.practice.games.board.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void getDirection() {
        assertEquals(0, Direction.UP.getIndex());
        assertEquals(4, Direction.UP.getReverseIndex());
        assertEquals(1,Direction.UP_RIGHT.getIndex());
        assertEquals(5,Direction.UP_RIGHT.getReverseIndex());
        assertEquals(2,Direction.RIGHT.getIndex());
        assertEquals(6,Direction.RIGHT.getReverseIndex());
        assertEquals(3,Direction.DOWN_RIGHT.getIndex());
        assertEquals(7,Direction.DOWN_RIGHT.getReverseIndex());
        assertEquals(4,Direction.DOWN.getIndex());
        assertEquals(0, Direction.DOWN.getReverseIndex());
        assertEquals(5,Direction.DOWN_LEFT.getIndex());
        assertEquals(1, Direction.DOWN_LEFT.getReverseIndex());
        assertEquals(6,Direction.LEFT.getIndex());
        assertEquals(2, Direction.LEFT.getReverseIndex());
        assertEquals(7,Direction.UP_LEFT.getIndex());
        assertEquals(3,Direction.UP_LEFT.getReverseIndex());
    }

    @Test
    void getReverseDirection(){
        assertEquals(Direction.DOWN,Direction.UP.getReverseDirection());
        assertEquals(Direction.DOWN_LEFT,Direction.UP_RIGHT.getReverseDirection());
        assertEquals(Direction.LEFT,Direction.RIGHT.getReverseDirection());
        assertEquals(Direction.UP_LEFT,Direction.DOWN_RIGHT.getReverseDirection());
        assertEquals(Direction.UP,Direction.DOWN.getReverseDirection());
        assertEquals(Direction.UP_RIGHT,Direction.DOWN_LEFT.getReverseDirection());
        assertEquals(Direction.RIGHT,Direction.LEFT.getReverseDirection());
        assertEquals(Direction.DOWN_RIGHT, Direction.UP_LEFT.getReverseDirection());
    }


}