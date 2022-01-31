package io.programming.chapter7.item42.functional.lambda;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LambdaExampleTest {
    
    @Test(dataProvider = "sortElementsDataProvider")
    public void testSortElementsUsingAnonymousClass(List<String> input, List<String> expected) {
        LambdaExample.sortStringElementsUsingAnonymousClass(input);
        Assert.assertEquals(input, expected);
    }

    @Test(dataProvider = "sortElementsDataProvider")
    public void testSortElementsUsingLambda(List<String> input, List<String> expected) {
        LambdaExample.sortStringElementsUsingLambda(input);
        Assert.assertEquals(input, expected);
    }

    @Test(dataProvider = "sortElementsDataProvider")
    public void testSortElementsUsingEnrichedLambda(List<String> input, List<String> expected) {
        LambdaExample.sortStringElementsUsingEnrichedLambda(input);
        Assert.assertEquals(input, expected);
    }

    @Test(dataProvider = "sortElementsNaturalOrderDataProvider")
    public void testSortElementsUsingNaturalOrder(List<String> input, List<String> expected) {
        LambdaExample.sortStringElementsUsingNaturalOrder(input);
        Assert.assertEquals(input, expected);
    }

    @Test(dataProvider = "operationDataProvider")
    public void testConstantBodyDefnUsingEnum(LambdaExample.Operation operation, 
        double a, double b, double result) {
        Assert.assertEquals(operation.operate(a, b), result, 0);
    }

    @Test(dataProvider = "operationUsingLambdaDataProvider")
    public void testConstantBodyDefnUsingEnumLambda(LambdaExample.OperationUsingLambda operation, 
        double a, double b, double result) {
        Assert.assertEquals(operation.operate(a, b), result, 0);
    }

    @DataProvider
    public Object[][] sortElementsDataProvider() {
        return new Object[][] {
            new Object [] {null, null},
            new Object [] {Arrays.asList(null, "A"), Arrays.asList(null, "A")},
            new Object [] {Arrays.asList("null", null), Arrays.asList(null, "null")},
            new Object [] {Arrays.asList("ABC", "XY", "Z"), Arrays.asList("Z", "XY", "ABC")},
        };
    }

    @DataProvider
    public Object[][] sortElementsNaturalOrderDataProvider() {
        return new Object[][] {
            new Object [] {null, null},
            new Object [] {Arrays.asList(null, "A"), Arrays.asList(null, "A")},
            new Object [] {Arrays.asList("null", null), Arrays.asList(null, "null")},
            new Object [] {Arrays.asList("ABC", "XY", "Z"), Arrays.asList("ABC", "XY", "Z")},
            new Object [] {Arrays.asList("C1", "A3", "B2"), Arrays.asList("A3", "B2", "C1")},
        };
    }

    @DataProvider
    public Object[][] operationDataProvider() {
        return new Object[][] {
            new Object[] {LambdaExample.Operation.PLUS, 1, 1, 2},
            new Object[] {LambdaExample.Operation.MINUS, 1, 2, -1},
            new Object[] {LambdaExample.Operation.TIMES, 1, 0, 0},
            new Object[] {LambdaExample.Operation.DIVIDES, 0, 1, 0},
            new Object[] {LambdaExample.Operation.DIVIDES, 1, 0, Double.POSITIVE_INFINITY},
            new Object[] {LambdaExample.Operation.DIVIDES, -1, 0, Double.NEGATIVE_INFINITY},
        };
    }

    @DataProvider
    public Object[][] operationUsingLambdaDataProvider() {
        return new Object[][] {
            new Object[] {LambdaExample.OperationUsingLambda.PLUS, 1, 1, 2},
            new Object[] {LambdaExample.OperationUsingLambda.MINUS, 1, 2, -1},
            new Object[] {LambdaExample.OperationUsingLambda.TIMES, 1, 0, 0},
            new Object[] {LambdaExample.OperationUsingLambda.DIVIDES, 0, 1, 0},
            new Object[] {LambdaExample.OperationUsingLambda.DIVIDES, 1, 0, Double.POSITIVE_INFINITY},
            new Object[] {LambdaExample.OperationUsingLambda.DIVIDES, -1, 0, Double.NEGATIVE_INFINITY},
        };
    }

}
