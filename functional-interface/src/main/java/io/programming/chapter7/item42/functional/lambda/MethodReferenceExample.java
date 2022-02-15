package io.programming.chapter7.item42.functional.lambda;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Item 43 : Prefer Method Reference to Lambdas
 */
public class MethodReferenceExample {

    /**
     * This method maps key to occurrence count
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

}
