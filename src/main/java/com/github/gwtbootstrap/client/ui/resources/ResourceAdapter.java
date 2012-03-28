/*
 *  Copyright 2012 GWT Bootstrap
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
package com.github.gwtbootstrap.client.ui.resources;

import com.github.gwtbootstrap.client.ui.base.IsResponsive;

/**
 * <h3>Using custom css/js resources.</h3>
 * 
 * <p>
 * If you need to adapt resources, implement this interface, and add a
 * <code>replace-with</code> tag to your module xml. Example:
 * </p>
 * 
 * <p>
 * 1. Create a Resources Interface (extending {@link Resources}) override the
 * getters of the files you want to replace.
 * 
 * <pre>
 * 	public interface MyResources extends Resources {
 * 		{@literal @Source("mycss/custom-bootstrap.min.css")}
 * 		TextResource bootstrapCss();
 * 	}
 * </pre>
 * 
 * </p>
 * 
 * <p>
 * 2. Create a <code>ResourceAdapter</code>.
 * 
 * <pre>
 * 	public MyResourceAdapter implements ResourceAdapter {
 * 		public Resources getResources() {
 * 			return GWT.create(MyResources.class);
 * 		}
 * 	}
 * </pre>
 * 
 * </p>
 * 
 * <p>
 * 3. Add a <code>replace-with</code> tag to your module xml (
 * <code>*.gwt.xml</code>).
 * 
 * <pre>
 * {@literal <replace-with class="userpackage.MyResourceAdapter">
 * 	 <when-type-is class="com.github.gwtbootstrap.client.ui.resources.ResourceAdapter" />
 * </replace-with>}
 * </pre>
 * 
 * </p>
 * 
 * @since 2.0.2.0
 * 
 * @author soundTricker
 * @author Dominik Mayer
 * 
 * @see Resources
 * @see ResourceAdapterImpl
 */
public interface ResourceAdapter {

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
