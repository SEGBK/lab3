/**
 * lib/operations/Multiply.java - lab3
 * The multiplication operation.
 */

package lib.operations;

import lib.Operation;

public class Multiply extends Operation {
    public Multiply() {
        super("*");
    }

    /**
     * Multiplys two numbers together.
     * @param a the first number
     * @param b the second number
     * @returns the product of a and b
     */
    public double eval(double a, double b) {
        return a * b;
    }
}