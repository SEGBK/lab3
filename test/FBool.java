/**
 * test/FBool.java - lab3
 * A switch class for when you want to use
 * a boolean as final.
 */

package test;

class FBool {
    private boolean state = false;
    public void set(boolean state) { this.state = state; }
    public boolean state() { return this.state; }
}