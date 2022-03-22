package io.programming.chapter9.item57.general.programming;

import java.util.Random;

/**
 * Item 59: Know & Use Libraries
 */
public class UseLibraryExample {

    private static Random random = new Random();

    /**
     * Generates random number with 3 flaws
     * 
     * 1. It cannot generate efficient random number it may get repeated as shown in
     * test case
     * 2. It is using Math.abs to generate positive value but in case of
     * Integer.MIN_VALUE is returned then it will throw Arithmetic Exception
     * 3. Random number generation is not bounded so it may not be expected to
     * return expected value within range
     * 
     * @return PseudorandomNumber
     */
    static int generateRandomNumberWithoutKnowingRandom() {
        return Math.abs(new Random().nextInt());
    }

    /**
     * Generate PseudoRandomNumber within bound which fixes above 3 flaws.
     * 
     * 1. It can generate efficient random number it may get repeated as shown in
     * test case
     * 2. It doesn't use Math.abs instead uses Bound
     * 3. Random number generation is bounded by given bound
     * 
     * @param bound Upper Bound to generate Random Number
     * @return Pseudo Random Number
     */
    static int generateRandomNumberKnowingRandom(int bound) {
        return random.nextInt(bound);
    }
}
