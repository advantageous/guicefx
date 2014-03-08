package com.example.mvp.pages;

import com.example.mvp.main.MainPresenter;
import io.advantageous.guicefx.Presents;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.URL;
import java.util.ResourceBundle;

@Singleton
@Presents(value = "PageView.fxml")
public class Page2Presenter implements Initializable {

    @FXML
    private VBox root;

    @FXML
    private Label label;

    @FXML
    private Button button;

    @Inject
    private MainPresenter mainPresenter;

    @Inject
    private Page1Presenter page1Presenter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setText("This is page 2");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> mainPresenter.display(page1Presenter.getRoot()));
    }

    public VBox getRoot() {
        return root;
    }
}