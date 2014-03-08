package com.example.mvp.config;

import com.example.mvp.MVPApplication;
import io.advantageous.guicefx.JavaFXModule;

/**
 * This is a simple module for this application.  There is only one bind statement.  In fact, this one bind statement
 * isn't even totally necessary because the entry point does a (@link com.google.inject.Injector#injectMembers).
 * The reason that it is here is so when Guice constructs it's graph of dependencies, it will throw an nice readable
 * error if there is a problem in the entry-point class.  Without this bind here, if there were injection problems in
 * the entry point, you would get an ugly exception when you did the injectMembers.
 *
 * @author geoffc@gmail.com
 * @since 2/19/14 at 2:34 PM.
 */
public class ExampleApplicationModule extends JavaFXModule {

    @Override
    protected void configureFXApplication() {
        bind(MVPApplication.class);
    }
}
