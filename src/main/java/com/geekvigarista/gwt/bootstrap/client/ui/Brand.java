package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.google.gwt.user.client.ui.Anchor;

/**
 * Brand for the Navbar.
 * 
 * @author Dominik Mayer
 */
public class Brand extends Anchor {
	
	public Brand() {
		getElement().setClassName(BootstrapCssResources.brand);
		getElement().addClassName(BootstrapCssResources.active);
		getElement().setAttribute("href", "#");
	}
	
	public Brand(String projectName) {
		this();
		getElement().setInnerText(projectName);
	}
}
