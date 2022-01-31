package io.programming.chapter7.item42.functional.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

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

    /**
     * Sort <code>String</code> elements basis alphabet natural sorting sequence. 
     * This is an example of using enriched lambda expression using Java 8 comparator
     * specific APIs
     * @param elements - List of Elements to sort.
     */
    public static void sortStringElementsUsingNaturalOrder(List<String> elements) {
        if(elements == null) 
            return;
        
        elements.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
    }

    /**
     * Calculator Operation to perform addition, subtraction, multiplication 
     * & division.
     */
    static enum Operation {
        PLUS("+") {
            public double operate(double a, double b) {
                return a+b;
            }
        },
        MINUS("-") {
            public double operate(double a, double b) {
                return a-b;
            }
        },
        TIMES("*") {
            public double operate(double a, double b) {
                return a*b;
            }
        },
        DIVIDES("/") {
            public double operate(double a, double b) {
                return a/b;
            }
        };
        
        final String symbol;
        
        Operation(String symbol) {
            this.symbol = symbol;
        }
        
        public abstract double operate(double a, double b);
        
        public String toString() {
            return symbol;
        }
    }

    static enum OperationUsingLambda {
        PLUS("+", (a,b) -> a+b),
        MINUS("-", (a,b) -> a-b),
        TIMES("*", (a,b) -> a*b),
        DIVIDES("/", (a,b) -> a/b);
        
        final String symbol;
        
        final DoubleBinaryOperator operator;
        
        OperationUsingLambda(String symbol, DoubleBinaryOperator operator) {
            this.symbol = symbol;
            this.operator = operator;
        }
        
        double operate(double a, double b) {
            return operator.applyAsDouble(a, b);
        }
        
        public String toString() {
            return symbol;
        }

    }
}
