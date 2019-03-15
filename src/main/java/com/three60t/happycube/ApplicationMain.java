package com.three60t.happycube;

import com.three60t.happycube.cube.BlueCube;
import com.three60t.happycube.cube.Cube;


/**
 * @author Hossein Moradi
 * @since 3/15/19
 */
public class ApplicationMain {
    public static void main(String[] args) {
        Cube blueCube = new BlueCube();
        blueCube.findSolutions();
    }
}
