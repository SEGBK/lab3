/**
 * lib/operations/Subtract.java - lab3
 * The subtraction operation.
 */

package lib.operations;

import lib.Operation;

public class Subtract extends Operation {
    public Subtract() {
        super("-");
    }

    /**
     * Subtracts a number from another number.
     * @param a the left-hand side of the operator
     * @param b the right-hand side of the operator
     * @returns the difference of a and b
     */
    public double eval(double a, double b) {
        return a - b;
    }
}