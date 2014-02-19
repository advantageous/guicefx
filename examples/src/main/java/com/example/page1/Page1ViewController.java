package com.example.page1;

import com.geoffreychandler.guicefx.Controls;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import javax.inject.Singleton;

@Singleton
@Controls("Page1View.fxml")
public class Page1ViewController {

    @FXML
    private VBox root;

    public VBox getRoot() {
        return root;
    }
}
