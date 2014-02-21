package com.example.mvp.main;

import com.example.mvp.pages.Page1Presenter;
import com.example.mvp.pages.Page2Presenter;
import com.geoffreychandler.guicefx.LoadedBy;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LoadedBy("MainView.fxml")
public class MainPresenter {

    @FXML
    private BorderPane root;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private BorderPane contentArea;

    @Inject
    private Page1Presenter page1Presenter;

    @Inject
    private Page2Presenter page2Presenter;


    public void gotoPage1() {
        button1.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> display(page1Presenter.getRoot()));
    }

    public void gotoPage2() {
        button2.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> display(page2Presenter.getRoot()));
    }

    public void display(Node node) {
        contentArea.setCenter(node);
    }

    public BorderPane getRoot() {
        return root;
    }

}
