package com.geoffreychandler.guicefx;

/**
 * Simple class that will be injected into a controller in a test.
 *
 * @author geoffc@gmail.com
 * @since 2/19/14 at 1:26 PM.
 */
class TestDependency {
    public String getText() {
        return "Hello, World!";
    }
}
