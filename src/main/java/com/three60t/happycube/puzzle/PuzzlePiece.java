package com.three60t.happycube.puzzle;

import com.three60t.happycube.enums.PuzzlePieceEdge;
import com.three60t.happycube.orientation.Orientation;
import com.three60t.happycube.utils.BinaryUtils;

import java.util.Arrays;

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

    /**
     * This method generate base puzzle data in array
     * @return : an array with puzzle data - 1 represents fill cell and 0 represents empty cell
     */
    public int[][] getArrayPuzzle() {
        int[][] arrayPuzzle = new int[5][5];
        //fill all cells with 1
        for (int x = 0; x < arrayPuzzle.length; x++)
            Arrays.fill(arrayPuzzle[x], 1);

        //fill top edge of array
        String topBinaryString = Integer.toBinaryString(getDecimalValueBySideAndMirror(PuzzlePieceEdge.TOP));
        char[] topCharArray = String.format("%05d", Integer.parseInt(topBinaryString)).toCharArray();
        arrayPuzzle[0][0] = Character.getNumericValue(topCharArray[0]);
        arrayPuzzle[0][1] = Character.getNumericValue(topCharArray[1]);
        arrayPuzzle[0][2] = Character.getNumericValue(topCharArray[2]);
        arrayPuzzle[0][3] = Character.getNumericValue(topCharArray[3]);
        arrayPuzzle[0][4] = Character.getNumericValue(topCharArray[4]);

        //fill right edge of array
        String rightBinaryString = Integer.toBinaryString(getDecimalValueBySideAndMirror(PuzzlePieceEdge.RIGHT));
        char[] rightCharArray = String.format("%05d", Integer.parseInt(rightBinaryString)).toCharArray();
        arrayPuzzle[0][4] = Character.getNumericValue(rightCharArray[0]);
        arrayPuzzle[1][4] = Character.getNumericValue(rightCharArray[1]);
        arrayPuzzle[2][4] = Character.getNumericValue(rightCharArray[2]);
        arrayPuzzle[3][4] = Character.getNumericValue(rightCharArray[3]);
        arrayPuzzle[4][4] = Character.getNumericValue(rightCharArray[4]);

        //fill bottom edge of array
        String bottomBinaryString = Integer.toBinaryString(getDecimalValueBySideAndMirror(PuzzlePieceEdge.BOTTOM));
        char[] bottomCharArray = String.format("%05d", Integer.parseInt(bottomBinaryString)).toCharArray();
        arrayPuzzle[4][4] = Character.getNumericValue(bottomCharArray[0]);
        arrayPuzzle[4][3] = Character.getNumericValue(bottomCharArray[1]);
        arrayPuzzle[4][2] = Character.getNumericValue(bottomCharArray[2]);
        arrayPuzzle[4][1] = Character.getNumericValue(bottomCharArray[3]);
        arrayPuzzle[4][0] = Character.getNumericValue(bottomCharArray[4]);

        //fill left edge of array
        String leftBinaryString = Integer.toBinaryString(getDecimalValueBySideAndMirror(PuzzlePieceEdge.LEFT));
        char[] leftCharArray = String.format("%05d", Integer.parseInt(leftBinaryString)).toCharArray();
        arrayPuzzle[4][0] = Character.getNumericValue(leftCharArray[0]);
        arrayPuzzle[3][0] = Character.getNumericValue(leftCharArray[1]);
        arrayPuzzle[2][0] = Character.getNumericValue(leftCharArray[2]);
        arrayPuzzle[1][0] = Character.getNumericValue(leftCharArray[3]);
        arrayPuzzle[0][0] = Character.getNumericValue(leftCharArray[4]);

        return arrayPuzzle;
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
