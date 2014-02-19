package com.example.page2;

import com.geoffreychandler.guicefx.Controls;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import javax.inject.Singleton;

@Singleton
@Controls("Page2View.fxml")
public class Page2ViewController {

    @FXML
    private VBox root;

    public VBox getRoot() {
        return root;
    }
}
