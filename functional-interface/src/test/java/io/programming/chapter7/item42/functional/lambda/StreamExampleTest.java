package io.programming.chapter7.item42.functional.lambda;

import java.math.BigInteger;
import java.util.Collection;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * StreamExample Test Code
 */
public class StreamExampleTest {

    /**
     * Test for IsAnagram using Iterative API
     * 
     * @param word1    - Input1
     * @param word2    - Input 2
     * @param expected - Expected Value from Dataprovider.
     */
    @Test(dataProvider = "getAnagramDataProvider")
    public void testIsAnagramUsingIterative(String word1, String word2, boolean expected) {
        Assert.assertEquals(StreamExample.isAnagramUsingIterative(word1, word2), expected);
    }

    /**
     * Test for IsAnagram using Stream API
     * 
     * @param word1    - Input1
     * @param word2    - Input 2
     * @param expected - Expected Value from Dataprovider.
     */
    @Test(dataProvider = "getAnagramDataProvider")
    public void testIsAnagramUsingStream(String word1, String word2, boolean expected) {
        Assert.assertEquals(StreamExample.isAnagramUsingStreams(word1, word2), expected);
    }

    @DataProvider
    public Object[][] getAnagramDataProvider() {
        return new Object[][] {
                new Object[] { null, null, false },
                new Object[] { null, "a", false },
                new Object[] { "b", null, false },
                new Object[] { "petals", "staple", true },
                new Object[] { "etals", "taple", false },
        };
    }

    @Test
    public void testGetPrimes() {
        Collection<BigInteger> primes = StreamExample.getPrimes();
        System.out.println("Got Primes" + primes);
        Assert.assertEquals(primes.size(), 10);
    }

    @Test
    public void testGetInputPrimesAfterStreamElementsReuse() {
        Collection<Integer> primes = StreamExample.getInputPrimesAfterStreamElementsReuse();
        System.out.println("Got Primes" + primes);
        Assert.assertEquals(primes.size(), 10);
    }

}
