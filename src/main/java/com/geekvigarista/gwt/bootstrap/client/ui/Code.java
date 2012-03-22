package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.AbstractTypography;
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
