package io.programming.chapter7.item42.functional.lambda;

import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    /**
     * Check if current time is greater than given time instant
     *
     * @param time - Time Instant to check against current time.
     * @return true - if current time is greater else false
     */
    static boolean checkIfCurrentTimeGreaterBoundedMethodReference(Instant time) {
        return Optional.ofNullable(time).filter(Instant.now()::isAfter).isPresent();
    }

    /**
     * Compute Length of given string input
     *
     * @param input - String length to be computed
     * @return number of characters count if not empty else null
     */
    static int getStringLengthUsingUnboundMethodReference(String input) {
        return Optional.ofNullable(input).map(String::length).orElse(0);
    }

    /**
     * Gets Empty String incase of <code>null</code> input.
     *
     * @param input - Input to be checked for <code>null</code>.
     * @return input if it is not <code>null</code> else return empty
     *         <code>String</code>
     */
    static String getStringInstanceIfEmptyUsingConstructorMethodReference(String input) {
        return Optional.ofNullable(input).orElseGet(String::new);
    }

    /**
     * Create Array Instance basis input length
     *
     * @param input - array length
     */
    static int[] createArrayInstanceUsingConstructorMethodReference(Integer input) {
        return Optional.ofNullable(input).filter(value -> value > 0).map(int[]::new).orElse(null);
    }

}
