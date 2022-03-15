package io.programming.chapter7.item42.functional.lambda;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelStreamExampleTest {

    @Test(dataProvider = "getEndNumbers")
    public void testGetPrimeNumbersCount(long endNumber, long expectedOutput) {
        Assert.assertEquals(ParallelStreamExample.getPrimeNumbersCountSequence(endNumber), expectedOutput);
    }

    @DataProvider
    public static Object[][] getEndNumbers() {
        return new Object[][] {
                new Object[] { -1, 0 },
                new Object[] { 1, 0 },
                new Object[] { 0, 0 },
                new Object[] { 2, 1 },
                new Object[] { 7, 4 },
                new Object[] { 1000, 168 },
        };
    }
}
