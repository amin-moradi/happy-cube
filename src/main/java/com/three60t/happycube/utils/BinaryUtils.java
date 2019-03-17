package com.three60t.happycube.utils;

/**
 * @author Hossein Moradi
 * @since 3/15/19
 */
public class BinaryUtils {
    /**
     * This method reverse bits of given decimal number.
     *
     * @param x : input decimal number
     * @return : output decimal number
     */
    public static int reverseBits(int x) {
        //" %05d" pad zeroes on the left so that total length must be 5.
        String binaryValue = String.format("%05d", Integer.parseInt(Integer.toBinaryString(x)));
        return Integer.parseInt(new StringBuffer(binaryValue).reverse().toString(), 2);
    }
}
