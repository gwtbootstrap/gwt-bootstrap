package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.AbstractTypography;
import com.google.gwt.user.client.DOM;

/**
 * Simple inline code.
 * 
 * @author Dominik Mayer
 */
public class Code extends AbstractTypography {

	public Code() {
		setElement(DOM.createElement("code"));
	}
}
