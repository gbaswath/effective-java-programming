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

    @DataProvider
    public Object[][] sortElementsDataProvider() {
        /* List<String> invalidInput = new ArrayList<>();
        invalidInput.add(null);
        invalidInput.add("A"); */
        return new Object[][] {
            new Object [] {Arrays.asList(null, "A"), Arrays.asList(null, "A")},
            new Object [] {Arrays.asList("null", null), Arrays.asList(null, "null")},
            new Object [] {Arrays.asList("ABC", "XY", "Z"), Arrays.asList("Z", "XY", "ABC")},
        };
    }

}
