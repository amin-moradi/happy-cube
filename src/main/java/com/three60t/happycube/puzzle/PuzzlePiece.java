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
        this.isMirror = null;
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

    public boolean isThisMirror() {
        return isMirror();
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
                return null;
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
                return null;
        }
    }

    @Override
    public String toString() {
        return "PuzzlePiece{" +
                " id=" + id +
                ", topDecimalValue=" + String.format("%05d", Integer.parseInt(Integer.toBinaryString(topDecimalValue))) +
                ", rightDecimalValue=" + String.format("%05d", Integer.parseInt(Integer.toBinaryString(rightDecimalValue))) +
                ", bottomDecimalValue=" + String.format("%05d", Integer.parseInt(Integer.toBinaryString(bottomDecimalValue))) +
                ", leftDecimalValue=" + String.format("%05d", Integer.parseInt(Integer.toBinaryString(leftDecimalValue))) +
                ", reverseTopDecimalValue=" + String.format("%05d", Integer.parseInt(Integer.toBinaryString(reverseTopDecimalValue))) +
                ", reverseRightDecimalValue=" + String.format("%05d", Integer.parseInt(Integer.toBinaryString(reverseRightDecimalValue))) +
                ", reverseBottomDecimalValue=" + String.format("%05d", Integer.parseInt(Integer.toBinaryString(reverseBottomDecimalValue))) +
                ", reverseLeftDecimalValue=" + String.format("%05d", Integer.parseInt(Integer.toBinaryString(reverseLeftDecimalValue))) +
                ", isMirror=" + isMirror +
                '}';
    }
}
