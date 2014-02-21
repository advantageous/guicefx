package guicefx;

import javax.inject.Inject;

@LoadedBy("BadTestView.fxml")
public class TestControllerWithBadXML {

    @Inject
    private TestDependency dependency;
}
