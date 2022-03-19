package io.programming.chapter9.item57.general.programming;

import java.util.Iterator;

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

}
