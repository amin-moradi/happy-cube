package com.three60t.happycube;

import com.three60t.happycube.cube.Cube;
import com.three60t.happycube.cube.RedCube;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


/**
 * @author Hossein Moradi
 * @since 3/15/19
 */
public class ApplicationMain {
    private static Logger logger = Logger.getLogger(ApplicationMain.class.getName());

    public static void main(String[] args) {
        BasicConfigurator.configure();

        Cube blueCube = new RedCube();
        if (blueCube.findSolutions().size() == 0) {
            logger.debug("Nothing found!");
        }
    }
}
