package io.programming.chapter9.item57.general.programming;

import java.math.BigDecimal;

/**
 * Item 60: Avoid Float & Double if exact answers are required
 */
public class BigDecimalExample {

    /**
     * Find Remaining amount after it is used using float datatype
     * 
     * @param initial - Current Amount
     * @param used    - Used Amount
     * @return remaining amount
     */
    static float findRemaining(float initial, float used) {
        if (used <= initial) {
            return initial - used;
        } else {
            return 0;
        }
    }

    /**
     * Find Remaining amount after it is used using double datatype
     * 
     * @param initial - Current Amount
     * @param used    - Used Amount
     * @return remaining amount
     */
    static double findRemaining(double initial, double used) {
        if (used <= initial) {
            return initial - used;
        } else {
            return 0;
        }
    }

    /**
     * Find Remaining amount after it is used using BigDecimal datatype
     * 
     * @param initial - Current Amount
     * @param used    - Used Amount
     * @return remaining amount
     */
    static BigDecimal findRemainingExact(String initial, String used) {
        BigDecimal initialBD = new BigDecimal(initial);
        BigDecimal usedBD = new BigDecimal(used);
        if (usedBD.compareTo(initialBD) <=0) {
            return initialBD.subtract(usedBD);
        } else {
            return BigDecimal.valueOf(0);
        }
    }
}
