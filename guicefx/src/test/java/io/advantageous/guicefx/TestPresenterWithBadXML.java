package io.advantageous.guicefx;

import javax.inject.Inject;

@Presents("BadTestView.fxml")
public class TestPresenterWithBadXML {

    @Inject
    private TestDependency dependency;
}
