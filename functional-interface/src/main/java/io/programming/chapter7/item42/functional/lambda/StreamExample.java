package io.programming.chapter7.item42.functional.lambda;

import java.util.Arrays;

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
     * Collect has Supplier -> StringBuilder::new, Accumulator -> StringBuilder.append
     * & Combiner -> StringBuilder::append
     * @param word1 - Input Word
     * @return Sorted Word
     */
    private static String sortUsingStream(String word1) {
        return word1.chars().sorted().collect(StringBuilder::new,
                (sb, c) -> sb.append((char) c), StringBuilder::append)
                .toString();
    }

}
