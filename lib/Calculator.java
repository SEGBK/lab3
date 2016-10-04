/**
 * lib/Calculator.java - lab3
 * An abstract calculator library.
 */

package lib;

import lib.operations.*;

public class Calculator {
    // the order is important for evaluation
    public final static Operation[] SupportedOperations = new Operation[] {
        new Multiply(),
        new Divide(),
        new Add(),
        new Subtract()
    };

    /**
     * Adds a numerical value to the stack as a Number object.
     * @param number the numerical value to add as a Number object
     * @returns the Calculator object for chaining
     */
    public Calculator push(Number number) {
        // ...

        return this;
    }

    /**
     * Adds an operation to the stack where the operation
     * is a proper Operation object.
     * @param operation the Operation object
     * @returns the Calculator object for chaining
     */
    private Calculator push(Operation operation) {
        // TODO: write functionality
        return this;
    }

    /**
     * Adds a numerical value to the stack.
     * @param number the double value to add
     * @returns the Calculator object for chaining
     */
    public Calculator push(double value) {
        return this.push(new Number(value+""));
    }

    /**
     * Adds an operation to the stack where the operation
     * is a string.
     * @param operation the string representing the operation name
     * @returns the Calculator object for chaining
     */
    public Calculator push(String operation) throws UnsupportedOperation {
        // search for the appropriate operation
        for (Operation o : Calculator.SupportedOperations) {
            if (o.getName().equals(operation)) {
                return this.push(o);
            }
        }

        // throw error if this operation has not been implemented
        throw new UnsupportedOperation(operation);
    }

    /**
     * Executes all pending operations and returns the value.
     * @returns the numerical value of the operation result
     */
    public double pop() {
        // TOOD: write functionality
        return 0.0;
    }

    /**
     * Evaluates a String literal as a batch of operations.
     * @param string the literal containing all operations
     * @returns the result of the operations.
     */
    public double eval(String string) {
        // TODO: write functionality
        return 0.0;
    }

    /**
     * @returns true if operations are currently pending
     */
    public boolean isEmpty() {
        // TODO: write functionality
        return false;
    }

    /**
     * Creates a new instance of Number
     * @param string the first digit of the number
     * @returns a new Number object
     */
    public Number number(char start) {
        Number n = new Number();
        return n.push(start);
    }
}