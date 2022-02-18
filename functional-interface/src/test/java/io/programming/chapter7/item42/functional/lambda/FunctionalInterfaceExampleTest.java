package io.programming.chapter7.item42.functional.lambda;

import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FunctionalInterfaceExampleTest {

    @Test(dataProvider = "getCustomFunctionalInterfaceDataProvider")
    public void testRemoveEldestEntryUsingCustomFunctionalInterface(LinkedHashMap<String, String> expected) {
        LinkedHashMap<String, String> actual = FunctionalInterfaceExample
                .removeEldestEntryUsingCustomFunctionalInterface();
        actual.put("1", "1");
        actual.put("2", "2");
        actual.put("3", "3");
        actual.put("4", "4");
        actual.put("5", "5");
        actual.put("HI", "HI");
        actual.put("BYE", "BYE");
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] getCustomFunctionalInterfaceDataProvider() {
        LinkedHashMap<String, String> expected = new LinkedHashMap<>();
        expected.put("HI", "HI");
        expected.put("BYE", "BYE");
        return new Object[][] {
                new Object[] { expected },
        };
    }
}
