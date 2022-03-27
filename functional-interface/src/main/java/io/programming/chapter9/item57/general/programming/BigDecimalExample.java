package io.programming.chapter9.item57.general.programming;

import java.math.BigDecimal;

/**
 * Item 60: Avoid Float & Double if exact answers are required
 */
public class BigDecimalExample {

    /**
     * Find Remaining amount after it is used using float datatype
     * 
     * @param initial - Current Amount
     * @param used    - Used Amount
     * @return remaining amount
     */
    static float findRemaining(float initial, float used) {
        if (used <= initial) {
            return initial - used;
        } else {
            return 0;
        }
    }

    /**
     * Find Remaining amount after it is used using double datatype
     * 
     * @param initial - Current Amount
     * @param used    - Used Amount
     * @return remaining amount
     */
    static double findRemaining(double initial, double used) {
        if (used <= initial) {
            return initial - used;
        } else {
            return 0;
        }
    }

    /**
     * Find Remaining amount after it is used using BigDecimal datatype
     * 
     * @param initial - Current Amount
     * @param used    - Used Amount
     * @return remaining amount
     */
    static BigDecimal findRemainingExact(String initial, String used) {
        BigDecimal initialBD = new BigDecimal(initial);
        BigDecimal usedBD = new BigDecimal(used);
        if (usedBD.compareTo(initialBD) <= 0) {
            return initialBD.subtract(usedBD);
        } else {
            return BigDecimal.valueOf(0);
        }
    }

    /**
     * Find Remaining Amount after purchasing items with each of its purchase value
     * 
     * @param initial               - Amount had before purchasing items
     * @param purchasedItemQuantity - Item count to be purchased
     * @param priceForEachItem      - Price of each item
     * @return Amount after purchasing items
     */
    static float findRemaining(float initial, int purchasedItemQuantity, float priceForEachItem) {
        return initial - (purchasedItemQuantity * priceForEachItem);
    }

    /**
     * Find Remaining Amount after purchasing items with each of its purchase value
     * 
     * @param initial               - Amount had before purchasing items
     * @param purchasedItemQuantity - Item count to be purchased
     * @param priceForEachItem      - Price of each item
     * @return Amount after purchasing items
     */
    static double findRemaining(double initial, int purchasedItemQuantity, double priceForEachItem) {
        return initial - (purchasedItemQuantity * priceForEachItem);
    }

    /**
     * Find Remaining Amount after purchasing items with each of its purchase value
     * 
     * @param initial               - Amount had before purchasing items
     * @param purchasedItemQuantity - Item count to be purchased
     * @param priceForEachItem      - Price of each item
     * @return Amount after purchasing items
     */
    static BigDecimal findRemainingExact(String initial, int purchasedItemQuantity, String priceForEachItem) {
        return new BigDecimal(initial)
                .subtract(new BigDecimal(priceForEachItem).multiply(BigDecimal.valueOf(purchasedItemQuantity)));
    }

    /**
     * Find Remaining Amount after purchasing items with each of its purchase value
     * 
     * @param notes                 - Amount had before purchasing items
     * @param coins                 - Coins has before purchasing items
     * @param purchasedItemQuantity - Item count to be purchased
     * @param priceForEachItem      - Price of each item
     * @return Amount after purchasing items
     */
    static int findRemainingExact(int notes, int coins, int purchasedItemQuantity, int priceForEachItem) {
        int remaining = notes * 100 + coins;
        for (int i = 0; i < purchasedItemQuantity; i++) {
            remaining = remaining - priceForEachItem;
        }
        return remaining;
    }
}
