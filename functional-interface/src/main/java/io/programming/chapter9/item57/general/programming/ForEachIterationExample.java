package io.programming.chapter9.item57.general.programming;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Item 58: Prefer ForEach over Traditional For Loops
 */
public class ForEachIterationExample {

    static void performArrayIterationUsingTraditional(Object[] arr) {
        if (arr == null || arr.length == 0) {
            System.err.println("Input Array is Empty to Iterate");
        } else {
            System.out.println("Iterate using Array Index of Size " + arr.length);
            for (int i = 0; i < arr.length; i++) {
                System.out.println("Object in Array " + arr[i]);
            }
        }
    }

    static void performCollectionIterationUsingIterator(Iterable<?> itr) {
        if (itr == null) {
            System.err.println("Input Iterable is Empty to Iterate");
        } else {
            System.out.println("Iterate using Iterator");
            for (Iterator<?> it = itr.iterator(); it.hasNext();) {
                System.out.println("Object in Array " + it.next());
            }
        }
    }

    /**
     * Custom Iterable Iteration using LIFO
     */
    static class Stack<T> implements Iterable<T> {

        private List<T> list = new ArrayList<>();

        public Stack(List<T> list) {
            this.list = list;
        }

        @Override
        public Iterator<T> iterator() {
            Iterator<T> it = new Iterator<T>() {

                int index = list.size() - 1;

                @Override
                public boolean hasNext() {
                    return index >= 0;
                }

                @Override
                public T next() {
                    return list.get(index--);
                }

            };
            return it;
        }
    }
}
