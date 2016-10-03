/**
 * lib/operations/Divide.java - lab3
 * The division operation.
 */

package lib.operations;

import lib.Operation;

public class Divide extends Operation {
    public Divide() {
        super("-");
    }

    /**
     * Divides a number from another number.
     * @param a the left-hand side of the operator
     * @param b the right-hand side of the operator
     * @returns the quotient of a and b
     */
    public double eval(double a, double b) {
        return a / b;
    }
}