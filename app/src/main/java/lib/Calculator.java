/**
 * lib/Calculator.java - lab3
 * An abstract calculator library.
 */

package lib;

import lib.operations.*;
import java.util.ArrayList;

public class Calculator {
    // the order is important for evaluation
    public final static Operation[] SupportedOperations = new Operation[] {
        new Exponent(), // E
        new Divide(),   // D
        new Multiply(), // M
        new Add(),      // A
        new Subtract()  // S
    };

    // create an Evaluable stack for processing
    private Evaluable evaluable = new Evaluable();

    // history management
    private ArrayList<String> historyKeys = new ArrayList<String>();
    private ArrayList<Double> historyValues = new ArrayList<Double>();

    /**
     * Adds a numerical value to the stack as a Number object.
     * @param number the numerical value to add as a Number object
     * @returns the Calculator object for chaining
     */
    public Calculator push(lib.Number number) {
        this.evaluable.push(number);
        return this;
    }

    /**
     * Adds an operation to the stack where the operation
     * is a proper Operation object.
     * @param operation the Operation object
     * @returns the Calculator object for chaining
     */
    private Calculator push(Operation operation) {
        this.evaluable.push(operation);
        return this;
    }

    /**
     * Adds a numerical value to the stack.
     * @param number the double value to add
     * @returns the Calculator object for chaining
     */
    public Calculator push(double value) {
        return this.push(new lib.Number(value+""));
    }

    /**
     * Adds an operation to the stack where the operation
     * is a string.
     * @param operation the string representing the operation name
     * @returns the Calculator object for chaining
     */
    public Calculator push(String operation) throws UnsupportedOperation {
        Operation o = Calculator.getOperationByName(operation);

        // throw error if this operation has not been implemented
        if (o == null) {
            throw new UnsupportedOperation(operation);
        }

        return this.push(o);
    }

    /**
     * Adds an operation to the stack where the operation
     * is a character.
     * @param operation the character representing the operation name
     * @returns the Calculator object for chaining
     */
    public Calculator push(char c) throws UnsupportedOperation {
        String operation = c + "";
        Operation o = Calculator.getOperationByName(operation);

        // throw error if this operation has not been implemented
        if (o == null) {
            throw new UnsupportedOperation(operation);
        }

        return this.push(o);
    }

    /**
     * Grabs an operation by name.
     * @param operation the string representing the operation name
     * @returns the Operation object 
     */
    public static Operation getOperationByName(String operation) {
        // search for the appropriate operation
        for (Operation o : Calculator.SupportedOperations) {
            if (o.getName().equals(operation)) {
                return o;
            }
        }

        return null;
    }

    /**
     * Executes all pending operations and returns the value.
     * @returns the numerical value of the operation result
     */
    public double pop() {
        // save evaluable to history
        this.historyKeys.add(this.evaluable.toString());
        this.historyValues.add(this.evaluable.pop());

        // allocate new stack
        this.evaluable = new Evaluable();

        // return saved result
        return this.historyValues.get( this.historyValues.size() - 1 );
    }

    /**
     * Fetches a record of the history.
     * @returns an array of readable strings of previously evaluated stacks
     */
    public String[] history() {
        return (String[])this.historyKeys.toArray();
    }

    /**
     * Evaluates a String literal as a batch of operations.
     * @param string the literal containing all operations
     * @returns the result of the operations.
     */
    public double eval(String string) {
        // if we have the result cached, we should just return that
        int resIndex = this.historyKeys.indexOf(string);
        if (resIndex > -1) return this.historyValues.get(resIndex);

        lib.Number tmp = new lib.Number();
        Evaluable e = new Evaluable();
        boolean unpushed = false;

        for (int i = 0; i < string.length(); i ++) {
            String c = string.substring(i, i + 1);

            if (c.matches("[0-9.]")) {
                tmp.push(c.charAt(0));
                unpushed = true;
            } else {
                e.push(tmp);
                tmp = new lib.Number();
                unpushed = false;

                for (int j = 1; (i + j) < string.length(); j ++) {
                    if (string.substring(i + j, i + j + 1).matches("[0-9.]")) {
                        e.push(Calculator.getOperationByName(string.substring(i, i + j)));
                        i += j - 1;
                        break;
                    }
                }
            }
        }

        if (unpushed) e.push(tmp);
        return e.pop();
    }

    /**
     * @returns true if operations are currently pending
     */
    public boolean empty() {
        return this.evaluable.empty();
    }

    /**
     * Creates a new instance of Number
     * @param string the first digit of the number
     * @returns a new Number object
     */
    public lib.Number number(char start) {
        lib.Number n = new lib.Number();
        return n.push(start);
    }
}