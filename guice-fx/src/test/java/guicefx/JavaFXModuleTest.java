package guicefx;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.ProvisionException;
import org.junit.Assert;
import org.junit.Test;

public class JavaFXModuleTest {

    @Test
    public void testLoadedBy() throws Exception {
        Injector injector = Guice.createInjector(new JavaFXModule() {
            @Override
            protected void configureFXApplication() {
                bind(TestController.class);
            }
        });

        TestController testClass = injector.getInstance(TestController.class);
        Assert.assertEquals("Hello, World!", testClass.getText().getText());
    }

    @Test
    public void testPresents() throws Exception {
        Injector injector = Guice.createInjector(new JavaFXModule() {
            @Override
            protected void configureFXApplication() {
                bind(TestPresenter.class);
            }
        });

        TestPresenter testClass = injector.getInstance(TestPresenter.class);
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

    @Test(expected = ProvisionException.class)
    public void testPresenterExceptionFromBadFXML() {
        Injector injector = Guice.createInjector(new JavaFXModule() {
            @Override
            protected void configureFXApplication() {
                bind(TestPresenterWithBadXML.class);
            }
        });

        injector.getInstance(TestPresenterWithBadXML.class);
    }
}
