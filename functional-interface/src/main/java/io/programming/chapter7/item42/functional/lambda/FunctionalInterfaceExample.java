package io.programming.chapter7.item42.functional.lambda;

import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Item 44 : Favor the use of Standard Functional Interface
 */
public class FunctionalInterfaceExample {

    /**
     * Custom Function Interface to remove from map
     */
    @FunctionalInterface
    private interface RemoveEldestEntryInMapWhenSizeExceeeds {
        boolean remove(LinkedHashMap<String, String> map);
    }

    /**
     * Removes Eldest Entry from Map when map size exceeds 2
     * 
     * @return LinkedHashMap of Size 2
     */
    public static LinkedHashMap<String, String> removeEldestEntryUsingCustomFunctionalInterface() {
        return getLinkedHashMapOfSize2();
    }

    /**
     * Custom Linked HashMap of size doesn't exceed 2
     * 
     * @return Custom LinkedHashMap
     */
    private static LinkedHashMap<String, String> getLinkedHashMapOfSize2() {
        return new LinkedHashMap<String, String>() {
            protected boolean removeEldestEntry(java.util.Map.Entry<String, String> arg0) {
                System.out.println("Removing Entry " + arg0);
                return getCustomFunction().remove(this);
            }
        };
    }

    /**
     * Custom Function Interface to remove eldest entry when map size exceeds 2
     * 
     * @return Custom LinkedHashMap
     */
    private static RemoveEldestEntryInMapWhenSizeExceeeds getCustomFunction() {
        RemoveEldestEntryInMapWhenSizeExceeeds customFunction = (map -> map.size() > 2);
        return customFunction;
    }

    /**
     * LinkedHashMap of Size 2 is given based on <code>Predicate</code> Standard
     * Functional Interface
     * 
     * @return
     */
    public static LinkedHashMap<String, String> removeEldestEntryUsingStandardFunctionalInterface() {
        return new LinkedHashMap<String, String>() {
            protected boolean removeEldestEntry(java.util.Map.Entry<String, String> arg0) {
                System.out.println("Removing Entry " + arg0);
                Predicate<LinkedHashMap<String, String>> sizeExceeds2 = (map -> map.size() > 2);
                return sizeExceeds2.test(this);
            }
        };
    }

    /**
     * Invokes all Basic Standard Interface
     * 
     * @param <T>            - Integer
     * @param <R>            - String
     * @param consumer       - Prints
     * @param predicate      - Test For Empty
     * @param function       - Convert Integer to String
     * @param unaryOperator  - Return Number of Leading Zeros
     * @param binaryOperator - Return Sum of Integer
     * @param supplier       - Return 0
     */
    static <T, R> void invokeAllBasicStandardFunctionalInterface(
            Consumer<Boolean> consumer,
            Predicate<R> predicate,
            Function<T, R> function,
            UnaryOperator<T> unaryOperator,
            BinaryOperator<T> binaryOperator,
            Supplier<T> supplier) {
        consumer.accept(
                predicate.test(
                        function.apply(
                                unaryOperator.apply(binaryOperator.apply(supplier.get(), supplier.get())))));
    }

    /**
     * Function to display the no differences between <code>Callable</code> and
     * <code>Runnable</code>. It is wise to explicitly create variables and use it
     * instead of lambda definition.
     */
    static void submitExecutable() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // Runnable Lambda
        executor.submit(() -> System.out.println("Runnable Response Hi"));
        // Callable Lambda
        Future<String> response = executor.submit(() -> "Hello");
        try {
            System.out.println("Callable Response " + response.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
