package com.google.inject.fx;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.ProvisionException;
import org.junit.Assert;
import org.junit.Test;

public class JavaFXModuleTest {

    @Test
    public void testInjection() throws Exception {
        Injector injector = Guice.createInjector(new JavaFXModule() {
            @Override
            protected void configureFXApplication() {
                bind(TestController.class);
            }
        });

        TestController testClass = injector.getInstance(TestController.class);
        Assert.assertEquals("Hello, World!", testClass.getText().getText());
    }

    @Test(expected = ProvisionException.class)
    public void testExceptionFromBadFXML() {
        Injector injector = Guice.createInjector(new JavaFXModule() {
            @Override
            protected void configureFXApplication() {
                bind(TestControllerWithBadXML.class);
            }
        });

        injector.getInstance(TestControllerWithBadXML.class);
    }
}
