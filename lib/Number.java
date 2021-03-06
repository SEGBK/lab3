/**
 * lib/Number.java - lab3
 * Management for dynamically created numbers.
 */

package lib;

public class Number {
    private String state;
    private boolean hasDecimal, isNegative;

    /**
     * Creates a new number instance.
     */
    public Number() {
        this.state = "";
        this.hasDecimal = false;
        this.isNegative = false;
    }

    /**
     * Creates a new number instance using a String
     * representation of the number.
     * @param number a string representation of the value
     */
    public Number(String number) {
        this.hasDecimal = number.indexOf(".") != -1;
        this.isNegative = number.charAt(0) == '-';
        this.state = this.isNegative ? number.substring(1) : number;
    }

    /**
     * @returns whether a decimal exists in the number
     */
    public boolean hasDecimal() {
        return this.hasDecimal;
    }

    /**
     * @returns true if the number is a negative
     */
    public boolean isNegative() {
        return this.isNegative;
    }

    /**
     * Flips the switch on negative/positive.
     * @returns the Number object for chaining
     */
    public Number neg() {
        this.isNegative = !this.isNegative;
        return this;
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
     * @returns true if the number has no digits
     */
    public boolean isEmpty() {
        return this.state.length() == 0;
    }

    /**
     * Undo last digit.
     * @returns the Number object for chaining
     */
    public Number back() {
        if (!this.isEmpty()) {
            this.state = this.state.substring(0, this.state.length() - 1);
        }

        return this;
    }

    /**
     * Parses and returns the double value of the number.
     * @returns a double value
     */
    public double pop() {
        return this.isEmpty() ? 0.0 : Double.parseDouble(this.state);
    }
}