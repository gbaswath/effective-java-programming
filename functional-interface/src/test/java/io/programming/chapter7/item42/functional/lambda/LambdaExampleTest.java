package io.programming.chapter7.item42.functional.lambda;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LambdaExampleTest {
    
    @Test(dataProvider = "sortElementsDataProvider")
    public void testSortElementsUsingAnonymousClass(List<String> input, List<String> expected) {
        LambdaExample.sortStringElementsUsingAnonymousClass(input);
        Assert.assertEquals(input, expected);
    }

    @Test(dataProvider = "sortElementsDataProvider")
    public void testSortElementsUsingLambda(List<String> input, List<String> expected) {
        LambdaExample.sortStringElementsUsingLambda(input);
        Assert.assertEquals(input, expected);
    }

    @Test(dataProvider = "sortElementsDataProvider")
    public void testSortElementsUsingEnrichedLambda(List<String> input, List<String> expected) {
        LambdaExample.sortStringElementsUsingEnrichedLambda(input);
        Assert.assertEquals(input, expected);
    }

    @Test(dataProvider = "sortElementsNaturalOrderDataProvider")
    public void testSortElementsUsingNaturalOrder(List<String> input, List<String> expected) {
        LambdaExample.sortStringElementsUsingNaturalOrder(input);
        Assert.assertEquals(input, expected);
    }

    @DataProvider
    public Object[][] sortElementsDataProvider() {
        return new Object[][] {
            new Object [] {null, null},
            new Object [] {Arrays.asList(null, "A"), Arrays.asList(null, "A")},
            new Object [] {Arrays.asList("null", null), Arrays.asList(null, "null")},
            new Object [] {Arrays.asList("ABC", "XY", "Z"), Arrays.asList("Z", "XY", "ABC")},
        };
    }

    @DataProvider
    public Object[][] sortElementsNaturalOrderDataProvider() {
        return new Object[][] {
            new Object [] {null, null},
            new Object [] {Arrays.asList(null, "A"), Arrays.asList(null, "A")},
            new Object [] {Arrays.asList("null", null), Arrays.asList(null, "null")},
            new Object [] {Arrays.asList("ABC", "XY", "Z"), Arrays.asList("ABC", "XY", "Z")},
            new Object [] {Arrays.asList("C1", "A3", "B2"), Arrays.asList("A3", "B2", "C1")},
        };
    }

}
