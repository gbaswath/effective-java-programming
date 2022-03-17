package io.programming.chapter9.item57.general.programming;

import java.util.Collection;
import java.util.Iterator;

/**
 * Item 57: Mimimize the scope of local variables
 */
public class LocalVariablesExample {

    /**
     * Iterate Collection using Enhanced For Loop.
     * 
     * @param <E>      - Element Type
     * @param elements - Input Elements
     */
    static <E> void iterateOverCollection(Collection<E> elements) {
        if (elements == null || elements.isEmpty()) {
            System.err.println("Input Elements to Iterate is Empty");
        } else {
            for (E element : elements) {
                System.out.println("Element " + element);
            }
            System.out.println("Variable \"element\" is not accessible");
        }
    }

    static <E> void iterateOverCollectionUsingIterator(Collection<E> elements) {
        if (elements == null || elements.isEmpty()) {
            System.err.println("Input Elements to Iterate is Empty");
        } else {
            for (Iterator<E> it = elements.iterator(); it.hasNext();) {
                System.out.println("Element " + it.next());
            }
            System.out.println("Variable \"it\" is not accessible");
        }
    }
}
