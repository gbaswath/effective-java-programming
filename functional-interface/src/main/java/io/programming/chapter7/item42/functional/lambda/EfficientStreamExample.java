package io.programming.chapter7.item42.functional.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
      frequencyMap =
          words.stream().collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
    }
    return frequencyMap;
  }
}
