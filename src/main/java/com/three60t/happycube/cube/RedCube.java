package com.three60t.happycube.cube;

import com.three60t.happycube.puzzle.Puzzle;
import com.three60t.happycube.puzzle.PuzzlePiece;

/**
 * This concrete class is responsible for initiate input data that represents Red puzzle (cube).
 *
 * @author Hossein Moradi
 * @since 3/15/19
 */
public class RedCube extends AbstractCube {
    @Override
    public Puzzle initiateCube() {
        //Initiate Red Puzzles
        //Each puzzle-piece is two-dimensional array [5][5]  and we have 6 puzzle-piece, so we have three-dimensional array  [6][5][5]

        int[][][] cubeArray = new int[6][5][5];

        // puzzle 1
        cubeArray[0][0][0] = 0;
        cubeArray[0][0][1] = 0;
        cubeArray[0][0][2] = 0;
        cubeArray[0][0][3] = 1;
        cubeArray[0][0][4] = 1;

        cubeArray[0][1][0] = 0;
        cubeArray[0][1][1] = 1;
        cubeArray[0][1][2] = 1;
        cubeArray[0][1][3] = 1;
        cubeArray[0][1][4] = 0;

        cubeArray[0][2][0] = 1;
        cubeArray[0][2][1] = 1;
        cubeArray[0][2][2] = 1;
        cubeArray[0][2][3] = 1;
        cubeArray[0][2][4] = 1;

        cubeArray[0][3][0] = 0;
        cubeArray[0][3][1] = 1;
        cubeArray[0][3][2] = 1;
        cubeArray[0][3][3] = 1;
        cubeArray[0][3][4] = 0;

        cubeArray[0][4][0] = 0;
        cubeArray[0][4][1] = 1;
        cubeArray[0][4][2] = 0;
        cubeArray[0][4][3] = 1;
        cubeArray[0][4][4] = 1;

        // puzzle 2
        cubeArray[1][0][0] = 0;
        cubeArray[1][0][1] = 1;
        cubeArray[1][0][2] = 0;
        cubeArray[1][0][3] = 1;
        cubeArray[1][0][4] = 0;

        cubeArray[1][1][0] = 1;
        cubeArray[1][1][1] = 1;
        cubeArray[1][1][2] = 1;
        cubeArray[1][1][3] = 1;
        cubeArray[1][1][4] = 0;

        cubeArray[1][2][0] = 0;
        cubeArray[1][2][1] = 1;
        cubeArray[1][2][2] = 1;
        cubeArray[1][2][3] = 1;
        cubeArray[1][2][4] = 1;

        cubeArray[1][3][0] = 1;
        cubeArray[1][3][1] = 1;
        cubeArray[1][3][2] = 1;
        cubeArray[1][3][3] = 1;
        cubeArray[1][3][4] = 0;

        cubeArray[1][4][0] = 0;
        cubeArray[1][4][1] = 1;
        cubeArray[1][4][2] = 0;
        cubeArray[1][4][3] = 0;
        cubeArray[1][4][4] = 0;

        // puzzle 3
        cubeArray[2][0][0] = 0;
        cubeArray[2][0][1] = 1;
        cubeArray[2][0][2] = 1;
        cubeArray[2][0][3] = 0;
        cubeArray[2][0][4] = 1;

        cubeArray[2][1][0] = 1;
        cubeArray[2][1][1] = 1;
        cubeArray[2][1][2] = 1;
        cubeArray[2][1][3] = 1;
        cubeArray[2][1][4] = 1;

        cubeArray[2][2][0] = 0;
        cubeArray[2][2][1] = 1;
        cubeArray[2][2][2] = 1;
        cubeArray[2][2][3] = 1;
        cubeArray[2][2][4] = 0;

        cubeArray[2][3][0] = 1;
        cubeArray[2][3][1] = 1;
        cubeArray[2][3][2] = 1;
        cubeArray[2][3][3] = 1;
        cubeArray[2][3][4] = 1;

        cubeArray[2][4][0] = 1;
        cubeArray[2][4][1] = 0;
        cubeArray[2][4][2] = 0;
        cubeArray[2][4][3] = 1;
        cubeArray[2][4][4] = 1;

        // puzzle 4
        cubeArray[3][0][0] = 0;
        cubeArray[3][0][1] = 0;
        cubeArray[3][0][2] = 1;
        cubeArray[3][0][3] = 0;
        cubeArray[3][0][4] = 0;

        cubeArray[3][1][0] = 1;
        cubeArray[3][1][1] = 1;
        cubeArray[3][1][2] = 1;
        cubeArray[3][1][3] = 1;
        cubeArray[3][1][4] = 0;

        cubeArray[3][2][0] = 0;
        cubeArray[3][2][1] = 1;
        cubeArray[3][2][2] = 1;
        cubeArray[3][2][3] = 1;
        cubeArray[3][2][4] = 1;

        cubeArray[3][3][0] = 1;
        cubeArray[3][3][1] = 1;
        cubeArray[3][3][2] = 1;
        cubeArray[3][3][3] = 1;
        cubeArray[3][3][4] = 0;

        cubeArray[3][4][0] = 0;
        cubeArray[3][4][1] = 0;
        cubeArray[3][4][2] = 1;
        cubeArray[3][4][3] = 0;
        cubeArray[3][4][4] = 0;

        // puzzle 5
        cubeArray[4][0][0] = 0;
        cubeArray[4][0][1] = 0;
        cubeArray[4][0][2] = 1;
        cubeArray[4][0][3] = 1;
        cubeArray[4][0][4] = 0;

        cubeArray[4][1][0] = 1;
        cubeArray[4][1][1] = 1;
        cubeArray[4][1][2] = 1;
        cubeArray[4][1][3] = 1;
        cubeArray[4][1][4] = 1;

        cubeArray[4][2][0] = 0;
        cubeArray[4][2][1] = 1;
        cubeArray[4][2][2] = 1;
        cubeArray[4][2][3] = 1;
        cubeArray[4][2][4] = 0;

        cubeArray[4][3][0] = 1;
        cubeArray[4][3][1] = 1;
        cubeArray[4][3][2] = 1;
        cubeArray[4][3][3] = 1;
        cubeArray[4][3][4] = 1;

        cubeArray[4][4][0] = 1;
        cubeArray[4][4][1] = 0;
        cubeArray[4][4][2] = 1;
        cubeArray[4][4][3] = 0;
        cubeArray[4][4][4] = 0;

        // puzzle 6
        cubeArray[5][0][0] = 0;
        cubeArray[5][0][1] = 1;
        cubeArray[5][0][2] = 1;
        cubeArray[5][0][3] = 0;
        cubeArray[5][0][4] = 0;

        cubeArray[5][1][0] = 0;
        cubeArray[5][1][1] = 1;
        cubeArray[5][1][2] = 1;
        cubeArray[5][1][3] = 1;
        cubeArray[5][1][4] = 0;

        cubeArray[5][2][0] = 1;
        cubeArray[5][2][1] = 1;
        cubeArray[5][2][2] = 1;
        cubeArray[5][2][3] = 1;
        cubeArray[5][2][4] = 1;

        cubeArray[5][3][0] = 0;
        cubeArray[5][3][1] = 1;
        cubeArray[5][3][2] = 1;
        cubeArray[5][3][3] = 1;
        cubeArray[5][3][4] = 0;

        cubeArray[5][4][0] = 1;
        cubeArray[5][4][1] = 1;
        cubeArray[5][4][2] = 0;
        cubeArray[5][4][3] = 1;
        cubeArray[5][4][4] = 1;

        return new Puzzle(new PuzzlePiece(cubeArray[0]),
                new PuzzlePiece(cubeArray[1]),
                new PuzzlePiece(cubeArray[2]),
                new PuzzlePiece(cubeArray[3]),
                new PuzzlePiece(cubeArray[4]),
                new PuzzlePiece(cubeArray[5]));
    }
}
