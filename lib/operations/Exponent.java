/**
 * lib/operations/Exponent.java - lab3
 * The exponential operation.
 */

package lib.operations;

import lib.Operation;

public class Exponent extends Operation {
    public Exponent() {
        super("e");
    }

    /**
     * Finds the result of a power.
     * @param a the base number
     * @param b the exponent
     * @returns the power of a^b
     */
    public double eval(double a, double b) {
        return Math.pow(a, b);
    }
}