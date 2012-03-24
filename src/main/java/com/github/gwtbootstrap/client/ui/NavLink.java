package com.github.gwtbootstrap.client.ui;

import com.google.gwt.user.client.ui.HasText;

/**
 * A Link in the Navbar.
 * 
 * @author Dominik Mayer
 */
public class NavLink extends NavWidget implements HasText {

	public NavLink() {
		super();
	}

	public NavLink(String text, String href) {
		super();
		setText(text);
		setHref(href);
	}
}
