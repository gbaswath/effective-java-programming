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
}
