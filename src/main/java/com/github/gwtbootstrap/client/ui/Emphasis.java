package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.AbstractTypography;
import com.google.gwt.user.client.DOM;

/**
 *
 * @author carlos
 */
public class Emphasis extends AbstractTypography {

	public Emphasis() {
		setElement(DOM.createElement("em"));
	}
	
    public Emphasis(String text) {
    	this();
        setText(text);
    }
    
}
