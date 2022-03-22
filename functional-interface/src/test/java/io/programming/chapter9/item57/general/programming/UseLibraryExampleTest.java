package io.programming.chapter9.item57.general.programming;

import java.util.SplittableRandom;
import java.util.stream.IntStream;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UseLibraryExampleTest {

    /**
     * Generated 2/3 numbers generated are within lower half
     */
    @Test
    public void testGenerateRandomNumberWithoutKnowingRandom() {
        // Two third of Numbers
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++)
            // If Random Number falls within lower half of Tww third of Numbers
            if (UseLibraryExample.generateRandomNumberWithoutKnowingRandom() < n / 2)
                low++;
        System.out.println("Total Random Number Generated Less than Half of 1M Count is " + low);
    }

    /**
     * Generates exactly 1/2 numbers are within lower half
     * 
     * @param bound - Power of 2
     */
    @Test(dataProvider = "getBound")
    public void testGenerateRandomNumberKnowingRandom(int bound) {
        long startTime = System.currentTimeMillis();
        int n = bound / 2;
        int low = 0;
        for (int i = 0; i < 1000000; i++)
            if (UseLibraryExample.generateRandomNumberKnowingRandom(bound) < n)
                low++;
        System.out.println("Total Random Number Generated Less than Half of 1M Count is " + low +
                " For Bound " + bound);
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time Taken " + (endTime - startTime) + "ms for Execution");
    }

    /**
     * Generates exactly 1/2 numbers are within lower half
     * 
     * @param bound - Power of 2
     */
    @Test(dataProvider = "getBound")
    public void testGenerateRandomNumberEfficiently(int bound) {
        long startTime = System.currentTimeMillis();
        int range = bound / 2;
        long count = IntStream.range(0, 1000000).filter(value -> UseLibraryExample.generateRandomNumber(bound) < range)
                .count();
        System.out.println("[TLR] Total Random Number Generated Less than Half of 1M Count is " + count +
                " For Bound " + bound);
        long endTime = System.currentTimeMillis();
        System.out.println("[TLR] Total Time Taken " + (endTime - startTime) + "ms for Execution");
    }

    /**
     * Generates exactly 1/2 numbers are within lower half
     * 
     * @param bound - Power of 2
     */
    @Test(dataProvider = "getBound")
    public void testGenerateRandomNumberThreadEfficiently(int bound) {
        long startTime = System.currentTimeMillis();
        int range = bound / 2;
        SplittableRandom sr = new SplittableRandom();
        long count = sr.ints(1000000, 0, bound).parallel().filter(value -> value < range).count();
        System.out.println("[SR] Total Random Number Generated Less than Half of 1M Count is " + count +
                " For Bound " + bound);
        long endTime = System.currentTimeMillis();
        System.out.println("[SR] Total Time Taken " + (endTime - startTime) + "ms for Execution");
    }

    @DataProvider
    public Object[][] getBound() {
        return new Object[][] {
                new Object[] { 2 },
                new Object[] { 4 },
                new Object[] { 8 },
                new Object[] { 16 },
                new Object[] { 32 },
                new Object[] { 64 },
                new Object[] { 128 },
                new Object[] { 256 },
                new Object[] { 4096 },
                new Object[] { 8192 },
                new Object[] { 8192 * 2 },
                new Object[] { 8192 * 4 },
        };
    }

}
