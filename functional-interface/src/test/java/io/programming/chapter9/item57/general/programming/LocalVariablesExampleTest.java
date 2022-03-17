package io.programming.chapter9.item57.general.programming;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test Class for LocalVariableExample
 */
public class LocalVariablesExampleTest {

    @Test(dataProvider = "getCollectionToIterate")
    public <E> void testIterateOverCollection(Collection<E> elements) {
        LocalVariablesExample.iterateOverCollection(elements);
    }

    @Test(dataProvider = "getCollectionToIterate")
    public <E> void testIterateOverCollectionUsingIterator(Collection<E> elements) {
        LocalVariablesExample.iterateOverCollectionUsingIterator(elements);
    }

    @DataProvider
    public Object[][] getCollectionToIterate() {
        return new Object[][] {
            new Object[] {null},
            new Object[] {Collections.EMPTY_LIST},
            new Object[] {Collections.singletonList("HI")},
            new Object[] {Arrays.asList(1, 2)},
        };
    }

}
