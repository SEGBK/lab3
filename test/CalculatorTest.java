/**
 * test/CalculatorTest.java - lab3
 * Tests for Calculator.
 */

package test;

import lib.Calculator;
import test.util.*;

public class CalculatorTest extends Test {
    final Calculator calc = new Calculator();

    public CalculatorTest() {
        super("test lib.Calculator");
    }

    public void test(Runnable end) throws Throwable {
        Test.equal(calc.empty(), true, "should be empty to start");

        Test.equal(calc.push(3), calc, "should chain .push()");
        Test.equal(calc.pop(), 3.0, "should pop single value");
        Test.equal(calc.empty(), true, "should be empty after .pop()");
        Test.equal(calc.push(3).push("+").push(3).pop(), 6.0, "should sum two integers using stack");
        Test.equal(calc.eval("3+3"), 6.0, "should sum two integers using eval");

        end.run();
    }
}