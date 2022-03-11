package io.programming.chapter7.item42.functional.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test Class for Prefer Side Effect Free Streams.
 */
public class EfficientStreamExampleTest {

    @Test(dataProvider = "getWordToTestItsFrequencies")
    public void testGetFrequenciesForWordUsingForEach(
            Set<String> words, Map<String, Long> expectedOutput) {
        Assert.assertEquals(
                EfficientStreamExample.getFrequenciesForWordUsingForEach(words), expectedOutput);
    }

    @Test(dataProvider = "getWordToTestItsFrequencies")
    public void testGetFrequenciesForWord(Set<String> words, Map<String, Long> expectedOutput) {
        Assert.assertEquals(EfficientStreamExample.getFrequenciesForWordUsingStream(words), expectedOutput);
    }

    @DataProvider
    public static Object[][] getWordToTestItsFrequencies() {
        Map<String, Long> freqMap = new LinkedHashMap<>();
        freqMap.put("abc", 2L);
        freqMap.put("cab", 2L);
        freqMap.put("def", 1L);
        return new Object[][] {
                new Object[] { null, null },
                new Object[] { Collections.EMPTY_SET, null },
                new Object[] { new TreeSet<>(Arrays.asList("abc", "ABC", "CAB", "cab", "DEF")), freqMap },
                new Object[] { new TreeSet<>(Arrays.asList("abc", "DEF", "CAB", "ABC", "cab")), freqMap }
        };
    }

    @Test(dataProvider = "getWordToTestTop3Frequencies")
    public void testGetTop3FrequenciesForWord(Set<String> words, List<String> expectedOutput) {
        Assert.assertEquals(EfficientStreamExample.getTop3FrequenciesForWord(words), expectedOutput);
    }

    @DataProvider
    public static Object[][] getWordToTestTop3Frequencies() {
        return new Object[][] {
                new Object[] { null, null },
                new Object[] { Collections.EMPTY_SET, null },
                new Object[] {
                        new HashSet<>(Arrays.asList("abc", "ABC", "CAB", "cab", "DEF")),
                        Arrays.asList("abc", "cab", "def")
                },
                new Object[] {
                        new HashSet<>(Arrays.asList("abc", "DEF", "CAB", "ABC", "cab", "CaB", "ARG")),
                        Arrays.asList("cab", "abc", "def")
                },
        };
    }
}
