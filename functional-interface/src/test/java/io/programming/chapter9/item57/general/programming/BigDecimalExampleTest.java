package io.programming.chapter9.item57.general.programming;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test code to test BigDecimal to get exact value
 */
public class BigDecimalExampleTest {

    @Test(dataProvider = "getFloat")
    public void testRemainingAmountFloat(float initial, float used) {
        System.out.println("[Float] Test Remaining with Initial " + initial + " & Used " + used);
        System.out.println("[Float] Got " + BigDecimalExample.findRemaining(initial, used));
    }

    @DataProvider
    public Object[][] getFloat() {
        return new Object[][] {
                new Object[] { 0f, 0f },
                new Object[] { 5.2f, 10f },
                new Object[] { 1.03f, 0.47f },
                new Object[] { 1.3f, 0.44f },
                new Object[] { 1f, 0.42f },
        };
    }

    @Test(dataProvider = "getDouble")
    public void testRemainingAmountDouble(double initial, double used) {
        System.out.println("[Double] Test Remaining with Initial " + initial + " & Used " + used);
        System.out.println("[Double] Got " + BigDecimalExample.findRemaining(initial, used));
    }

    @DataProvider
    public Object[][] getDouble() {
        return new Object[][] {
                new Object[] { 0d, 0d },
                new Object[] { 5.2d, 10d },
                new Object[] { 1.03d, 0.42d },
        };
    }

    @Test(dataProvider = "getString")
    public void testRemainingAmountExact(String initial, String used) {
        System.out.println("[BigDecimal] Test Remaining with Initial " + initial + " & Used " + used);
        System.out.println("[BigDecimal] Got " + BigDecimalExample.findRemainingExact(initial, used));
    }

    @DataProvider
    public Object[][] getString() {
        return new Object[][] {
                new Object[] { "0", "0" },
                new Object[] { "5.2", "10" },
                new Object[] { "1.04", "0.4" },
                new Object[] { "1.0", "0.43" },
                new Object[] { "1.04", "0.43" },
        };
    }

    @Test(dataProvider = "getFloatQuantity")
    public void testRemainingAmountQuantityFloat(float initial, int purchasedItemQuantity, float priceForEachItem) {
        System.out.println("[Float] Test Remaining with Initial " + initial + " Quantity Purchased "
                + purchasedItemQuantity + " with price " + priceForEachItem);
        System.out.println(
                "[Float] Got " + BigDecimalExample.findRemaining(initial, purchasedItemQuantity, priceForEachItem));
    }

    @DataProvider
    public Object[][] getFloatQuantity() {
        return new Object[][] {
                new Object[] { 0f, 0, 0f },
                new Object[] { 1f, 9, 0.1f },
                new Object[] { 5.2f, 4, 0.10f },
                new Object[] { 1.03f, 2, 0.47f },
                new Object[] { 1.3f, 2, 0.44f },
        };
    }

    @Test(dataProvider = "getDoubleQuantity")
    public void testRemainingAmountQuantityDouble(double initial, int purchasedItemQuantity, double priceForEachItem) {
        System.out.println("[Double] Test Remaining with Initial " + initial + " Quantity Purchased "
                + purchasedItemQuantity + " with price " + priceForEachItem);
        System.out.println(
                "[Double] Got " + BigDecimalExample.findRemaining(initial, purchasedItemQuantity, priceForEachItem));
    }

    @DataProvider
    public Object[][] getDoubleQuantity() {
        return new Object[][] {
                new Object[] { 0d, 0, 0d },
                new Object[] { 1d, 9, 0.1d },
                new Object[] { 8.3d, 4, 0.17d },
                new Object[] { 1.03d, 2, 0.47d },
                new Object[] { 1.3d, 2, 0.44d },
        };
    }

    @Test(dataProvider = "getBigDecimalQuantity")
    public void testRemainingAmountQuantityExactBD(String initial, int purchasedItemQuantity, String priceForEachItem) {
        System.out.println("[BD] Test Remaining with Initial " + initial + " Quantity Purchased "
                + purchasedItemQuantity + " with price " + priceForEachItem);
        System.out.println(
                "[BD] Got " + BigDecimalExample.findRemainingExact(initial, purchasedItemQuantity, priceForEachItem));
    }

    @DataProvider
    public Object[][] getBigDecimalQuantity() {
        return new Object[][] {
                new Object[] { "0", 0, "0" },
                new Object[] { "1.0", 9, "0.1" },
                new Object[] { "8.3", 4, "0.17" },
                new Object[] { "1.03", 2, "0.47" },
                new Object[] { "1.3", 2, "0.44" },
        };
    }

    @Test(dataProvider = "getIntQuantity")
    public void testRemainingAmountQuantityExactInt(int notes, int coins, int purchasedItemQuantity,
            int priceForEachItem) {
        System.out.println("[Int] Test Remaining with Initial " + notes + " Coins " + coins + " Quantity Purchased "
                + purchasedItemQuantity + " with price " + priceForEachItem);
        System.out.println(
                "[Int] Got "
                        + BigDecimalExample.findRemainingExact(notes, coins, purchasedItemQuantity, priceForEachItem)
                        + " coins");
    }

    @DataProvider
    public Object[][] getIntQuantity() {
        return new Object[][] {
                new Object[] { 0, 0, 0, 0 },
                new Object[] { 1, 0, 9, 10 },
                new Object[] { 8, 30, 4, 17 },
                new Object[] { 1, 3, 2, 47 },
                new Object[] { 1, 30, 2, 44 },
        };
    }
}
