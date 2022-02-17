package io.programming.chapter7.item42.functional.lambda;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Item 43 : Prefer Method Reference to Lambdas
 */
public class MethodReferenceExampleTest {

    @Test(dataProvider = "getKeysDataProvider")
    public void testAssociateCountToKeysUsingLambda(List<String> keys, Map<String, Integer> expected) {
        Map<String, Integer> actual = MethodReferenceExample.associateCountToKeysUsingLambda(keys);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "getKeysDataProvider")
    public void testAssociateCountToKeysUsingMethodReference(
            List<String> keys, Map<String, Integer> expected) {
        Map<String, Integer> actual = MethodReferenceExample.associateCountToKeysUsingMethodReference(keys);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] getKeysDataProvider() {
        Map<String, Integer> emptyKeyResult = Collections.emptyMap();
        Map<String, Integer> singleKeyOccurrence = new HashMap<>();
        singleKeyOccurrence.put("HI", 1);
        Map<String, Integer> dualKeyOccurrence = new HashMap<>();
        dualKeyOccurrence.put("HI", 2);
        Map<String, Integer> singleNullOccurrence = new HashMap<>();
        singleNullOccurrence.put("HI", 1);
        singleNullOccurrence.put(null, 1);
        Map<String, Integer> dualNullOccurrence = new HashMap<>();
        dualNullOccurrence.put(null, 2);
        dualNullOccurrence.put("HI", 2);
        return new Object[][] {
                new Object[] { Collections.emptyList(), emptyKeyResult },
                new Object[] { Arrays.asList("HI"), singleKeyOccurrence },
                new Object[] { Arrays.asList("HI", "HI"), dualKeyOccurrence },
                new Object[] { Arrays.asList("HI", null), singleNullOccurrence },
                new Object[] { Arrays.asList("HI", "HI", null, null), dualNullOccurrence },
        };
    }

    @Test(dataProvider = "getElementsDataProvider")
    public void testPrintElementsUsingMethodReference(List<String> elements) {
        MethodReferenceExample.printElementsUsingMethodReference(elements);
    }

    @Test(dataProvider = "getElementsDataProvider")
    public void testPrintElementsUsingLambda(List<String> elements) {
        MethodReferenceExample.printElementsUsingLambda(elements);
    }

    @Test(dataProvider = "getTimeInstantDataProvider")
    public void testCheckIfCurrentTimeGreaterBoundedMethodReference(
            Instant inputTime, boolean expected) {
        Assert.assertEquals(
                MethodReferenceExample.checkIfCurrentTimeGreaterBoundedMethodReference(inputTime),
                expected);
    }

    @Test(dataProvider = "getStringCountDataProvider")
    public void testGetStringLengthUsingUnboundMethodReference(String input, int expectedCount) {
        Assert.assertEquals(
                MethodReferenceExample.getStringLengthUsingUnboundMethodReference(input), expectedCount);
    }

    @Test(dataProvider = "getStringInstanceDataProvider")
    public void testGetStringInstanceIfEmptyUsingConstructorMethodReference(
            String input, String expectedOutput) {
        Assert.assertEquals(
                MethodReferenceExample.getStringInstanceIfEmptyUsingConstructorMethodReference(input),
                expectedOutput);
    }

    @Test(dataProvider = "getIntegerDataProvider")
    public void testCreateArrayInstanceUsingConstructorMethodReference(Integer input, int[] expected) {
        int[] actual = MethodReferenceExample.createArrayInstanceUsingConstructorMethodReference(input);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] getElementsDataProvider() {
        return new Object[][] {
                new Object[] { null },
                new Object[] { Collections.emptyList() },
                new Object[] { Arrays.asList(null, "HI", null) },
        };
    }

    @DataProvider
    public static Object[][] getTimeInstantDataProvider() {
        return new Object[][] {
                new Object[] { null, false },
                new Object[] { Instant.now().plusSeconds(100), false },
                new Object[] { Instant.now(), true },
                new Object[] { Instant.now().minusSeconds(100), true },
        };
    }

    @DataProvider
    public static Object[][] getStringCountDataProvider() {
        return new Object[][] {
                new Object[] { null, 0 },
                new Object[] { "", 0 },
                new Object[] { "null", 4 },
                new Object[] { "String", 6 },
                new Object[] { " String ", 8 }
        };
    }

    @DataProvider
    public static Object[][] getStringInstanceDataProvider() {
        return new Object[][] {
                new Object[] { null, "" },
                new Object[] { "", "" },
                new Object[] { "null", "null" },
                new Object[] { "HI", "HI" },
        };
    }

    @DataProvider
    public static Object[][] getIntegerDataProvider() {
        return new Object[][] {
                new Object[] { null, null }, new Object[] { 5, new int[5] }, new Object[] { -1, null },
        };
    }

}
