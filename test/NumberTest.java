/**
 * test/NumberTest.java - lab3
 * Tests the functionality of the Number class.
 */

package test;

import test.util.*;
import lib.Number;

public class NumberTest extends Test {
    public NumberTest() {
        super("test lib.Number");
    }

    public void test(Runnable end) throws Exception {
        Number num = new Number();

        Test.equal(num.isEmpty(), true, "should be empty by default");
        Test.equal(num.pop(), 0.0, "should pop empty number as zero");
        Test.equal(num.hasDecimal(), false, "should not have decimal by default");

        num.back();
        Test.equal(true, true, "should not error for .back() on empty number");

        Test.equal(num.back(), num, "should chain .back()");
        Test.equal(num.push('3'), num, "should chain .push()");

        Test.equal(num.pop(), 3.0, "should pop single digit");
        Test.equal(num.push('.'), num, "should continue building after pop");
        Test.equal(num.push('1').push('4').pop(), 3.14, "should pop with decimal");
        Test.equal(num.hasDecimal(), true, "should find decimal in 3.14");
        Test.equal(num.isEmpty(), false, "should not be empty with 3.14");

        Test.equal(new Number(Math.PI+"").pop(), Math.PI, "should push and pop Math.PI");

        end.run(); 
    }
}