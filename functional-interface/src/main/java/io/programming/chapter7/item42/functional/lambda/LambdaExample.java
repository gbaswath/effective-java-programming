package io.programming.chapter7.item42.functional.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Item 42 : Prefer Lambdas to anonymous class
 */
public class LambdaExample {
    
    /**
     * Sort <code>String</code> elements basis character length. This is an example of 
     * using obsolete anonymous class instead of lambda expression.
     * @param elements - List of Elements to sort.
     */
    public static void sortStringElementsUsingAnonymousClass(List<String> elements) {
        if(elements == null) 
            return;
        Collections.sort(elements, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if(s1 == null)
                    if(s2 == null)
                        return 0;
                    else
                        return -1;    
                else if(s2 == null)
                    return 1;
                else 
                    return Integer.compare(s1.length(), s2.length());
            }
        });
    }

    /**
     * Sort <code>String</code> elements basis character length. This is an example of 
     * using lambda expression instead of obsolete anonymous class
     * @param elements - List of Elements to sort.
     */
    public static void sortStringElementsUsingLambda(List<String> elements) {
        if(elements == null) 
            return;
        
        Collections.sort(elements, Comparator.nullsFirst(
            (s1, s2) -> Integer.compare(s1.length(), s2.length())));    
    }

    /**
     * Sort <code>String</code> elements basis character length. This is an example of 
     * using enriched lambda expression instead of obsolete anonymous class
     * @param elements - List of Elements to sort.
     */
    public static void sortStringElementsUsingEnrichedLambda(List<String> elements) {
        if(elements == null) 
            return;
        
        elements.sort(Comparator.nullsFirst(Comparator.comparingInt(String::length)));
    }

}
