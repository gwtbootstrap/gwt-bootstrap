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
package com.github.gwtbootstrap.client.ui.constants;

import com.github.gwtbootstrap.client.ui.Navbar;
import com.github.gwtbootstrap.client.ui.ResponsiveNavbar;
import com.github.gwtbootstrap.client.ui.base.Style;

//@formatter:off
/**
 * Position of a fixed {@link Navbar}.
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#navbar">Bootstrap documentation</a>
 * @see ResponsiveNavbar
 */
//@formatter:on
public enum NavbarPosition implements Style {

	/**
	 * The Navbar is not fixed and appears at the place where it was defined.
	 */
	DEFAULT(""),

	/**
	 * The Navbar is fixed at the top.
	 */
	TOP("navbar-fixed-top"),

	/**
	 * The Navbar is fixed at the bottom.
	 */
	BOTTOM("navbar-fixed-bottom"),
	
	/** The Navbar is static at the top. */
	STATIC_TOP("navbar-static-top");

	private String className;

	private NavbarPosition(String className) {
		this.className = className;
	}

	/**
	 * {@inheritDoc}
	 */
	public String get() {
		return className;
	}
}
