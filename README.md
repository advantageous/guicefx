[![Build Status](https://travis-ci.org/sailorgeoffrey/guice-fx.png)](https://travis-ci.org/sailorgeoffrey/guice-fx)
#guice-fx
##Lightweight Guice integration for JavaFX

This is a simple library for creating a [MVP](http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter)
JavaFX application that uses [Google Guice](https://code.google.com/p/google-guice/).

##Quickstart

###1. Create a fxml view.

You will need to access the root of your view from your presenter, so make sure you put an fx:id on your root element.

```xml
    <VBox fx:id="root" xmlns:fx="http://javafx.com/fxml">
        <children>
            <Label fx:id="myText" text="Hello, world!"/>
        </children>
    </VBox>
```

###2. Use either the @Presents or @LoadedBy annotations on your controller/presenter classes.

```java
    @LoadedBy(value = "MyView.fxml")
    public class MyController {
        ...
    }
```

Use the @Presents if your fxml does not contain a fx:controller.

```java
    @Presents(value = "MyView.fxml")
    public class MyPresenter {
        ...
    }
```

###3. Map an FXML field to your root element and provide an accessor.

You will be injecting your presenters throughout your application and this will use this accessor to get the view.

```java
    @FXML
    private VBox root;

    public VBox getRoot() {
        return root;
    }
```

###4. Create a JavaFXModule just like you would create a Guice module.

```java
    public class MyApplicationModule extends JavaFXModule {

        @Override
        protected void configureFXApplication() {
            //Do your Guice config here
        }
    }
```

###5. Initialize your Guice module in the application entry-point and inject your presenter.

```java
    public class MyApplication extends Application {

        @Inject
        private MyPresenter myPresenter;

        @Override
        public void start(final Stage stage) throws Exception {
            Guice.createInjector(new MyApplicationModule()).injectMembers(this);
            stage.setScene(new Scene(myPresenter.getRoot()));
            stage.show();
        }

    }
```

###6. bind your entry-point class. (Optional, but recommended)

The entry-point class does a injectMembers on itself, so you may wonder why you would want to also add it in the binder.
The reason that it is here is so when Guice constructs it's graph of dependencies, it will throw an nice readable error
if there is a problem in the entry-point class.  Without this bind here, if there were injection problems in
the entry point, you would get an ugly exception when you did the injectMembers.

```java
    public class ExampleApplicationModule extends JavaFXModule {

        @Override
        protected void configureFXApplication() {
            bind(MVPApplication.class);
        }
    }
```

####A complete working example can be found in the examples folder of the project.