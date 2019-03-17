package com.three60t.happycube.orientation;

import com.three60t.happycube.enums.PuzzlePieceEdge;

/**
 * @author Hossein Moradi
 * @since 3/15/19
 */
public class Orientation {
    private PuzzlePieceEdge edge1;
    private PuzzlePieceEdge edge2;
    private PuzzlePieceEdge edge3;
    private PuzzlePieceEdge edge4;
    private boolean isMirror;

    public Orientation(PuzzlePieceEdge edge1, PuzzlePieceEdge edge2, PuzzlePieceEdge edge3, PuzzlePieceEdge edge4, boolean isMirror) {
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.edge3 = edge3;
        this.edge4 = edge4;
        this.isMirror = isMirror;
    }

    public PuzzlePieceEdge getEdge1() {
        return edge1;
    }

    public PuzzlePieceEdge getEdge2() {
        return edge2;
    }

    public PuzzlePieceEdge getEdge3() {
        return edge3;
    }

    public PuzzlePieceEdge getEdge4() {
        return edge4;
    }

    public boolean isMirror() {
        return isMirror;
    }
}
