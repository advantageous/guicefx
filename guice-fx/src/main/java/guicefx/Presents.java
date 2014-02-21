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

package guicefx;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * Provides Guice a FXML file that produces the {@link javafx.scene.Node}
 * controlled by the annotated class.
 * <p>
 * For example, this annotation indicates MainView.xml (in the same package)
 * will reference this controller in its fx:controller.
 * <pre>
 *    &#064;Presents("MainView.xml")
 *    public class MainPresenter {
 *        ...
 *    }
 * </pre>
 *
 * @author geoffc@gmail.com (Geoffrey Chandler)
 * @since 0.1.0
 */
@Documented
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Presents {
    String value();
}
