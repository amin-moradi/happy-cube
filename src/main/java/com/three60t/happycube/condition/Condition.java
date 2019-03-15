package com.three60t.happycube.condition;

import com.three60t.happycube.puzzle.Puzzle;

/**
 * Any condition must implement this interface and isMatchCondition method
 *
 * @author Hossein Moradi
 * @since 3/15/19
 */
public interface Condition {
    /**
     * Every condition class must implement this method.
     *
     * @param puzzle : input puzzle
     * @return : if puzzle could pass condition, return true otherwise false
     */
    boolean isMatchCondition(Puzzle puzzle);
}
