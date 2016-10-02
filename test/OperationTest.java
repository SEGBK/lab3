/**
 * test/OperationTest.java - lab3
 * Tests the operation class.
 */

package test;

import lib.Operation;
import test.util.*;

public class OperationTest extends Test {
    public OperationTest() {
        super("test lib.Operation");
    }

    public void test(Runnable end) throws Throwable {
        Test.equal(new TestOperation().getName(), "n", "should expose name properly");
        end.run();
    }
}

class TestOperation extends Operation {
    public TestOperation() {
        super("n");
    }

    public double eval(double a, double b){return 0.0;}
}