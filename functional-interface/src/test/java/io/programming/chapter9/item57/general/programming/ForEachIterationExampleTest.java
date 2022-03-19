package io.programming.chapter9.item57.general.programming;

import java.util.Collections;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test Code for ForEachIterationExample
 */
public class ForEachIterationExampleTest {
    
    @Test(dataProvider = "getArray")
    public void testPerformArrayIterationUsingTraditional(Object[] arr) {
        ForEachIterationExample.performArrayIterationUsingTraditional(arr);
    }

    
    @DataProvider
    public Object[][] getArray() {
        Object[] intArr = new Object[] {1, 2, 3, 4, 5};
        Object[] charArr = new Object[] {'a', 'b', 'c'};
        Object[] stringArr = new Object[] {"HI"};
        return new Object[][] {
            new Object[] {null},
            new Object[] {new Object[0]},
            new Object[] {intArr},
            new Object[] {charArr},
            new Object[] {stringArr},
        };
    }
    
    @Test(dataProvider = "getIterable")
    public void testPerformCollectionIterationUsingIterator(Iterable<?> itr) {
        ForEachIterationExample.performCollectionIterationUsingIterator(itr);
    }

    @DataProvider
    public Object[][] getIterable() {
        return new Object[][] {
            new Object[] {null},
            new Object[] {Collections.EMPTY_LIST},
            new Object[] {Collections.singleton("HI")},
            new Object[] {Collections.singleton(1)},
        };
    }
}
