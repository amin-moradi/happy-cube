package com.three60t.happycube.puzzle;

import com.three60t.happycube.enums.PuzzlePieceEdge;
import com.three60t.happycube.enums.PuzzleSide;

/**
 * This class contains puzzle-pieces of each puzzle (6 puzzle-pieces --> top, bottom, left, right, back, front)
 *
 * @author Hossein Moradi
 * @since 3/15/19
 */
public final class Puzzle {
    private final PuzzlePiece topPuzzlePiece;
    private final PuzzlePiece bottomPuzzlePiece;
    private final PuzzlePiece leftPuzzlePiece;
    private final PuzzlePiece rightPuzzlePiece;
    private final PuzzlePiece backPuzzlePiece;
    private final PuzzlePiece frontPuzzlePiece;

    public Puzzle(PuzzlePiece topPuzzlePiece
            , PuzzlePiece bottomPuzzlePiece
            , PuzzlePiece leftPuzzlePiece
            , PuzzlePiece rightPuzzlePiece
            , PuzzlePiece backPuzzlePiece
            , PuzzlePiece frontPuzzlePiece) {
        this.topPuzzlePiece = topPuzzlePiece;
        this.bottomPuzzlePiece = bottomPuzzlePiece;
        this.leftPuzzlePiece = leftPuzzlePiece;
        this.rightPuzzlePiece = rightPuzzlePiece;
        this.backPuzzlePiece = backPuzzlePiece;
        this.frontPuzzlePiece = frontPuzzlePiece;
    }

    public PuzzlePiece getTopPuzzlePiece() {
        return topPuzzlePiece;
    }

    public PuzzlePiece getBottomPuzzlePiece() {
        return bottomPuzzlePiece;
    }

    public PuzzlePiece getLeftPuzzlePiece() {
        return leftPuzzlePiece;
    }

    public PuzzlePiece getRightPuzzlePiece() {
        return rightPuzzlePiece;
    }

    public PuzzlePiece getBackPuzzlePiece() {
        return backPuzzlePiece;
    }

    public PuzzlePiece getFrontPuzzlePiece() {
        return frontPuzzlePiece;
    }

    public Integer getEdgeDecimalValue(PuzzleSide side, PuzzlePieceEdge edge) {
        return getPuzzlePiece(side).getDecimalValueBySideAndMirror(edge);
    }

    public PuzzlePiece getPuzzlePiece(PuzzleSide side) {
        switch (side) {
            case TOP:
                return getTopPuzzlePiece();
            case BOTTOM:
                return getBottomPuzzlePiece();
            case LEFT:
                return getLeftPuzzlePiece();
            case RIGHT:
                return getRightPuzzlePiece();
            case BACK:
                return getBackPuzzlePiece();
            case FRONT:
                return getFrontPuzzlePiece();
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "Puzzle{" + "\n" +
                " topPuzzlePiece=" + topPuzzlePiece + "\n" +
                ",bottomPuzzlePiece=" + bottomPuzzlePiece + "\n" +
                ",leftPuzzlePiece=" + leftPuzzlePiece + "\n" +
                ",rightPuzzlePiece=" + rightPuzzlePiece + "\n" +
                ",backPuzzlePiece=" + backPuzzlePiece + "\n" +
                ",frontPuzzlePiece=" + frontPuzzlePiece + "\n" +
                '}';
    }
}
