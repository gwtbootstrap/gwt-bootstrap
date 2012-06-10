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
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.NavFormBase;
import com.github.gwtbootstrap.client.ui.constants.NavbarConstants;

//@formatter:off
/**
 * Form for the {@link Navbar}.
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#navbar">Bootstrap documentation</a>
 */
//@formatter:on
public class NavForm extends NavFormBase {

	/**
	 * Creates an empty form.
	 */
	public NavForm() {
		super();
		addStyleName(NavbarConstants.NAVBAR_FORM);
	}

	/**
	 * Creates an empty form of given size.
	 * 
	 * @param size
	 *            the size in the Bootstrap grid system
	 */
	public NavForm(int size) {
		super(size);
		addStyleName(NavbarConstants.NAVBAR_FORM);
	}
}
