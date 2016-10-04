/**
 * test/EvaluableTest.java - lab3
 * Tests the Evaluable algorithm.
 */

package test;

import test.util.*;
import lib.*;

public class EvaluableTest extends Test {
    public EvaluableTest() {
        super("test lib.Evaluable");
    }

    public void test(Runnable end) throws Throwable {
        Evaluable e = new Evaluable();
        lib.Number TWO = new lib.Number("2"),
                   THREE = new lib.Number("3");
        
        Operation ADD = Calculator.SupportedOperations[2],
                  MLY = Calculator.SupportedOperations[0];

        Test.equal(e.pop(), 0.0, "evaluation should be zero by default");
        Test.equal(e.push(TWO), e, ".push() should chain");
        Test.equal(e.push(ADD).push(TWO).pop(), 4.0, "2 + 2 = 4");
        Test.equal(
            new Evaluable()
                .push(TWO)
                .push(ADD)
                .push(TWO)
                .push(MLY)
                .push(TWO)
                .pop(),
            6.0,
            "2 + 2 * 2 = 6 (not 8)"
        );

        end.run();
    }
}