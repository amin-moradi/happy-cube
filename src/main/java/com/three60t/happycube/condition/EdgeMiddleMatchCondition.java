package com.three60t.happycube.condition;

import com.three60t.happycube.enums.PuzzlePieceEdge;
import com.three60t.happycube.enums.PuzzleSide;
import com.three60t.happycube.puzzle.Puzzle;
import com.three60t.happycube.utils.BinaryUtils;

/**
 * @author Hossein Moradi
 * @since 3/15/19
 */
public class EdgeMiddleMatchCondition implements Condition {
    private final static int MIDDLE_PUZZLE_VALUE =  Integer.parseInt("01110", 2);
    private final PuzzleSide side1;
    private final PuzzlePieceEdge edge1;
    private final PuzzleSide side2;
    private final PuzzlePieceEdge edge2;

    public EdgeMiddleMatchCondition(PuzzleSide side1, PuzzlePieceEdge edge1, PuzzleSide side2, PuzzlePieceEdge edge2) {
        this.side1 = side1;
        this.edge1 = edge1;
        this.side2 = side2;
        this.edge2 = edge2;
    }

    @Override
    public boolean isMatchCondition(Puzzle puzzle) {
        int mask1 = puzzle.getEdgeDecimalValue(side1, edge1) & MIDDLE_PUZZLE_VALUE;
        // for mask --> we reverse second value, because we first puzzle-piece must match with reverse of second puzzle-piece
        int mask2 = BinaryUtils.reverseBits(puzzle.getEdgeDecimalValue(side2, edge2)) & MIDDLE_PUZZLE_VALUE;
        return (mask1 ^ mask2) == MIDDLE_PUZZLE_VALUE;
    }
}
