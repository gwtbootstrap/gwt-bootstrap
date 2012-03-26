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

/**
 * <b>Using custom css/js resources.</b><br><br>
 * 
 * If you need to adapt resources, implement this interface,
 * and add a <code>replace-with</code> tag to your module xml. Example:<br><br>
 * 
 * 1. Create a Resources Interface (extending {@link Resources}).
 * <pre>
 * {@code
 * 	public interface MyResources extends Resources {
 * 		@Source("mycss/custom-bootstrap.min.css")
 * 		TextResource bootstrapCss();
 * 	}
 * </pre>
 * 
 * 2. Create a <code>ResourceAdapter</code>.
 * <pre>{@code
 * 	public MyResourceAdapter implements ResourceAdapter {
 * 		public Resources getResources() {
 * 			return GWT.create(MyResources.class);
 * 		}
 * 	}
 * </pre>
 * 3. Add a <code>replace-with</code> tag to your module xml (<code>*.gwt.xml</code>).
 * 
 * <pre>
 * {@code
 * <replace-with class="userpackage.MyResourceAdapter">
 * 	 <when-type-is class="com.github.gwtbootstrap.client.ui.resources.ResourceAdapter" />
 * </replace-with>
 * }
 * </pre>
 * 
 * 
 * </p>
 * @author soundTricker
 * @author Dominik Mayer
 * @since 24/03/2012
 * @see Resources
 * @see ResourceAdapterImpl
 */
public interface ResourceAdapter {

	/**
	 * Get Resources
	 * 
	 * @return Resources
	 */
	Resources getResources();
	
	boolean hasResponsiveDesign();
}
