package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.AbstractTypography;
import com.google.gwt.user.client.DOM;

/**
 *
 * @author carlos
 */
public class Strong extends AbstractTypography {

	public Strong() {
		setElement(DOM.createElement("strong"));
	}
	
    public Strong(String text) {
    	this();
        setText(text);
    }
}
