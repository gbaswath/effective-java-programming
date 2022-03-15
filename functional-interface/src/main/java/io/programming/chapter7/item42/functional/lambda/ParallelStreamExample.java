package io.programming.chapter7.item42.functional.lambda;

import java.math.BigInteger;
import java.util.stream.LongStream;

/**
 * Item 48: Use Caution when making Streams Parallel
 */
public class ParallelStreamExample {

    /**
     * Get Prime Number Count till we reach given <code>endNumber</code>
     *
     * @param endNumber - Number of primes to be generated till end number
     * @return Number of primes generated count till end number
     */
    static long getPrimeNumbersCountSequence(long endNumber) {
        long primeNumbersCount = 0;
        if (endNumber < 2) {
            System.out.println("Invalid number to get prime numbers less than end number");
        } else {
            // LongStream of numbers start from 2
            primeNumbersCount = LongStream.rangeClosed(2, endNumber)
                    // Convert to BigInteger
                    .mapToObj(BigInteger::valueOf)
                    // Check if it is prime using magic number 50
                    .filter(number -> number.isProbablePrime(50))
                    // Return count of prime numbers
                    .count();
        }
        return primeNumbersCount;
    }

    /**
     * Get Prime Number Count till we reach given <code>endNumber</code> in parallel
     * fashion
     *
     * @param endNumber - Number of primes to be generated till end number
     * @return Number of primes generated count till end number using
     *         <code>stream's parallel</code>
     */
    static long getPrimeNumbersCountParallel(long endNumber) {
        long primeNumbersCount = 0;
        if (endNumber < 2) {
            System.out.println("Invalid number to get prime numbers less than end number");
        } else {
            primeNumbersCount = LongStream.rangeClosed(2, endNumber)
                    //Use Parallel Stream
                    .parallel()
                    .mapToObj(BigInteger::valueOf)
                    .filter(number -> number.isProbablePrime(50))
                    .count();
        }
        return primeNumbersCount;
    }
}
