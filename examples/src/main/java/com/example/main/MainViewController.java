package com.example.main;

import com.example.page1.Page1ViewController;
import com.example.page2.Page2ViewController;
import com.geoffreychandler.guicefx.Controls;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Controls("MainView.fxml")
public class MainViewController {

    @FXML
    private BorderPane root;

    @FXML
    private BorderPane contentArea;

    @Inject
    private Page1ViewController page1Controller;

    @Inject
    private Page2ViewController page2Controller;

    public BorderPane getRoot() {
        return root;
    }

    public void showPage1(ActionEvent event) {
        contentArea.setCenter(page1Controller.getRoot());
    }

    public void showPage2(ActionEvent event) {
        contentArea.setCenter(page2Controller.getRoot());
    }
}
