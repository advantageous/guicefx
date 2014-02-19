package com.geoffreychandler.guicefx;

import javax.inject.Inject;

@Controls("BadTestView.fxml")
public class TestControllerWithBadXML {

    @Inject
    private TestDependency dependency;
}
