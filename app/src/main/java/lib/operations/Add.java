/**
 * lib/operations/Add.java - lab3
 * The addition operation.
 */

package lib.operations;

import lib.Operation;

public class Add extends Operation {
    public Add() {
        super("+");
    }

    /**
     * Adds two numbers together.
     * @param a the first number
     * @param b the second number
     * @returns the sum of a and b
     */
    public double eval(double a, double b) {
        return a + b;
    }
}