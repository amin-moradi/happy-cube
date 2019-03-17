package com.three60t.happycube.puzzle;

import com.three60t.happycube.enums.PuzzlePieceEdge;
import com.three60t.happycube.enums.PuzzleSide;
import com.three60t.happycube.utils.BinaryUtils;

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

    public StringBuilder getSecondRowOutputFormat() {
        StringBuilder result = new StringBuilder();
        PuzzlePiece leftPuzzlePiece = getLeftPuzzlePiece();
        PuzzlePiece bottomPuzzlePiece = getBottomPuzzlePiece();
        PuzzlePiece rightPuzzlePiece = getRightPuzzlePiece();
        for (int i = 0; i < 5; i++) {
            result.append(printRow(i, leftPuzzlePiece));
            result.append(printRow(i, bottomPuzzlePiece));
            result.append(printRow(i, rightPuzzlePiece));
            result.append("\n");
        }
        return result;
    }

    private StringBuilder printRow(int i, PuzzlePiece puzzlePiece) {
        StringBuilder builder = new StringBuilder();
        int[][] puzzlePieceArray = new int[5][5];
        for (int j = 0; j < 5; j++) {
            if (i == 0) {
                puzzlePieceArray[i][j] = BinaryUtils.getNthBit(puzzlePiece.isMirror() ? puzzlePiece.getReverseTopDecimalValue() : puzzlePiece.getTopDecimalValue(), j);
            } else if (i == 4) {
                puzzlePieceArray[i][j] = BinaryUtils.getNthBit(puzzlePiece.isMirror() ? puzzlePiece.getReverseBottomDecimalValue() : puzzlePiece.getBottomDecimalValue(), j);
            } else if (j == 0) {
                puzzlePieceArray[i][j] = BinaryUtils.getNthBit(puzzlePiece.isMirror() ? puzzlePiece.getReverseLeftDecimalValue() : puzzlePiece.getLeftDecimalValue(), i);
            } else if (j == 4) {
                puzzlePieceArray[i][j] = BinaryUtils.getNthBit(puzzlePiece.isMirror() ? puzzlePiece.getReverseRightDecimalValue() : puzzlePiece.getRightDecimalValue(), i);
            } else {
                puzzlePieceArray[i][j] = 1;
            }
            if (puzzlePieceArray[i][j] == 1) {
                builder.append("o");
            } else {
                builder.append(" ");
            }
        }
        return builder;
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
