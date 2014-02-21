package com.example.mvp;

import com.example.mvp.config.ExampleApplicationModule;
import com.example.mvp.main.MainPresenter;
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
public class MVPApplication extends Application {

    @Inject
    private MainPresenter mainController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        Guice.createInjector(new ExampleApplicationModule()).injectMembers(this);
        stage.setScene(new Scene(mainController.getRoot()));
        stage.show();
    }

}
