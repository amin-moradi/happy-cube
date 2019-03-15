package com.three60t.happycube.enums;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Hossein Moradi
 * @since 3/15/19
 */
public class PuzzleSideTest {
    @Test
    public void findByValue_CheckAllValue_Success() {
        Assert.assertSame(PuzzleSide.TOP, PuzzleSide.findByValue(1));
        Assert.assertSame(PuzzleSide.BOTTOM, PuzzleSide.findByValue(2));
        Assert.assertSame(PuzzleSide.LEFT, PuzzleSide.findByValue(3));
        Assert.assertSame(PuzzleSide.RIGHT, PuzzleSide.findByValue(4));
        Assert.assertSame(PuzzleSide.BACK, PuzzleSide.findByValue(5));
        Assert.assertSame(PuzzleSide.FRONT, PuzzleSide.findByValue(6));
    }

    @Test
    public void findByValue_CheckAllValue_Fail() {
        Assert.assertNotSame(PuzzleSide.FRONT, PuzzleSide.findByValue(1));
        Assert.assertNotSame(PuzzleSide.TOP, PuzzleSide.findByValue(2));
        Assert.assertNotSame(PuzzleSide.BOTTOM, PuzzleSide.findByValue(3));
        Assert.assertNotSame(PuzzleSide.LEFT, PuzzleSide.findByValue(4));
        Assert.assertNotSame(PuzzleSide.RIGHT, PuzzleSide.findByValue(5));
        Assert.assertNotSame(PuzzleSide.BACK, PuzzleSide.findByValue(6));
    }
}
