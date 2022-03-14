package io.programming.chapter7.item42.functional.lambda;

import java.util.stream.Stream;

/**
 * Item 47: Prefer Collection to Stream as Return Type
 */
public class StreamReturnTypeExample {

    /**
     * Generic API to convert stream as iterable.
     *
     * @param stream - any stream API
     * @param <T>    any Type
     * @return iterable<T>
     */
    static <T> Iterable<T> iterableOf(Stream<T> stream) {
        Iterable<T> iterable = null;
        if (stream == null) {
            System.out.println("Input stream is empty to convert as iterable");
        } else {
            iterable = stream::iterator;
        }
        return iterable;
    }
}
