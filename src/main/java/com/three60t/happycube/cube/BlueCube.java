package com.three60t.happycube.cube;

import com.three60t.happycube.puzzle.Puzzle;

/**
 * This concrete class is responsible for initiate input data that represents a puzzle (cube).
 * If you want to create another puzzle e.g. RedCube, YellowCube or PurpleCube, you have to
 * implement those classes and override initiateCube method.
 *
 * @author Hossein Moradi
 * @since 3/15/19
 */
public class BlueCube extends AbstractCube {
    @Override
    public Puzzle initiateCube() {
        //todo initiate puzzle for blue cube (use three-dimensional array for input date)
        return null;
    }
}
