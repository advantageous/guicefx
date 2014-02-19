package com.google.inject.fx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * A Test Controller
 *
 * @author geoffc@gmail.com
 * @since 2/19/14 at 1:25 PM.
 */
@Controls("TestView.fxml")
public class TestController implements Initializable {

    @FXML
    private Text text;

    @FXML
    private Text missingText;

    @Inject
    private TestDependency dependency;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        text.setText(dependency.getText());
    }

    public Text getText() {
        return text;
    }

    public Text getMissingText() {
        return missingText;
    }
}
