package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;

/**
 * A Button that can be used in the Navbar
 * 
 * @author Dominik Mayer
 *
 */
public class NavbarButton extends Button {

	public NavbarButton() {
		addStyle(Bootstrap.Button.NAVBAR);
	}
}
