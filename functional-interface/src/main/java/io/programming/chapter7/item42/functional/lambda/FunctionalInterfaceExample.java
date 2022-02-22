package io.programming.chapter7.item42.functional.lambda;

import java.util.LinkedHashMap;
import java.util.function.Predicate;

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
     * LinkedHashMap of Size 2 is given based on <code>Predicate</code> Standard Functional Interface
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

}
