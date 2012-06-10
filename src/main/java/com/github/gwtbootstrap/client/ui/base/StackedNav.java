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

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;

//@formatter:off
/**
 * Base class for nav widgets that can be stacked.
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#navs">Bootstrap documentation</a>
 */
//@formatter:on
public abstract class StackedNav extends UnorderedList {

	/**
	 * Creates an empty widget whose contents will not be stacked.
	 */
	public StackedNav() {
		addStyleName(Bootstrap.nav);
	}

	/**
	 * Sets whether the contents of the widget should be stacked or not.
	 * 
	 * @param stacked
	 *            <code>true</code> if the contents should appear stacked.
	 */
	public void setStacked(boolean stacked) {
		if (stacked)
			addStyleName(Bootstrap.nav_stacked);
		else
			removeStyleName(Bootstrap.nav_stacked);
	}
}