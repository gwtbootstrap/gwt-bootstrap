/*
 *  Copyright 2012 GWT-Bootstrap
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.gwtbootstrap.client.ui.config;

import com.github.gwtbootstrap.client.ui.base.IsResponsive;
import com.github.gwtbootstrap.client.ui.resources.Resources;

/**
 * <h3>Using custom CSS/JS resources.</h3>
 *
 * <p>
 * GWT-Bootstrap uses embedded copies of bootstrap.css and bootstrap.js by default. If you need to use your own custom copies,
 * you'll need to create a custom {@link Configurator} and a custom {@link Resources}.
 * </p>
 * <p>
 * Full example below:
 * </p>
 * <p>
 * 1. First, in the src/main/java tree, create a resources package at the same level as client/server/shared.
 * Your custom {@link Configurator} and custom {@link Resources} will be placed in this resources package.
 * <pre>
 * src/main/java/com/example
 * |-- client
 * |-- resources
 * |   |-- ExampleResources.java < your custom Resources interface, see step 3
 * |   |-- ExampleConfigurator.java < your custom Configurator class, see step 4
 * |-- server
 * |-- shared
 * |-- Example.gwt.xml < your module xml file
 * </pre>
 * </p>
 *
 * <p>
 * 2. In the src/main/resources tree, create a directory structure that matches the one in src/main/java, so
 * src/main/resources/com/example/resources/. Beneath there, create css and js directories, and add your custom css and js files
 * into those.
 * <pre>
 * src/main/resources/com/example
 * |-- resources
 * |   |-- css
 * |   |   |-- bootstrap-custom.css < your custom css
 * |   |   |-- bootstrap-responsive-custom.css < your custom css
 * |   |-- js
 * |   |   |-- bootstrap-custom.js < your custom js
 * </pre>
 *
 * 3. Create a Resources interface (extending {@link Resources}) that overrides the
 * getters of the files you want to replace. Place in src/main/java/com/example.
 *
 * <pre>
 *  package com.example.resources;
 * 	public interface ExampleResources extends Resources {
 * 		{@literal @Source("com/example/resources/css/bootstrap-custom.css")}  < name anything you like, path must match the layout above
 * 		TextResource bootstrapCss();
 *
 * 		{@literal @Source("com/example/resources/css/bootstrap-responsive-custom.css")} < name anything you like, path must match the layout above
 * 		TextResource bootstrapResponsiveCss();
 * 	}
 * </pre>
 *
 * </p>
 *
 * <p>
 * 4. Create a <code>Configurator</code> that returns your new {@link Resources}. Place in src/main/java/com/example.
 *
 * <pre>
 *  package com.example.resources;
 * 	public ExampleConfigurator implements Configurator {
 * 		public Resources getResources() {
 * 			return GWT.create(ExampleResources.class);
 * 		}
 * 	}
 * </pre>
 *
 * </p>
 *
 * <p>
 * 5. Add a <code>replace-with</code> tag, a <code>source</code> tag, and a <code>public</code> tag to your module xml
 * (<code>*.gwt.xml</code>):
 *
 * <pre>
 * {@literal
 * <source path='resources'/>
 * <replace-with class="com.example.resources.ExampleConfigurator">
 *     <when-type-is class="com.github.gwtbootstrap.client.ui.config.Configurator"/>
 * </replace-with>
 * <public path="resources">
 *     <exclude name="** /*.java"/>
 *     <exclude name="** /*.class"/>
 * </public>
 *
 * }
 * </pre>
 *
 * </p>
 *
 * <p>A more detailed tutorial and a full working example can be found <a href="http://carlosbecker.com/posts/using-a-custom-bootstrap-theme-in-gwt-bootstrap">here</a>.</p>
 * @since 2.0.4.0
 *
 * @author Dominik Mayer
 * @author ohashi keisuke
 * @author Carlos A Becker
 * @author Greg Sheremeta
 *
 * @see Resources
 * @see DefaultConfigurator
 */
public interface Configurator {

	/**
	 * Get the Bootstrap Resources that should be used for this project.
	 *
	 * @return the Bootstrap Resources
	 */
	Resources getResources();

	//@formatter:off
	/**
	 * Determines whether the project uses a responsive design.
	 *
	 * <p>
	 * If the responsive
	 * design is enabled, the interface can adapt to the screen size and show
	 * different content on smartphones, tablets and desktop computers.
	 * </p>
	 *
	 * @return <code>true</code> if the responsive features should be enabled.
	 * Default: <code>false</code>
	 *
	 * @see IsResponsive
	 *
	 * @see <a href="http://twitter.github.com/bootstrap/scaffolding.html#responsive">Bootstrap documentation</a>
	 */
	boolean hasResponsiveDesign();
}
