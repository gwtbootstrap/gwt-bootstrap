package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.AbstractTypography;
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
