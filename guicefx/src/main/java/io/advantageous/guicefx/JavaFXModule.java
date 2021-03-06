/*
 * Copyright (C) 2014. Geoffrey Chandler.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.advantageous.guicefx;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.AbstractMatcher;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * Abstract Guice module for JavaFX applications.  Extend this class just as you would extend Guice's AbstractModule and
 * implement {@link #configureFXApplication()}.  Any controllers annotated with {@link Presents} and {@link LoadedBy}
 * will be injected with dependencies as well as {@link javafx.fxml.FXML} annotations bound with JavaFX.
 *
 * @author geoffc@gmail.com (Geoffrey Chandler)
 * @since 0.1.0
 */
public abstract class JavaFXModule extends AbstractModule {

    /**
     * Configures a {@link com.google.inject.Binder} via the exposed methods.
     */
    protected abstract void configureFXApplication();

    /**
     * Binds two listeners for classes annotated with {@link Presents} and {@link LoadedBy}.  Classes annotated with
     * {@link Presents} will be directly set as the controller for the loaded fxml.  Classes annotated with
     * {@link LoadedBy} will be used in the controller factory created by the {@link javafx.fxml.FXMLLoader}.
     */
    @Override
    protected final void configure() {

        bindListener(
                new AbstractMatcher<TypeLiteral<?>>() {
                    @Override
                    public boolean matches(TypeLiteral<?> typeLiteral) {
                        return typeLiteral.getRawType().isAnnotationPresent(Presents.class);
                    }
                },
                new TypeListener() {
                    @Override
                    public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {
                        final Presents presents = type.getRawType().getAnnotation(Presents.class);
                        encounter.register((InjectionListener<I>) injectee -> {
                            final FXMLLoader loader = new FXMLLoader(injectee.getClass().getResource(presents.value()));
                            loader.setController(injectee);
                            try {
                                loader.load();
                            } catch (IOException e) {
                                addError(e);
                                throw new IllegalStateException(e);
                            }
                        });
                    }
                }
        );

        bindListener(
                new AbstractMatcher<TypeLiteral<?>>() {
                    @Override
                    public boolean matches(TypeLiteral<?> typeLiteral) {
                        return typeLiteral.getRawType().isAnnotationPresent(LoadedBy.class);
                    }
                },
                new TypeListener() {
                    @Override
                    public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {
                        final LoadedBy loadedBy = type.getRawType().getAnnotation(LoadedBy.class);
                        encounter.register((InjectionListener<I>) injectee -> {
                            final FXMLLoader loader = new FXMLLoader(injectee.getClass().getResource(loadedBy.value()));
                            loader.setControllerFactory(aClass -> injectee);
                            try {
                                loader.load();
                            } catch (IOException e) {
                                addError(e);
                                throw new IllegalStateException(e);
                            }
                        });
                    }
                }
        );

        configureFXApplication();
    }

}
