package com.nano.core;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        andThen();
        compose();
        andThenNull();
    }

    public static void andThen()
    {
        // Function which takes in a number and
        // returns half of it
        Function<Integer, Double> half = a -> a / 2.0;

        // Now triple the output of half function
        half = half.andThen(a -> 3 * a);

        // Applying the function to get the result
        // and printing on console
        System.out.println(half.apply(10));
    }
    public static void andThenNull()
    {

        // Function which takes in a number and
        // returns half of it
        Function<Integer, Double> half = a -> a / 2.0;

        // Try block to check for exceptions
        try {

            // Trying to pass null as parameter
            half = half.andThen(null);
        }

        // Catch block to handle exceptions
        catch (Exception e) {

            // Print statement
            System.out.println("Exception thrown "
                    + "while passing null: "
                    + e);
        }
    }

    public static void compose()
    {
        // Function which takes in a number and
        // returns half of it
        Function<Integer, Double> half = a -> a / 2.0;

        // However treble the value given to half function
        half = half.compose(a -> 3 * a);

        // Applying the function to get the result
        System.out.println(half.apply(5));
    }


}
