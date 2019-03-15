package com.three60t.happycube.condition;

import com.three60t.happycube.cube.BlueCube;
import com.three60t.happycube.enums.PuzzlePieceEdge;
import com.three60t.happycube.enums.PuzzleSide;
import com.three60t.happycube.puzzle.Puzzle;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Hossein Moradi
 * @since 3/15/19
 */
public class VertexMatchConditionTest {
    final static Puzzle puzzle;

    static {
        puzzle = new BlueCube().getInputPuzzle();
    }

    @Test
    public void isMatchCondition_InvalidMatch_Success() {
        Condition condition = new VertexMatchCondition(PuzzleSide.TOP, PuzzlePieceEdge.TOP, 0, PuzzleSide.BACK, PuzzlePieceEdge.TOP, 4, PuzzleSide.BOTTOM, PuzzlePieceEdge.TOP, 4);
        Assert.assertTrue(condition.isMatchCondition(puzzle));
    }

    @Test
    public void isMatchCondition_InvalidMatch_Fail() {
        Condition condition = new VertexMatchCondition(PuzzleSide.BOTTOM, PuzzlePieceEdge.TOP, 0, PuzzleSide.BACK, PuzzlePieceEdge.TOP, 4, PuzzleSide.BOTTOM, PuzzlePieceEdge.TOP, 4);
        Assert.assertFalse(condition.isMatchCondition(puzzle));
    }
}
