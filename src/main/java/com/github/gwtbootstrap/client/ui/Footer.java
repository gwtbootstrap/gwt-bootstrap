package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.ComplexWidget;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;

/**
 * A Footer.
 * 
 * @author Dominik Mayer
 *
 */
public class Footer extends ComplexWidget {

	// TODO: No nice style in bootstrap. Delete?
	public Footer() {
		super("footer");
		setStyleName(Bootstrap.footer);
	}
}
