package com.three60t.happycube.cube;

import com.three60t.happycube.condition.Condition;
import com.three60t.happycube.condition.EdgeMiddleMatchCondition;
import com.three60t.happycube.condition.VertexMatchCondition;
import com.three60t.happycube.enums.PuzzlePieceEdge;
import com.three60t.happycube.enums.PuzzleSide;
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
    private final static List<Condition> CONDITIONS = new ArrayList<>(20); //For each puzzle-piece, we have to check 20 conditions according to analysis (12 for edges, 8 for vertices)
    private final static List<Orientation> ORIENTATIONS = new ArrayList<>(8); //Each puzzle-piece can have 8 different orientations according to rotating and mirroring
    private Puzzle inputPuzzle; // This field contains input data given by concrete classes, e.g. BlueCube
    private Set<Puzzle> solutions = Collections.synchronizedSet(new HashSet<>()); // This field contains all possible solutions for given puzzle

    static {
        //conditions for middle of edges (not vertices) --> 12 conditions
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.TOP, PuzzlePieceEdge.TOP, PuzzleSide.BACK, PuzzlePieceEdge.TOP));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.TOP, PuzzlePieceEdge.BOTTOM, PuzzleSide.FRONT, PuzzlePieceEdge.TOP));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.TOP, PuzzlePieceEdge.LEFT, PuzzleSide.LEFT, PuzzlePieceEdge.TOP));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.TOP, PuzzlePieceEdge.RIGHT, PuzzleSide.RIGHT, PuzzlePieceEdge.TOP));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.BOTTOM, PuzzlePieceEdge.TOP, PuzzleSide.BACK, PuzzlePieceEdge.BOTTOM));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.BOTTOM, PuzzlePieceEdge.BOTTOM, PuzzleSide.FRONT, PuzzlePieceEdge.BOTTOM));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.BOTTOM, PuzzlePieceEdge.LEFT, PuzzleSide.LEFT, PuzzlePieceEdge.BOTTOM));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.BOTTOM, PuzzlePieceEdge.RIGHT, PuzzleSide.RIGHT, PuzzlePieceEdge.BOTTOM));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.BACK, PuzzlePieceEdge.LEFT, PuzzleSide.RIGHT, PuzzlePieceEdge.RIGHT));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.BACK, PuzzlePieceEdge.RIGHT, PuzzleSide.LEFT, PuzzlePieceEdge.LEFT));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.FRONT, PuzzlePieceEdge.RIGHT, PuzzleSide.RIGHT, PuzzlePieceEdge.LEFT));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.FRONT, PuzzlePieceEdge.LEFT, PuzzleSide.LEFT, PuzzlePieceEdge.RIGHT));

        //conditions just for vertices --> 8 conditions
        CONDITIONS.add(new VertexMatchCondition(PuzzleSide.TOP, PuzzlePieceEdge.TOP, 4, PuzzleSide.RIGHT, PuzzlePieceEdge.TOP, 4, PuzzleSide.BACK, PuzzlePieceEdge.TOP, 0));
        CONDITIONS.add(new VertexMatchCondition(PuzzleSide.TOP, PuzzlePieceEdge.TOP, 0, PuzzleSide.LEFT, PuzzlePieceEdge.TOP, 0, PuzzleSide.BACK, PuzzlePieceEdge.TOP, 4));
        CONDITIONS.add(new VertexMatchCondition(PuzzleSide.TOP, PuzzlePieceEdge.BOTTOM, 0, PuzzleSide.FRONT, PuzzlePieceEdge.TOP, 0, PuzzleSide.LEFT, PuzzlePieceEdge.TOP, 4));
        CONDITIONS.add(new VertexMatchCondition(PuzzleSide.TOP, PuzzlePieceEdge.BOTTOM, 4, PuzzleSide.FRONT, PuzzlePieceEdge.TOP, 4, PuzzleSide.RIGHT, PuzzlePieceEdge.TOP, 0));
        CONDITIONS.add(new VertexMatchCondition(PuzzleSide.BOTTOM, PuzzlePieceEdge.TOP, 4, PuzzleSide.RIGHT, PuzzlePieceEdge.BOTTOM, 4, PuzzleSide.BACK, PuzzlePieceEdge.BOTTOM, 0));
        CONDITIONS.add(new VertexMatchCondition(PuzzleSide.BOTTOM, PuzzlePieceEdge.TOP, 0, PuzzleSide.LEFT, PuzzlePieceEdge.BOTTOM, 0, PuzzleSide.BACK, PuzzlePieceEdge.BOTTOM, 4));
        CONDITIONS.add(new VertexMatchCondition(PuzzleSide.BOTTOM, PuzzlePieceEdge.BOTTOM, 4, PuzzleSide.RIGHT, PuzzlePieceEdge.BOTTOM, 0, PuzzleSide.FRONT, PuzzlePieceEdge.BOTTOM, 4));
        CONDITIONS.add(new VertexMatchCondition(PuzzleSide.BOTTOM, PuzzlePieceEdge.BOTTOM, 0, PuzzleSide.LEFT, PuzzlePieceEdge.BOTTOM, 4, PuzzleSide.FRONT, PuzzlePieceEdge.BOTTOM, 0));
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
