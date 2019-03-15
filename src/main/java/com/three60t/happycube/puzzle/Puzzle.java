package com.three60t.happycube.puzzle;

/**
 * This class contains puzzle-pieces of each puzzle (6 puzzle-pieces --> top, bottom, left, right, back, front)
 *
 * @author Hossein Moradi
 * @since 3/15/19
 */
public class Puzzle {
    private PuzzlePiece topPuzzlePiece;
    private PuzzlePiece bottomPuzzlePiece;
    private PuzzlePiece leftPuzzlePiece;
    private PuzzlePiece rightPuzzlePiece;
    private PuzzlePiece backPuzzlePiece;
    private PuzzlePiece frontPuzzlePiece;

    public Puzzle(PuzzlePiece topPuzzlePiece, PuzzlePiece bottomPuzzlePiece, PuzzlePiece leftPuzzlePiece, PuzzlePiece rightPuzzlePiece, PuzzlePiece backPuzzlePiece, PuzzlePiece frontPuzzlePiece) {
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

    @Override
    public String toString() {
        return "Puzzle{" +
                "topPuzzlePiece=" + topPuzzlePiece +
                ", bottomPuzzlePiece=" + bottomPuzzlePiece +
                ", leftPuzzlePiece=" + leftPuzzlePiece +
                ", rightPuzzlePiece=" + rightPuzzlePiece +
                ", backPuzzlePiece=" + backPuzzlePiece +
                ", frontPuzzlePiece=" + frontPuzzlePiece +
                '}';
    }
}
