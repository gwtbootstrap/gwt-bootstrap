package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.Bootstrap;

/**
 * A Nav menu of the Navbar.
 * 
 * @author Dominik Mayer
 */
public class Nav extends UnorderedList {

	public Nav() {
		addStyleName(Bootstrap.nav);
	}
	
	public void setAlignment(String alignment) {
		if (alignment.equalsIgnoreCase("left")) {
			removeStyleName(Bootstrap.pull_right);
			addStyleName(Bootstrap.pull_left);
		} else if (alignment.equalsIgnoreCase("right")) {
			removeStyleName(Bootstrap.pull_left);
			addStyleName(Bootstrap.pull_right);
		}
	}
}
