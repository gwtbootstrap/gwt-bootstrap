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
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HasAlignment;
import com.github.gwtbootstrap.client.ui.base.UnorderedList;
import com.github.gwtbootstrap.client.ui.constants.Alignment;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;

//@formatter:off
/**
 * A Nav menu of the Navbar.
 * 
 * @author Dominik Mayer
 */
//@formatter:on
public class Nav extends UnorderedList implements HasAlignment {

	public Nav() {
		addStyleName(Bootstrap.nav);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @deprecated This method should never be called directly. It will break
	 *             your implementation if any style names change. The only valid
	 *             use is inside UiBinder files where it processes the
	 *             <code>alignment="..."</code> argument. Use
	 *             {@link #setAlignment(Alignment)} instead!
	 */
	@Deprecated
	public void setAlignment(String alignment) {
		if (alignment.equalsIgnoreCase("left")) {
			setAlignment(Alignment.LEFT);
		} else if (alignment.equalsIgnoreCase("right")) {
			setAlignment(Alignment.RIGHT);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void setAlignment(Alignment alignment) {
		removeStyle(Alignment.RIGHT);
		removeStyle(Alignment.LEFT);
		addStyle(alignment);
	}
}
