package com.google.inject.fx;

import javax.inject.Inject;

@Controls("BadTestView.fxml")
public class TestControllerWithBadXML {

    @Inject
    private TestDependency dependency;
}
