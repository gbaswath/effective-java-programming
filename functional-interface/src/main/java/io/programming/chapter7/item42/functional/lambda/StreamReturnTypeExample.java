package io.programming.chapter7.item42.functional.lambda;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
            // Use StreamSupport
            stream = StreamSupport.stream(iterable.spliterator(), false);
        }
        return stream;
    }

    /**
     * Create Power Set (Combination set) for given elements
     * 
     * @param <E>
     * @param elements - Elements to create power set.
     * @return
     */
    static <E> Collection<Set<E>> powerSetOf(Set<E> elements) {
        Collection<Set<E>> powerSet = null;
        if (elements == null || elements.isEmpty()) {
            System.out.println("Elements should not be null for preparing power set");
        } else {
            if (elements.size() > 30) {
                System.out.println(
                        "Collection Size should not be > 30 as Power set can be of maximum of 2^size");
            } else {
                List<E> powerSetSource = new ArrayList<>(elements);
                powerSet = getCustomCollection(powerSetSource);
            }
        }
        return powerSet;
    }

    private static <E> Collection<Set<E>> getCustomCollection(List<E> powerSetSource) {
        // Prepare Custom Collection
        return new AbstractList<Set<E>>() {
            // Override get method
            @Override
            public Set<E> get(int index) {
                // Create Set Instance
                Set<E> result = new HashSet<>();
                // Shelf Index for Later Use
                int srcIndex = index;
                // Use Right Shift of Index to create power set
                for (int i = 0; index != 0; i++, index >>= 1) {
                    // If Current Index Bit is 1 then add that element
                    if ((index & 1) == 1) {
                        result.add(powerSetSource.get(i));
                    }
                }
                System.out.println("Result " + result + " at Index " + srcIndex);
                return result;
            }

            @Override
            public boolean contains(Object o) {
                System.out.println("Power Set Source " + powerSetSource);
                return o instanceof Set && powerSetSource.containsAll((Set<?>) o);
            }

            @Override
            public int size() {
                // Return Size basis 2^n-1
                int size = 1 << powerSetSource.size();
                System.out.println("Power Set Size " + size);
                return size;
            }
        };
    }
}
