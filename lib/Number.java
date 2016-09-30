/**
 * lib/Number.java - lab3
 * Management for dynamically created numbers.
 */

package lib;

public class Number {
    private String state;
    private boolean hasDecimal;

    /**
     * Creates a new number instance.
     */
    public Number() {
        this.state = "";
        this.hasDecimal = false;
    }

    /**
     * Creates a new number instance using a String
     * representation of the number.
     * @param number a string representation of the value
     */
    public Number(String number) {
        this.state = number;
        this.hasDecimal = number.indexOf(".") != -1;
    }

    /**
     * @returns whether a decimal exists in the number
     */
    public boolean hasDecimal() {
        return this.hasDecimal;
    }

    /**
     * Add a new digit to the number.
     * @param digit a single digit to add to the number.
     * @returns the Number object for chaining
     */
    public Number push(char digit) {
        // add digit to string
        if (!this.hasDecimal || digit != '.') {
            this.hasDecimal = this.hasDecimal || digit == '.';
            this.state += digit;
        }

        // keep chaining
        return this;
    }

    /**
     * Undo last digit.
     * @returns the Number object for chaining
     */
    public Number back() {
        int length = this.state.length();
        if (length > 0) {
            this.state = this.state.substring(0, length - 1);
        }

        return this;
    }

    /**
     * Parses and returns the double value of the number.
     * @returns a double value
     */
    public double pop() {
        return this.state.length() == 0 ? 0.0 : Double.parseDouble(this.state);
    }
}