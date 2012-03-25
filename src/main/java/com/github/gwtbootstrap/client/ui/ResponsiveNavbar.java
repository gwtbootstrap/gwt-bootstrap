package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;

/**
 * A {@link Navbar} that hides the contents of a {@link NavCollapse} whenever
 * the width of the window is too small.
 * (Works only in combination with bootstrap-responsive.css.)
 * 
 * @author Dominik Mayer
 * @since 2012-03-25
 *
 */
public class ResponsiveNavbar extends Navbar {

	private final NavbarButton collapseButton = new NavbarButton();
	
	public ResponsiveNavbar() {
		super();
		collapseButton.getElement().setAttribute(
				Bootstrap.data_toggle, Bootstrap.collapse);
		collapseButton.getElement().setAttribute(
				Bootstrap.data_target, Bootstrap.nav_collapse_target);
		collapseButton.add(new Icon("bar"));
		collapseButton.add(new Icon("bar"));
		collapseButton.add(new Icon("bar"));
		add(collapseButton);
	}
}
