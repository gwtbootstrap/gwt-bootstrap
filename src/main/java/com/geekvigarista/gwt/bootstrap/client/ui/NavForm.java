package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.geekvigarista.gwt.bootstrap.client.ui.topbar.NavFormBase;

/**
 * Form in the Navbar.
 * 
 * @author Dominik Mayer
 */
public class NavForm extends NavFormBase {

	public NavForm() {
		super();
		addStyleName(BootstrapCssResources.navbar_form);
	}
	
	public NavForm(int size) {
		super(size);
		addStyleName(BootstrapCssResources.navbar_form);
	}
}
