package com.test.practice.games.board;

import com.test.practice.games.board.tile.GenericTile;
import com.test.practice.games.board.tile.TwoDimensionalPoint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedSizeBoardTest {

    @Test
    void getTile() {
        FixedSizeBoard<Character, TwoDimensionalPoint,GenericTile<Character,TwoDimensionalPoint>> b = new FixedSizeBoard<>(2,2);
        GenericTile<Character,TwoDimensionalPoint> charTile0 = new GenericTile<>('0');
        GenericTile<Character,TwoDimensionalPoint> charTile1 = new GenericTile<>('1');
        GenericTile<Character,TwoDimensionalPoint> charTile2 = new GenericTile<>('2');
        GenericTile<Character,TwoDimensionalPoint> charTile3 = new GenericTile<>('3');

        b.add(charTile0);
        b.add(charTile1);
        b.add(charTile2);
        b.add(charTile3);

        assertEquals(charTile0,  b.getTile(0,0));
        assertEquals(charTile1,  b.getTile(0,1));
        assertEquals(charTile2,  b.getTile(1,0));
        assertEquals(charTile3,  b.getTile(1,1));

        assertEquals(charTile1,  charTile0.getAdjacentTileByDirection(Direction.RIGHT));
        assertEquals(charTile2,  charTile0.getAdjacentTileByDirection(Direction.UP));
        assertEquals(charTile3,  charTile0.getAdjacentTileByDirection(Direction.UP_RIGHT));

        assertEquals(charTile0,  charTile1.getAdjacentTileByDirection(Direction.LEFT));
        assertEquals(charTile2,  charTile1.getAdjacentTileByDirection(Direction.UP_LEFT));
        assertEquals(charTile3,  charTile1.getAdjacentTileByDirection(Direction.UP));

        assertEquals(charTile0,  charTile2.getAdjacentTileByDirection(Direction.DOWN));
        assertEquals(charTile1,  charTile2.getAdjacentTileByDirection(Direction.DOWN_RIGHT));
        assertEquals(charTile3,  charTile2.getAdjacentTileByDirection(Direction.RIGHT));

        assertEquals(charTile0,  charTile3.getAdjacentTileByDirection(Direction.DOWN_LEFT));
        assertEquals(charTile1,  charTile3.getAdjacentTileByDirection(Direction.DOWN));
        assertEquals(charTile2,  charTile3.getAdjacentTileByDirection(Direction.LEFT));
    }

    @Test
    void render() {
        FixedSizeBoard<Character,TwoDimensionalPoint,GenericTile<Character,TwoDimensionalPoint>> b = new FixedSizeBoard<>(2,2);
        GenericTile<Character,TwoDimensionalPoint>charTile0 = new GenericTile<>('0');
        GenericTile<Character,TwoDimensionalPoint> charTile1 = new GenericTile<>('1');
        GenericTile<Character,TwoDimensionalPoint> charTile2 = new GenericTile<>('2');
        GenericTile<Character,TwoDimensionalPoint> charTile3 = new GenericTile<>('3');

        b.add(charTile0);
        b.add(charTile1);
        b.add(charTile2);
        b.add(charTile3);

        b.render();
    }
}