package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.ui.Anchor;

/**
 * Brand for the Navbar.
 * 
 * @author Dominik Mayer
 */
public class Brand extends Anchor {
	
	public Brand() {
		getElement().setClassName(Bootstrap.brand);
		getElement().addClassName(Bootstrap.active);
		getElement().setAttribute("href", "#");
	}
	
	public Brand(String projectName) {
		this();
		getElement().setInnerText(projectName);
	}
}
