package com.test.practice.games.board.tile;

import com.test.practice.games.board.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericTileTest {

    @Test
    void getData() {
        GenericTile<Character,TwoDimensionalPoint> c = new GenericTile<>('1');
        assertEquals('1',c.getData());
    }

    @Test
    void getAdjacent() {
        GenericTile<Character,TwoDimensionalPoint>charTile0 = new GenericTile<>('0');
        GenericTile<Character,TwoDimensionalPoint> charTile1 = new GenericTile<>('1');
        GenericTile<Character,TwoDimensionalPoint> charTile2 = new GenericTile<>('2');
        GenericTile<Character,TwoDimensionalPoint> charTile3 = new GenericTile<>('3');
        GenericTile<Character,TwoDimensionalPoint>charTile4 = new GenericTile<>('4');
        GenericTile<Character,TwoDimensionalPoint> charTile5 = new GenericTile<>('5');
        GenericTile<Character,TwoDimensionalPoint>charTile6 = new GenericTile<>('6');
        GenericTile<Character,TwoDimensionalPoint>charTile7 = new GenericTile<>('7');
        GenericTile<Character,TwoDimensionalPoint>c = new GenericTile<>('9');
        c.linkAdjacentTileByDirection(Direction.UP,charTile0);
        c.linkAdjacentTileByDirection(Direction.UP_RIGHT,charTile1);
        c.linkAdjacentTileByDirection(Direction.RIGHT,charTile2);
        c.linkAdjacentTileByDirection(Direction.DOWN_RIGHT,charTile3);
        c.linkAdjacentTileByDirection(Direction.DOWN,charTile4);
        c.linkAdjacentTileByDirection(Direction.DOWN_LEFT,charTile5);
        c.linkAdjacentTileByDirection(Direction.LEFT,charTile6);
        c.linkAdjacentTileByDirection(Direction.UP_LEFT,charTile7);

        assertNull(c.getAdjacentTileByDirection(null));
        assertEquals(charTile0,c.getAdjacentTileByDirection(Direction.UP));
        assertEquals(charTile1,c.getAdjacentTileByDirection(Direction.UP_RIGHT));
        assertEquals(charTile2,c.getAdjacentTileByDirection(Direction.RIGHT));
        assertEquals(charTile3,c.getAdjacentTileByDirection(Direction.DOWN_RIGHT));
        assertEquals(charTile4,c.getAdjacentTileByDirection(Direction.DOWN));
        assertEquals(charTile5,c.getAdjacentTileByDirection(Direction.DOWN_LEFT));
        assertEquals(charTile6,c.getAdjacentTileByDirection(Direction.LEFT));
        assertEquals(charTile7,c.getAdjacentTileByDirection(Direction.UP_LEFT));
    }
}