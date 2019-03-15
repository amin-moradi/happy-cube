package com.three60t.happycube.puzzle;

import com.three60t.happycube.enums.PuzzlePieceEdge;

/**
 * This class contains decimal values of each edge of puzzle-piece (4 edges --> top, bottom, left, right)
 *
 * @author Hossein Moradi
 * @since 3/15/19
 */
public class PuzzlePiece {
    private Integer topDecimalValue;
    private Integer bottomDecimalValue;
    private Integer leftDecimalValue;
    private Integer rightDecimalValue;

    public PuzzlePiece(int[][] puzzleArray) {
        //convert binary to decimal
        this.topDecimalValue = Integer.parseInt(String.valueOf(puzzleArray[0][0]) + String.valueOf(puzzleArray[0][1]) + String.valueOf(puzzleArray[0][2]) + String.valueOf(puzzleArray[0][3]) + String.valueOf(puzzleArray[0][4]), 2);
        this.bottomDecimalValue = Integer.parseInt(String.valueOf(puzzleArray[4][0]) + String.valueOf(puzzleArray[4][1]) + String.valueOf(puzzleArray[4][2]) + String.valueOf(puzzleArray[4][3]) + String.valueOf(puzzleArray[4][4]), 2);
        this.leftDecimalValue = Integer.parseInt(String.valueOf(puzzleArray[0][0]) + String.valueOf(puzzleArray[1][0]) + String.valueOf(puzzleArray[2][0]) + String.valueOf(puzzleArray[3][0]) + String.valueOf(puzzleArray[4][0]), 2);
        this.rightDecimalValue = Integer.parseInt(String.valueOf(puzzleArray[0][4]) + String.valueOf(puzzleArray[1][4]) + String.valueOf(puzzleArray[2][4]) + String.valueOf(puzzleArray[3][4]) + String.valueOf(puzzleArray[4][4]), 2);
    }

    public Integer getTopDecimalValue() {
        return topDecimalValue;
    }

    public Integer getBottomDecimalValue() {
        return bottomDecimalValue;
    }

    public Integer getLeftDecimalValue() {
        return leftDecimalValue;
    }

    public Integer getRightDecimalValue() {
        return rightDecimalValue;
    }

    public Integer getDecimalValueBySide(PuzzlePieceEdge edge) {
        switch (edge) {
            case TOP:
                return getTopDecimalValue();
            case BOTTOM:
                return getBottomDecimalValue();
            case LEFT:
                return getLeftDecimalValue();
            case RIGHT:
                return getRightDecimalValue();
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "PuzzlePiece{" +
                "topDecimalValue=" + topDecimalValue +
                ", bottomDecimalValue=" + bottomDecimalValue +
                ", leftDecimalValue=" + leftDecimalValue +
                ", rightDecimalValue=" + rightDecimalValue +
                '}';
    }
}
