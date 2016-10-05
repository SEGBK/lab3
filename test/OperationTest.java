/**
 * test/OperationTest.java - lab3
 * Tests the operation class.
 */

package test;

import lib.Operation;
import lib.Calculator;
import test.util.*;

public class OperationTest extends Test {
    public OperationTest() {
        super("test lib.Operation");
    }

    public void test(Runnable end) throws Throwable {
        Test.equal(new TestOperation().getName(), "\0", "should expose name properly");

        Test.equal(Calculator.getOperationByName("+").eval(2, 2), 4.0, "should create sum properly");
        Test.equal(Calculator.getOperationByName("-").eval(5, 2), 3.0, "should create difference properly");
        Test.equal(Calculator.getOperationByName("/").eval(4, 2), 2.0, "should create divide properly");
        Test.equal(Calculator.getOperationByName("*").eval(2, 3), 6.0, "should create multiply properly");
        Test.equal(Calculator.getOperationByName("^").eval(2, 3), 8.0, "should create power properly");

        end.run();
    }
}

class TestOperation extends Operation {
    public TestOperation() {
        super("\0");
    }

    public double eval(double a, double b){return 0.0;}
}