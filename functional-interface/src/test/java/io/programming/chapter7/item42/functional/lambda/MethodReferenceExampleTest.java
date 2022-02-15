package io.programming.chapter7.item42.functional.lambda;

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
}
