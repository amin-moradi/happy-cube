package com.three60t.happycube.condition;

import com.three60t.happycube.enums.PuzzlePieceEdge;
import com.three60t.happycube.enums.PuzzleSide;
import com.three60t.happycube.puzzle.Puzzle;

/**
 * @author Hossein Moradi
 * @since 3/15/19
 */
public final class VertexMatchCondition implements Condition {
    private final PuzzleSide side1;
    private final PuzzlePieceEdge edge1;
    private final int index1;
    private final PuzzleSide side2;
    private final PuzzlePieceEdge edge2;
    private final int index2;
    private final PuzzleSide side3;
    private final PuzzlePieceEdge edge3;
    private final int index3;

    public VertexMatchCondition(PuzzleSide side1, PuzzlePieceEdge edge1, int index1, PuzzleSide side2, PuzzlePieceEdge edge2, int index2, PuzzleSide side3, PuzzlePieceEdge edge3, int index3) {
        this.side1 = side1;
        this.edge1 = edge1;
        this.index1 = index1;
        this.side2 = side2;
        this.edge2 = edge2;
        this.index2 = index2;
        this.side3 = side3;
        this.edge3 = edge3;
        this.index3 = index3;
    }

    @Override
    public boolean isMatchCondition(Puzzle puzzle) {
        return getNthBit(puzzle.getEdgeDecimalValue(side1, edge1), index1) + getNthBit(puzzle.getEdgeDecimalValue(side2, edge2), index2) + getNthBit(puzzle.getEdgeDecimalValue(side3, edge3), index3) == 1;
    }

    private int getNthBit(Integer edgeValue, int bitPosition) {
        Double bitValue = Math.pow(2.0, bitPosition);
        return (edgeValue & bitValue.intValue()) == bitValue ? 1 : 0;
    }
}