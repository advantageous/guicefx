package com.example.mvp.pages;

import com.example.mvp.main.MainPresenter;
import guicefx.Presents;
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
public class Page1Presenter implements Initializable {

    @FXML
    private VBox root;

    @FXML
    private Label label;

    @FXML
    private Button button;

    @Inject
    private MainPresenter mainPresenter;

    @Inject
    private Page2Presenter page2Presenter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setText("This is page 1");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> mainPresenter.display(page2Presenter.getRoot()));

    }

    public VBox getRoot() {
        return root;
    }
}
