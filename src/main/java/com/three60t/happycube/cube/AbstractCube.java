package com.three60t.happycube.cube;

import com.three60t.happycube.condition.Condition;
import com.three60t.happycube.orientation.Orientation;
import com.three60t.happycube.puzzle.Puzzle;

import java.util.*;

/**
 * This abstract class contains all static data structures e.g. CONDITIONS, ORIENTATIONS
 * And contains all non-static data structures e.g. inputPuzzle, solutions.
 * Additionally some private methods used by findSolutions and saveSolutions methods must
 * be place in this class.
 *
 * @author Hossein Moradi
 * @since 3/15/19
 */
public abstract class AbstractCube implements Cube {
    private final static List<Condition> CONDITIONS = new ArrayList<>(28); //For each puzzle-piece, we have to check 28 conditions according to analysis (12 for edges, 12 for middle edges, 8 for vertices)
    private final static List<Orientation> ORIENTATIONS = new ArrayList<>(8); //Each puzzle-piece can have 8 different orientations according to rotating and mirroring
    private Puzzle inputPuzzle; // This field contains input data given by concrete classes, e.g. BlueCube
    private Set<Puzzle> solutions = Collections.synchronizedSet(new HashSet<>()); // This field contains all possible solutions for given puzzle

    static {
        //todo initiate conditions and orientations. These are static because define once
    }

    AbstractCube() {
        this.inputPuzzle = initiateCube();
    }

    @Override
    public void findSolutions() {
        //todo find solutions
    }

    @Override
    public void saveSolutions() {
        //todo save solutions to file
    }
}
