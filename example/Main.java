/**
 * example/Main.java - lab3
 * An example to demonstrate the calculator library.
 */

package example;

import lib.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // simple chained calculations
        assertOrDie(calc.push(2).push('+').push(2).pop() == 4);
        
        // evaluating a String
        assertOrDie(calc.eval("2+2") == 4);

        // you can treat the calculator as a stack,
        // for all expected Stack methods
        assertOrDie(calc.isEmpty() == true);

        // numbers can be dynamically created digit-by-digit
        // using characters
        // Note: this class can also be treated as a stack
        assertOrDie(calc.number('3').push('.').push('1').push('4').pop() == 3.14);

        // you can also backtrack with the digits
        assertOrDie(calc.number('3').push('.').push('1').push('5').back().push('4').pop() == 3.14);

        // numbers are pushable just like doubles are
        // on the calculator
        lib.Number pi = calc.number('3').push('.').push('1').push('4');
        assertOrDie(calc.push(pi).push('*').push(2).pop() == 6.28);
    }

    private static void assertOrDie(boolean value) {
        if (!value) {
            System.out.format("ERROR: Something didn't work.");
            System.exit(-1);
        }
    }
}