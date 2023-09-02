package com.test.practice.games.board;

import com.test.practice.games.board.tile.Point2D;
import com.test.practice.games.board.tile.Tile;
import com.test.practice.games.board.tile.TwoDimensionalPoint;
import com.test.practice.games.board.tile.TwoDimensionalTile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtensibleBoardTest {

    @Test
    void getTile() {
        ExtensibleBoard<Character, TwoDimensionalPoint> b = new ExtensibleBoard<>();
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps1 = new TwoDimensionalTile<>('c', 0, 0);
        b.add(ps1);
        assertEquals(ps1, b.getTile(0,0));
        assertNull(b.getTile(0,1));
    }

    @Test
    void render() {
        ExtensibleBoard<Character,TwoDimensionalPoint> b = new ExtensibleBoard<>();
        // add a position
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps = new TwoDimensionalTile<>('a', 0, 0);
        b.add(ps);

        // add another position on RIGHT of (0,0)
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps0 = new TwoDimensionalTile<>('b', 0, 1);
        b.add(ps0);

        // add another position DOWN_RIGHT of(0,0)
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps1 = new TwoDimensionalTile<>('c', 1, 1);
        b.add(ps1);

        // add another position DOWN of (0,0)
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps2 = new TwoDimensionalTile<>('d', 1, 0);
        b.add(ps2);

        // add another position DOWN_LEFT of (0,0)
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps3 = new TwoDimensionalTile<>('e', 1, -1);
        b.add(ps3);

        // add another position LEFT of (0,0)
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps4 = new TwoDimensionalTile<>('f', 0, -1);
        b.add(ps4);


        // add another position UP of (0,0)
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps5 = new TwoDimensionalTile<>('g', -1, 0);
        b.add(ps5);
         //  add another position UP_LEFT of (0,0)
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps6 = new TwoDimensionalTile<>('h', -1, -1);
        b.add(ps6);
        // add another position UP_RIGHT of (0,0)
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps7 = new TwoDimensionalTile<>('i', -1, 1);
        b.add(ps7);
        System.out.println("b = " + b);
    }

    @Test
    void add() {
        ExtensibleBoard<Character,TwoDimensionalPoint> b = new ExtensibleBoard<>();
        // add a position
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps = new TwoDimensionalTile<>('a', 0, 0);
        b.add(ps);
        assertEquals(ps, b.getTile(0,0));

        // add another position on RIGHT of (0,0)
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps0 = new TwoDimensionalTile<>('b', 0, 1);
        b.add(ps0);
        assertEquals(ps0, b.getTile(0,1));
        assertEquals(ps0, b.getTile(0,0).getAdjacentTileByDirection(Direction.RIGHT));
        assertEquals(ps, b.getTile(0,1).getAdjacentTileByDirection(Direction.LEFT));

        // add another position DOWN_RIGHT of(0,0)
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps1 = new TwoDimensionalTile<>('c', 1, 1);
        b.add(ps1);
        assertEquals(ps1, b.getTile(1,1));
        assertEquals(ps1, b.getTile(0,0).getAdjacentTileByDirection(Direction.UP_RIGHT));
        assertEquals(ps, b.getTile(1,1).getAdjacentTileByDirection(Direction.DOWN_LEFT));
        assertEquals(ps1, b.getTile(0,1).getAdjacentTileByDirection(Direction.UP));
        assertEquals(ps0, b.getTile(1,1).getAdjacentTileByDirection(Direction.DOWN));

        // add another position DOWN of (0,0)
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps2 = new TwoDimensionalTile<>('d', 1, 0);
        b.add(ps2);
        assertEquals(ps2, b.getTile(0,0).getAdjacentTileByDirection(Direction.UP));
        assertEquals(ps, b.getTile(1,0).getAdjacentTileByDirection(Direction.DOWN));

        // add another position DOWN_LEFT of (0,0)
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps3 = new TwoDimensionalTile<>('e', 1, -1);
        b.add(ps3);
        assertEquals(ps3, b.getTile(0,0).getAdjacentTileByDirection(Direction.UP_LEFT));
        assertEquals(ps, b.getTile(1,-1).getAdjacentTileByDirection(Direction.DOWN_RIGHT));

        // add another position LEFT of (0,0)
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps4 = new TwoDimensionalTile<>('f', 0, -1);
        b.add(ps4);
        assertEquals(ps4, b.getTile(0,0).getAdjacentTileByDirection(Direction.LEFT));
        assertEquals(ps, b.getTile(0,-1).getAdjacentTileByDirection(Direction.RIGHT));


        // add another position UP of (0,0)
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps5 = new TwoDimensionalTile<>('g', -1, 0);
        b.add(ps5);
        assertEquals(ps5, b.getTile(0,0).getAdjacentTileByDirection(Direction.DOWN));
        assertEquals(ps, b.getTile(-1,0).getAdjacentTileByDirection(Direction.UP));

        //  add another position UP_LEFT of (0,0)
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps6 = new TwoDimensionalTile<>('h', -1, -1);
        b.add(ps6);
        assertEquals(ps6, b.getTile(0,0).getAdjacentTileByDirection(Direction.DOWN_LEFT));
        assertEquals(ps, b.getTile(-1,-1).getAdjacentTileByDirection(Direction.UP_RIGHT));

        // add another position UP_RIGHT of (0,0)
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps7 = new TwoDimensionalTile<>('i', -1, 1);
        b.add(ps7);
        assertEquals(ps7, b.getTile(0,0).getAdjacentTileByDirection(Direction.DOWN_RIGHT));
        assertEquals(ps, b.getTile(-1,1).getAdjacentTileByDirection(Direction.UP_LEFT));

    }

    @Test
    void addTileRelativeTo() {
        ExtensibleBoard<Character,TwoDimensionalPoint> b = new ExtensibleBoard<>();
        // add a position
        TwoDimensionalTile<Character,TwoDimensionalPoint> ps = new TwoDimensionalTile<>('a', 0, 0);
        b.add(ps);
        assertEquals(ps, b.getTile(0,0));
        boolean isAdded = b.addTileRelativeTo(ps, 'b', Direction.DOWN_LEFT);
        assertTrue(isAdded);
        Tile<Character, TwoDimensionalPoint> tileDownLeft = b.getTile(0, 0).getAdjacentTileByDirection(Direction.DOWN_LEFT);
        assertEquals('b', tileDownLeft.getData());
        assertEquals(new Point2D(-1,-1), tileDownLeft.getLocation());

    }
}