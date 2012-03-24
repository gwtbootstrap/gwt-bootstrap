package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.ComplexWidget;

/**
 * A Form
 * 
 * @author Dominik Mayer
 *
 */
public class Form extends ComplexWidget {

	public Form() {
		super("Form");
	}
	
	public void setType(String type) {
		addStyleName("form-" +  type);
	}
}
