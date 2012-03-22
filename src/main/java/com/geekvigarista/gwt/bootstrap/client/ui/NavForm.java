package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.navbar.NavFormBase;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Bootstrap;

/**
 * Form in the Navbar.
 * 
 * @author Dominik Mayer
 */
public class NavForm extends NavFormBase {

	public NavForm() {
		super();
		addStyleName(Bootstrap.navbar_form);
	}
	
	public NavForm(int size) {
		super(size);
		addStyleName(Bootstrap.navbar_form);
	}
}
