package io.programming.chapter7.item42.functional.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class to test Stream Return Type
 */
public class StreamReturnTypeExampleTest {

    @Test(dataProvider = "getStreams")
    public <T> void testIterableOf(Stream<T> stream, Iterable<T> expectedOutput) {
        Assert.assertEquals(StreamReturnTypeExample.iterableOf(stream), expectedOutput);
    }

    @DataProvider
    public static Object[][] getStreams() {
        return new Object[][] {
                new Object[] { null, null },
                new Object[] { Stream.of("HI", "BYE"), Arrays.asList("HI", "BYE") },
                new Object[] { Stream.of("HI", "BYE"), new HashSet<>(Arrays.asList("HI", "BYE")) }
        };
    }

    @Test(dataProvider = "getIterable")
    public <T> void testStreamOf(Iterable<T> iterable, Stream<T> expectedOutput) {
        Stream<T> actual = StreamReturnTypeExample.streamOf(iterable);
        Assert.assertEquals(
                actual == null ? null : actual.iterator(),
                expectedOutput == null ? null : expectedOutput.iterator());
    }

    @DataProvider
    public static Object[][] getIterable() {
        return new Object[][] {
                new Object[] { null, null },
                new Object[] { Arrays.asList("HI", "BYE"), Stream.of("HI", "BYE") },
                new Object[] { new HashSet<>(Arrays.asList("HI", "BYE")), Stream.of("HI", "BYE") }
        };
    }

    @Test(dataProvider = "getPowerSetSource")
    public <E> void testPowerSetOf(Set<E> elements, Set<E> powerSetAtIndex) {
        System.out.println("Going to Test Power Set " + powerSetAtIndex);
        Collection<Set<E>> actual = StreamReturnTypeExample.powerSetOf(elements);
        if (elements == null) {
            Assert.assertNull(actual);
        } else {
            Assert.assertTrue(actual.contains(powerSetAtIndex));
        }
        System.out.println("Tested Power Set " + powerSetAtIndex);
    }

    @DataProvider
    public static Object[][] getPowerSetSource() {
        Set<String> elements = new HashSet<>(Arrays.asList("a", "b", "c"));
        Set<String> powerSetIndex1 = Collections.emptySet();
        Set<String> powerSetIndex2 = new HashSet<>(Arrays.asList("b"));
        Set<String> powerSetIndex3 = new HashSet<>(Arrays.asList("a", "c"));
        Set<String> powerSetIndex4 = new HashSet<>(Arrays.asList("a", "b", "c"));
        return new Object[][] {
                new Object[] { null, null },
                new Object[] { elements, powerSetIndex1 },
                new Object[] { elements, powerSetIndex2 },
                new Object[] { elements, powerSetIndex3 },
                new Object[] { elements, powerSetIndex4 },
        };
    }
}
