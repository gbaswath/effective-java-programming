package io.programming.chapter9.item57.general.programming;

import java.util.Arrays;
import java.util.Collections;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.programming.chapter9.item57.general.programming.ForEachIterationExample.Stack;

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

    @Test(dataProvider = "getStack")
    public void testStackIterable(Stack<?> stack) {
        System.out.println("Iterate using Stream For Each");
        stack.forEach(System.out::println);
        System.out.println("Iterate using For Each");
        for(Object obj : stack) {
            System.out.println("Got Object " + obj);
        }
    }

    @DataProvider
    public Object[][] getStack() {
        Stack<Integer> intStack = new Stack<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Stack<String> stringStack = new Stack<String>(Arrays.asList("HI", "BYE"));
        return new Object[][] {
            new Object[] {intStack},
            new Object[] {stringStack},
        };
    }
}
