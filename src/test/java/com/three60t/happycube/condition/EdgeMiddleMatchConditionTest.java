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
public class EdgeMiddleMatchConditionTest {
    final static Puzzle puzzle;

    static {
        puzzle = new BlueCube().getInputPuzzle();
    }

    @Test
    public void isMatchCondition_CorrectMatch_Success() {
        Condition condition = new EdgeMiddleMatchCondition(PuzzleSide.TOP, PuzzlePieceEdge.TOP, PuzzleSide.BACK, PuzzlePieceEdge.TOP);
        Assert.assertTrue(condition.isMatchCondition(puzzle));
    }

    @Test
    public void isMatchCondition_InvalidMatch_Fail() {
        Condition condition = new EdgeMiddleMatchCondition(PuzzleSide.BACK, PuzzlePieceEdge.TOP, PuzzleSide.RIGHT, PuzzlePieceEdge.TOP);
        Assert.assertFalse(condition.isMatchCondition(puzzle));
    }
}
