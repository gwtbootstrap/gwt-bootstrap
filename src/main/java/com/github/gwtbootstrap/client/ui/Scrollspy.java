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

import com.google.gwt.dom.client.Element;

//@formatter:off
/**
 * {@linkplain}Navbar} uses this class for the scrollspy.
 * 
 * @author Carlos Alexandro Becker
 * 
 */
//@formatter:on
public class Scrollspy {

	private Navbar navbar;

	/**
	 * 
	 * @param navbar
	 *            The navbar that will be spied.
	 */
	public Scrollspy(Navbar navbar) {
		super();
		this.navbar = navbar;
	}

	public Navbar getNavbar() {
		return navbar;
	}

	public void setNavbar(Navbar navbar) {
		this.navbar = navbar;
	}

	/**
	 * Configure the scrollspy in the configured navbar.
	 */
	public void configure() {
		// TODO make it works for other things too... not only for body scroll.
		Element body =
				com.google.gwt.dom.client.Document.get()
						.getElementsByTagName("body").getItem(0);
		assert body != null : "houston, we need a body here!";
		body.setAttribute("data-spy", "scroll");
		jsConfigure(navbar.getElement());
	}

	private native void jsConfigure(Element e) /*-{
		$wnd.jQuery(e).scrollspy();
	}-*/;

}
