/**
 * lib/Operation.java - lab3
 * An interface to represent the functionality
 * of operations.
 */

package lib;

public abstract class Operation {
    private String name;

    /**
     * Super constructor for naming your
     * operation. This is used by Calculator
     * to cast String -> Operation.
     * @param name a simple name for your operation
     */
    public Operation(String name) {
        this.name = name;
    }

    /**
     * @returns the name of the operation
     */
    public String getName() {
        return this.name;
    }

    /**
     * Executes the operation LTR.
     * @param a the number on the left-side of the operation
     * @param b the number on the right-side of the operation
     */
    public abstract double eval(double a, double b);
}