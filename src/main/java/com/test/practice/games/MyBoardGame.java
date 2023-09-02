package com.test.practice.games;

/**
 * Do you like board games?
 * I love tile-based board games so much that I want to recreate some of them as video games.
 *
 * Step 1: generic classes
 * First, I need some generic classes. Let’s call them Tile and Board.
 *
 * A board will be initialized with a specified width and height and will have a method get_tile(x, y) that returns a Tile object.
 *
 * Many board games have elements that impact adjacent tiles. I want to handle that easily, without those “x-1”, “x+1” operations. So the class Tile will have a method get_adjacent(direction) that returns a Tile object. The parameter direction is an integer from 0 to 7, with adjacencies according to this diagram:
 *
 * |------|------|------|
 * |   7  |   0  |   1  |
 * |------|------|------|
 * |   6  | Tile |   2  |
 * |------|------|------|
 * |   5  |   4  |   3  |
 * |------|------|------|
 * schema board and tile classes
 *
 * The Tile class will also contain a member char_data, which will be a single character. Then, the Board could have a method render(), printing these char_datas in a square of width*height characters. It’s rather simplistic, but we need it for debugging.
 *
 * The tiles should contain a lot of other information, depending on the board game I’m currently implementing. But we don’t have to care about that for the moment; I will override the class when needed.
 *
 * Could you help me code this? With these classes, I could implement chess, draughts, minesweeper, and many other games!
 *
 *
 *
 *
 *
 */

public class MyBoardGame {
}
