package com.example;

import com.example.config.ExampleApplicationModule;
import com.example.main.MainViewController;
import com.google.inject.Guice;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.inject.Inject;

/**
 * The entry-point for the application.
 *
 * @author geoffc@gmail.com
 * @since 2/19/14 at 2:35 PM.
 */
public class ExampleApplication extends Application {

    @Inject
    private MainViewController mainController;

    {
        Guice.createInjector(new ExampleApplicationModule()).injectMembers(this);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setScene(new Scene(mainController.getRoot()));
        stage.show();
    }

}
