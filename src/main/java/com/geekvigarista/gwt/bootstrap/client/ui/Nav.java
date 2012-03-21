package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;

/**
 * A Nav menu of the Navbar.
 * 
 * @author Dominik Mayer
 */
public class Nav extends UnorderedList {

	public Nav() {
		addStyleName(BootstrapCssResources.nav);
	}
	
	public void setAlignment(String alignment) {
		if (alignment.equalsIgnoreCase("left")) {
			removeStyleName(BootstrapCssResources.pull_right);
			addStyleName(BootstrapCssResources.pull_left);
		} else if (alignment.equalsIgnoreCase("right")) {
			removeStyleName(BootstrapCssResources.pull_left);
			addStyleName(BootstrapCssResources.pull_right);
		}
	}
}
