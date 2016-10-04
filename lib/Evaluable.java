/**
 * lib/Evaluable.java - lab3
 * A stack for mananging a typed-in equation.
 */

package lib;

import java.util.Stack;

public class Evaluable {
    private Stack<Double> nStack;
    private Stack<Operation> oStack;

    /**
     * Creates a new Evaluable object.
     */
    public Evaluable() {
        this.nStack = new Stack<Double>();
        this.oStack = new Stack<Operation>();
    }

    /**
     * Adds a new Number to the stack.
     * @param number the number to add
     * @returns the Evaluable object for chaining
     */
    public Evaluable push(Number number) {
        this.nStack.push(number.pop());
        return this;
    }

    /**
     * Adds an operation to the stack.
     * @param operation the operation to add
     * @returns the Evaluation object for chaining
     */
    public Evaluable push(Operation operation) {
        this.oStack.push(operation);
        return this;
    }

    /**
     * Evaluates and pops the result.
     * @returns the result of the operations
     */
    public double pop() {
        // for empty stacks, pop zero
        if (this.nStack.size() == 0) return 0.0;

        Stack<Double> nnStack = new Stack<Double>();
        Stack<Operation> noStack = new Stack<Operation>();

        // as initial conditions, pop the first number off
        nnStack.push( nStack.pop() );

        // loop through the operations, and run algorithm for each
        for (int i = 0; i < Calculator.SupportedOperations.length && !(nStack.empty() && oStack.empty()); i ++) {
            while ( !(nStack.empty() && oStack.empty()) ) {
                Double a = nStack.pop();
                Operation b = oStack.pop();

                // execute if the operation's priority has brought it
                // into the loop
                if (b == Calculator.SupportedOperations[i]) {
                    nnStack.push(b.eval(nnStack.pop(), a));
                }
                
                // otherwise, just push onto the next stack
                else {
                    nnStack.push( a );
                    noStack.push( b );
                }
            }

            // change current stacks to next stacks,
            // then continue algorithm
            nStack = nnStack;
            oStack = noStack;

            nnStack = new Stack<Double>();
            noStack = new Stack<Operation>();

            nnStack.push( nStack.pop() );
        }

        // at the end, the next stack should have the
        // final result on top of it
        return nnStack.pop();
    }
}