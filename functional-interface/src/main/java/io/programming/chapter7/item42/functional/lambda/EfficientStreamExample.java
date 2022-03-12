package io.programming.chapter7.item42.functional.lambda;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Item 46: Prefer Side Effect Free Streams
 */
public class EfficientStreamExample {

    /**
     * Returns mapping count for each occurrence of word using for each terminal
     * operation.
     * 
     * @param words - Input words to prepare frequency mapping
     * @return Mapping of words and its frequency
     */
    static Map<String, Long> getFrequenciesForWordUsingForEach(Set<String> words) {
        Map<String, Long> frequencyMap = null;
        if (words == null || words.isEmpty()) {
            System.out.println("Words should not empty to get frequencies");
        } else {
            Map<String, Long> resultMap = new HashMap<>();
            words.forEach(word -> resultMap.merge(word.toLowerCase(), 1L, Long::sum));
            frequencyMap = resultMap;
        }
        return frequencyMap;
    }

    /**
     * Returns mapping count for each occurrence of word in given <code>words</code>
     *
     * @param words - Input words to prepare frequency mapping
     * @return Mapping of words and its frequency
     */
    static Map<String, Long> getFrequenciesForWordUsingStream(Set<String> words) {
        Map<String, Long> frequencyMap = null;
        if (words == null || words.isEmpty()) {
            System.out.println("Words should not empty to get frequencies");
        } else {
            frequencyMap = words.stream().collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        }
        return frequencyMap;
    }

    /**
     * Get Top 3 Frequencies for each occurrence of word in given
     * <code>words</code>
     * 
     * @param words - Input words to prepare frequency mapping
     * @return Set of words having top 3 occurrences.
     */
    static List<String> getTop3FrequenciesForWord(Set<String> words) {
        List<String> top3Frequencies = null;
        if (words == null || words.isEmpty()) {
            System.out.println("Words should not empty to get frequencies");
        } else {
            Map<String, Long> wordFrequencies = words.stream()
                    .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
            top3Frequencies = wordFrequencies.keySet().stream()
                    .sorted(Comparator.comparing(wordFrequencies::get).reversed()).limit(3)
                    .collect(Collectors.toList());
        }
        return top3Frequencies;
    }

    /**
     * Get Top 3 Frequencies for each occurrence of word in given
     * <code>words</code> along with its character count
     * 
     * @param words - Input words to prepare frequency mapping
     * @return Set of words having top 3 occurrences.
     */
    static Map<String, Integer> getTop3FrequenciesCharacterCountMap(Set<String> words) {
        Map<String, Integer> top3FrequenciesCharacterCount = null;
        if (words == null || words.isEmpty()) {
            System.out.println("Words should not empty to get frequencies");
        } else {
            Map<String, Long> wordFrequencies = words.stream()
                    .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
            top3FrequenciesCharacterCount = wordFrequencies.keySet().stream()
                    .sorted(Comparator.comparing(wordFrequencies::get).reversed()).limit(3)
                    .collect(Collectors.toMap(Function.identity(), String::length));
        }
        return top3FrequenciesCharacterCount;
    }

    /**
     * To find occurrences of ABC from set of input <code>words</code> and then
     * group by its result
     * either <code>tru</code> or <code>false</code>
     *
     * @param words - Input words to find ABC occurrences
     * @return Map of values either having words with ABC occurrences or words with
     *         non ABC
     *         occurrences.
     */
    static Map<Boolean, Set<String>> findABCOccurrences(Set<String> words) {
        Map<Boolean, Set<String>> abcOccurrencesMap = null;
        if (words == null || words.isEmpty()) {
            System.out.println("Words should not empty to find ABC occurrences");
        } else {
            abcOccurrencesMap = words.stream()
                    .collect(Collectors.partitioningBy(
                        word -> word.equalsIgnoreCase("ABC"), Collectors.toSet()));
        }
        return abcOccurrencesMap;
    }
}
