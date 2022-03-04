package io.programming.chapter7.item42.functional.lambda;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Item 45: Use Streams Judisiously
 */
public class StreamExample {

    /**
     * Anagram is a word jumbled with characters matching another word of same
     * characters.
     * 
     * @param word1 - Input Word1
     * @param word2 - Input Word2
     * @return true if anagram else false
     */
    static boolean isAnagramUsingIterative(String word1, String word2) {
        boolean isAnagram = false;
        if (word1 == null || word2 == null) {
            System.out.println("Invalid Arguments to Check for Anagram");
        } else {
            if (sortUsingIteration(word1).equals(sortUsingIteration(word2))) {
                System.out.println("Word1 & Word2 Characters are equal");
                isAnagram = true;
            } else {
                System.out.println("Word1 & Word2 is not anagram");
            }
        }
        return isAnagram;
    }

    /**
     * Sort Characters in String using Arrays.sort
     * 
     * @param word
     * @return
     */
    private static String sortUsingIteration(String word) {
        char[] wordCharacters = word.toCharArray();
        Arrays.sort(wordCharacters);
        return new String(wordCharacters);
    }

    /**
     * Anagram is a word jumbled with characters matching another word of same
     * characters.
     * 
     * @param word1 - Input Word1
     * @param word2 - Input Word2
     * @return true if anagram else false
     */
    static boolean isAnagramUsingStreams(String word1, String word2) {
        boolean isAnagram = false;
        if (word1 == null || word2 == null) {
            System.out.println("Invalid Arguments to Check for Anagram");
        } else {
            if (sortUsingStream(word1).equals(sortUsingStream(word2))) {
                System.out.println("Word1 & Word2 Characters are equal");
                isAnagram = true;
            } else {
                System.out.println("Word1 & Word2 is not anagram");
            }
        }
        return isAnagram;
    }

    /**
     * Collect has Supplier -> StringBuilder::new, Accumulator ->
     * StringBuilder.append
     * & Combiner -> StringBuilder::append
     * 
     * @param word1 - Input Word
     * @return Sorted Word
     */
    private static String sortUsingStream(String word1) {
        return word1.chars().sorted().collect(StringBuilder::new,
                (sb, c) -> sb.append((char) c), StringBuilder::append)
                .toString();
    }

    /**
     * Get Primes basis Mersenne Prime
     * 
     * @return
     */
    static List<BigInteger> getPrimes() {
        // Start of Stream is 2 and along with next prime number generator function
        Stream<BigInteger> probablePrimes = Stream.iterate(BigInteger.valueOf(2), BigInteger::nextProbablePrime);
        return probablePrimes
                // Mersenne Prime is of form 2^prime - 1 will also be prime. So map prime to
                // mersenne prime
                .map(prime -> BigInteger.valueOf(2).pow(prime.intValue()).subtract(BigInteger.ONE))
                // Filter value if it is prime by checking probabilistic primality test by using
                // magic number 50.
                .filter(prime -> prime.isProbablePrime(50))
                // Limit to 10 count.
                .limit(10)
                // Collect result into List
                .collect(Collectors.toList());
    }

    /**
     * Generate prime numbers which are also mersenne prime.
     * 
     * @return List of numbers that are responsible for generating mersenne prime.
     */
    static List<Integer> getInputPrimesAfterStreamElementsReuse() {
        Stream<BigInteger> probablePrimes = Stream.iterate(BigInteger.valueOf(2), BigInteger::nextProbablePrime);
        return probablePrimes
                // Mersenne Prime is of form 2^prime - 1 will also be prime. So map prime to
                // mersenne prime
                .map(prime -> BigInteger.valueOf(2).pow(prime.intValue()).subtract(BigInteger.ONE))
                // Invert mapping to get the exponent of mersenne prime
                .map(BigInteger::bitLength)
                // limit it to 10 count
                .limit(10)
                // Collect result into List
                .collect(Collectors.toList());
    }

    private static class Rank {

        @Override
        public String toString() {
            return "Rank []";
        }

    }

    private static class Suit {

        @Override
        public String toString() {
            return "Suit []";
        }

    }

    private static class Card {

        Rank rank;
        Suit suit;

        Card(Rank rank, Suit suit) {
            this.rank = rank;
            this.suit = suit;
        }

        static Card of(Rank rank, Suit suit) {
            return new Card(rank, suit);
        }

        @Override
        public String toString() {
            return "Card [rank=" + rank + ", suit=" + suit + "]";
        }
    }

    /**
     * Prepare 3 Ranks
     * 
     * @return List of Ranks
     */
    private static List<Rank> getRanks() {
        return Arrays.asList(new Rank(), new Rank(), new Rank());
    }

    /**
     * Prepare 3 Suits
     * 
     * @return List of Suits
     */
    private static List<Suit> getSuits() {
        return Arrays.asList(new Suit(), new Suit(), new Suit());
    }

    /**
     * Prepare Card Deck with Rank & Suit using Iterative Approach
     * 
     * @return List of Cards
     */
    static List<Card> getDeckUsingIterative() {
        List<Card> cards = new ArrayList<>();
        for (Rank rank : getRanks())
            for (Suit suit : getSuits())
                cards.add(Card.of(rank, suit));
        return cards;
    }

    /**
     * Prepare Card Deck Using Streams Way
     * 
     * @return
     */
    static List<Card> getDeckUsingStreams() {
        return getSuits().stream()
                // Intermediate Operation FlatMap to convert Suit Collectin & Rank Collection to
                // Card Collection
                .flatMap(suit -> getRanks().stream().map(rank -> Card.of(rank, suit)))
                // Terminal Operation Collect
                .collect(Collectors.toList());
    }
}
