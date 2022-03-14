package io.programming.chapter7.item42.functional.lambda;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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

    /**
     * Generic method to convert iterable as stream
     *
     * @param iterable Input sequence
     * @param <T>      any Type
     * @return stream of elements
     */
    static <T> Stream<T> streamOf(Iterable<T> iterable) {
        Stream<T> stream = null;
        if (iterable == null) {
            System.out.println("Input iterable is empty to convert as stream");
        } else {
            //Use StreamSupport
            stream = StreamSupport.stream(iterable.spliterator(), false);
        }
        return stream;
    }
}
