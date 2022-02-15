package io.programming.chapter7.item42.functional.lambda;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Item 43 : Prefer Method Reference to Lambdas
 */
public class MethodReferenceExample {

    /**
     * This method maps key to occurrence count using Lambda Expression
     * 
     * @param key - List of Keys to get concurrence count.
     */
    static Map<String, Integer> associateCountToKeysUsingLambda(List<String> keys) {
        if (keys == null || keys.isEmpty()) {
            System.out.println("Key to associate is empty. Hence association skipped");
            return Collections.emptyMap();
        } else {
            Map<String, Integer> keyCounterMap = new HashMap<>();
            keys.forEach(key -> keyCounterMap.merge(key, 1, (count, increment) -> count + increment));
            return keyCounterMap;
        }
    }

    /**
     * This method maps key to occurrence count using <code>Integer::sum</code>
     * 
     * @param key - List of Keys to get concurrence count.
     */
    static Map<String, Integer> associateCountToKeysUsingMethodReference(List<String> keys) {
        if (keys == null || keys.isEmpty()) {
            System.out.println("Key to associate is empty. Hence association skipped");
            return Collections.emptyMap();
        } else {
            Map<String, Integer> keyCounterMap = new HashMap<>();
            keys.forEach(key -> keyCounterMap.merge(key, 1, Integer::sum));
            return keyCounterMap;
        }
    }

    /**
     * Print Elements to Console by mapping input to input using Identity
     * 
     * @param elements - ELements to be printed.
     */
    static void printElementsUsingMethodReference(List<String> elements) {
        if (elements == null || elements.isEmpty()) {
            System.out.println("Elements is empty. Hence printing skipped");
        } else {
            elements.stream().map(Function.identity()).forEach(System.out::println);
        }
    }

    /**
     * Print Elements to Console by mapping input to input using Lambda
     * 
     * @param elements - ELements to be printed.
     */
    static void printElementsUsingLambda(List<String> elements) {
        if (elements == null || elements.isEmpty()) {
            System.out.println("Elements is empty. Hence printing skipped");
        } else {
            elements.forEach(System.out::println);
        }
    }

}
