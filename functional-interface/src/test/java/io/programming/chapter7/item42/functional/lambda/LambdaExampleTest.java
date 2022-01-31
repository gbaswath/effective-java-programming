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
        return new Object[][] {
            new Object [] {null, null},
            new Object [] {Arrays.asList(null, "A"), Arrays.asList(null, "A")},
            new Object [] {Arrays.asList("null", null), Arrays.asList(null, "null")},
            new Object [] {Arrays.asList("ABC", "XY", "Z"), Arrays.asList("Z", "XY", "ABC")},
        };
    }

}
