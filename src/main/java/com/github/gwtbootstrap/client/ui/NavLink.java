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

import com.google.gwt.user.client.ui.HasText;

//@formatter:off
/**
 * Link, used in a navigation context.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:NavList>
 *     <b:NavHeader>I'm the Header</b:NavHeader>
 *     <b:NavLink icon="PLANE">I'm a link to nowhere.</b:NavLink>
 * </b:NavList>
 * }
 * </pre>
 * All arguments are optional
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * @author ohashi keisuke
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#navbar">Bootstrap documentation (Navbar)</a>
 * @see <a href="http://twitter.github.com/bootstrap/components.html#navs">Bootstrap documentation (Navs)</a>
 * @see NavList
 * @see WellNavList
 * @see Dropdown
 * @see Navbar
 * @see ResponsiveNavbar
 */
//@formatter:on
public class NavLink extends NavWidget implements HasText {

	/**
	 * Creates an empty widget.
	 */
	public NavLink() {
		super();
	}

	/**
	 * Creates an empty widget of given text.
	 * 
	 * @param text
	 *            text of the widget
	 */
	public NavLink(String text) {
		super();
		setText(text);
	}

	/**
	 * Creates an empty widget of given text and href.
	 * 
	 * @param text
	 *            text of the widget
	 * @param href
	 *            URL the link should point to
	 */
	public NavLink(String text, String href) {
		super();
		setText(text);
		setHref(href);
	}
	
	/**
	 * Creates an empty widget of given text and href.
	 * 
	 * @param text
	 *            text of the widget
	 * @param href
	 *            URL the link should point to
	 * @param
	 *            target the target attribute
	 */
	public NavLink(String text, String href, String target) {
		super();
		setText(text);
		setHref(href);
		setTarget(target);
	}
}
