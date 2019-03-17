package com.three60t.happycube.puzzle;

import com.three60t.happycube.enums.PuzzlePieceEdge;
import com.three60t.happycube.orientation.Orientation;
import com.three60t.happycube.utils.BinaryUtils;

/**
 * This class contains decimal values of each edge of puzzle-piece (4 edges --> top, bottom, left, right)
 *
 * //todo we have to create PuzzlePice interface that NormalPuzzlePiece and MirroredPuzzlePiece implement that
 *
 * @author Hossein Moradi
 * @since 3/15/19
 */
public final class PuzzlePiece {
    private final Integer id;
    private final Integer topDecimalValue;
    private final Integer rightDecimalValue;
    private final Integer bottomDecimalValue;
    private final Integer leftDecimalValue;

    private final Integer reverseTopDecimalValue;
    private final Integer reverseRightDecimalValue;
    private final Integer reverseBottomDecimalValue;
    private final Integer reverseLeftDecimalValue;

    private final Boolean isMirror;

    public PuzzlePiece(int[][] puzzleArray, Integer id) {
        this.id = id;
        //convert binary to decimal
        this.topDecimalValue = Integer.parseInt(String.valueOf(puzzleArray[0][0]) + String.valueOf(puzzleArray[0][1]) + String.valueOf(puzzleArray[0][2]) + String.valueOf(puzzleArray[0][3]) + String.valueOf(puzzleArray[0][4]), 2);
        this.rightDecimalValue = Integer.parseInt(String.valueOf(puzzleArray[0][4]) + String.valueOf(puzzleArray[1][4]) + String.valueOf(puzzleArray[2][4]) + String.valueOf(puzzleArray[3][4]) + String.valueOf(puzzleArray[4][4]), 2);
        this.bottomDecimalValue = Integer.parseInt(String.valueOf(puzzleArray[4][4]) + String.valueOf(puzzleArray[4][3]) + String.valueOf(puzzleArray[4][2]) + String.valueOf(puzzleArray[4][1]) + String.valueOf(puzzleArray[4][0]), 2);
        this.leftDecimalValue = Integer.parseInt(String.valueOf(puzzleArray[4][0]) + String.valueOf(puzzleArray[3][0]) + String.valueOf(puzzleArray[2][0]) + String.valueOf(puzzleArray[1][0]) + String.valueOf(puzzleArray[0][0]), 2);
        //convert binary to decimal (reverse in array) --> for better performance
        this.reverseTopDecimalValue = BinaryUtils.reverseBits(this.getTopDecimalValue());
        this.reverseRightDecimalValue = BinaryUtils.reverseBits(this.getRightDecimalValue());
        this.reverseBottomDecimalValue = BinaryUtils.reverseBits(this.getBottomDecimalValue());
        this.reverseLeftDecimalValue = BinaryUtils.reverseBits(this.getLeftDecimalValue());
        this.isMirror = false;
    }

    public PuzzlePiece(PuzzlePiece puzzlePiece, Orientation orientation) {
        this.id = puzzlePiece.getId();
        this.isMirror = orientation.isMirror();
        this.topDecimalValue = puzzlePiece.getDecimalValueBySide(orientation.getEdge1());
        this.rightDecimalValue = puzzlePiece.getDecimalValueBySide(orientation.getEdge2());
        this.bottomDecimalValue = puzzlePiece.getDecimalValueBySide(orientation.getEdge3());
        this.leftDecimalValue = puzzlePiece.getDecimalValueBySide(orientation.getEdge4());
        this.reverseTopDecimalValue = puzzlePiece.getReverseDecimalValueBySide(orientation.getEdge1());
        this.reverseRightDecimalValue = puzzlePiece.getReverseDecimalValueBySide(orientation.getEdge2());
        this.reverseBottomDecimalValue = puzzlePiece.getReverseDecimalValueBySide(orientation.getEdge3());
        this.reverseLeftDecimalValue = puzzlePiece.getReverseDecimalValueBySide(orientation.getEdge4());
    }

    public Integer getId() {
        return id;
    }

    public Integer getTopDecimalValue() {
        return topDecimalValue;
    }

    public Integer getRightDecimalValue() {
        return rightDecimalValue;
    }

    public Integer getBottomDecimalValue() {
        return bottomDecimalValue;
    }

    public Integer getLeftDecimalValue() {
        return leftDecimalValue;
    }

    public Integer getReverseTopDecimalValue() {
        return reverseTopDecimalValue;
    }

    public Integer getReverseRightDecimalValue() {
        return reverseRightDecimalValue;
    }

    public Integer getReverseBottomDecimalValue() {
        return reverseBottomDecimalValue;
    }

    public Integer getReverseLeftDecimalValue() {
        return reverseLeftDecimalValue;
    }

    public boolean isMirror() {
        return isMirror;
    }

    public Integer getReverseDecimalValueBySide(PuzzlePieceEdge edge) {
        return getReverseDecimalValue(edge);
    }

    public Integer getDecimalValueBySide(PuzzlePieceEdge edge) {
        return getDecimalValue(edge);
    }

    public Integer getDecimalValueBySideAndMirror(PuzzlePieceEdge edge) {
        if (isMirror()) {
            return getReverseDecimalValue(edge);
        } else {
            return getDecimalValue(edge);
        }
    }

    private Integer getReverseDecimalValue(PuzzlePieceEdge edge) {
        switch (edge) {
            case TOP:
                return getReverseTopDecimalValue();
            case RIGHT:
                return getReverseRightDecimalValue();
            case BOTTOM:
                return getReverseBottomDecimalValue();
            case LEFT:
                return getReverseLeftDecimalValue();
            default:
                throw new IllegalArgumentException("PuzzlePieceEdge is not valid!");
        }
    }

    private Integer getDecimalValue(PuzzlePieceEdge edge) {
        switch (edge) {
            case TOP:
                return getTopDecimalValue();
            case RIGHT:
                return getRightDecimalValue();
            case BOTTOM:
                return getBottomDecimalValue();
            case LEFT:
                return getLeftDecimalValue();
            default:
                throw new IllegalArgumentException("PuzzlePieceEdge is not valid!");
        }
    }

    public StringBuilder getOutputFormat(int row) {
        StringBuilder result = new StringBuilder();
        CharSequence cSeq = "     ";
        int[][] puzzlePieceArray = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringBuilder builder;
            if (row != 2) {
                builder = new StringBuilder(cSeq);
            } else {
                builder = new StringBuilder();
            }
            //todo duplicate code!
            for (int j = 0; j < 5; j++) {
                if (i == 0) {
                    puzzlePieceArray[i][j] = BinaryUtils.getNthBit(isMirror() ? getReverseTopDecimalValue() : getTopDecimalValue(), j);
                } else if (i == 4) {
                    puzzlePieceArray[i][j] = BinaryUtils.getNthBit(isMirror() ? getReverseBottomDecimalValue() : getBottomDecimalValue(), j);
                } else if (j == 0) {
                    puzzlePieceArray[i][j] = BinaryUtils.getNthBit(isMirror() ? getReverseLeftDecimalValue() : getLeftDecimalValue(), i);
                } else if (j == 4) {
                    puzzlePieceArray[i][j] = BinaryUtils.getNthBit(isMirror() ? getReverseRightDecimalValue() : getRightDecimalValue(), i);
                } else {
                    puzzlePieceArray[i][j] = 1;
                }
                if (puzzlePieceArray[i][j] == 1) {
                    builder.append("o");
                } else {
                    builder.append(" ");
                }
            }

            builder.append(cSeq);
            if (i != 4 || row != 2) {
                builder.append("\n");
            }
            result.append(builder);
        }
        return result;
    }

    @Override
    public String toString() {
        return "PuzzlePiece{" +
                " id=" + id +
                ", topBinaryValue=" + String.format("%05d", Integer.parseInt(Integer.toBinaryString(topDecimalValue))) +
                ", rightBinaryValue=" + String.format("%05d", Integer.parseInt(Integer.toBinaryString(rightDecimalValue))) +
                ", bottomBinaryValue=" + String.format("%05d", Integer.parseInt(Integer.toBinaryString(bottomDecimalValue))) +
                ", leftBinaryValue=" + String.format("%05d", Integer.parseInt(Integer.toBinaryString(leftDecimalValue))) +
                ", reverseTopBinaryValue=" + String.format("%05d", Integer.parseInt(Integer.toBinaryString(reverseTopDecimalValue))) +
                ", reverseRightBinaryValue=" + String.format("%05d", Integer.parseInt(Integer.toBinaryString(reverseRightDecimalValue))) +
                ", reverseBottomBinaryValue=" + String.format("%05d", Integer.parseInt(Integer.toBinaryString(reverseBottomDecimalValue))) +
                ", reverseLeftBinaryValue=" + String.format("%05d", Integer.parseInt(Integer.toBinaryString(reverseLeftDecimalValue))) +
                ", isMirror=" + isMirror +
                '}';
    }
}
