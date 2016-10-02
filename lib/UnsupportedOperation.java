/**
 * lib/UnsupportedOperation.java - lab3
 * Exception to be thrown when String -> Operation cast fails.
 */

package lib;

class UnsupportedOperation extends Exception {
    public UnsupportedOperation(String name) {
        super("Unrecognized operation: " + name);
    }
}