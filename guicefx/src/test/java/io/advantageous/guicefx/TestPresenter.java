package io.advantageous.guicefx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * A Test Presenter
 *
 * @author geoffc@gmail.com
 * @since 2/19/14 at 1:25 PM.
 */
@Presents("UnboundTestView.fxml")
public class TestPresenter implements Initializable {

    @FXML
    private Text text;

    @Inject
    private TestDependency dependency;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        text.setText(dependency.getText());
    }

    public Text getText() {
        return text;
    }

}
