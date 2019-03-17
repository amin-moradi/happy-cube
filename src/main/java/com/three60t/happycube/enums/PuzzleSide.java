package com.three60t.happycube.enums;

/**
 * This enum contains all side of puzzle
 *
 * @author Hossein Moradi
 * @since 3/15/19
 */
public enum PuzzleSide {
    TOP(1),
    BOTTOM(2),
    LEFT(3),
    RIGHT(4),
    BACK(5),
    FRONT(6);

    private final int value;

    PuzzleSide(int value) {
        this.value = value;
    }

    public static PuzzleSide findByValue(int value) {
        for (PuzzleSide v : values()) {
            if (v.value == value) {
                return v;
            }
        }
        throw new IllegalArgumentException("Input value is not valid!");
    }
}
