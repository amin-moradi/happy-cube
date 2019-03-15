package com.three60t.happycube.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Hossein Moradi
 * @since 3/15/19
 */
public class PermutationsTest {
    @Test
    public void of_CountOfPermutations1_Success() {
        Assert.assertEquals(720, Permutations.of(Arrays.asList(1, 2, 3, 4, 5, 6)).count());
    }

    @Test
    public void of_CountOfPermutations2_Success() {
        Assert.assertEquals(24, Permutations.of(Arrays.asList(1, 2, 3, 4)).count());
    }

    @Test
    public void of_CountOfPermutations1_Fail() {
        Assert.assertNotEquals(700, Permutations.of(Arrays.asList(1, 2, 3, 4, 5, 6)).count());
    }

    @Test
    public void of_CountOfPermutations2_Fail() {
        Assert.assertNotEquals(20, Permutations.of(Arrays.asList(1, 2, 3, 4)).count());
    }
}
