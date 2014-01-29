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
package com.github.gwtbootstrap.client.ui.base;

//@formatter:off
/**
 * Interface for widgets that have size according to the <a href="http://twitter.github.com/bootstrap/scaffolding.html#gridSystem">Bootstrap grid system.</a>
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 *
 */
public interface HasSize {

	/**
	 * Sets the widget's size.
	 * 
	 * @param size the size of the widget in the <a href="http://twitter.github.com/bootstrap/scaffolding.html#gridSystem">Bootstrap grid system</a>
	 */
	void setSize(int size);

}
