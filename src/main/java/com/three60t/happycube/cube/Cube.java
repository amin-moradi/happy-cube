package com.three60t.happycube.cube;

import com.three60t.happycube.puzzle.Puzzle;

import java.util.Map;

public interface Cube {
    /**
     * This method must be implemented by concrete classes
     *
     * @return return Puzzle according to 3-dimensional array
     */
    Puzzle initiateCube();

    /**
     * This method find all possible solutions for happy cube task
     *
     * @return solutions will return as Map of <solution number, Puzzle>
     */
    Map<Integer, Puzzle> findSolutions();

    /**
     * This method must save solutions e.g. into file
     */
    void saveSolutions();
}
