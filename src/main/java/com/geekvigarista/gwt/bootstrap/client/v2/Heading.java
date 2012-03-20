package com.geekvigarista.gwt.bootstrap.client.v2;

import com.geekvigarista.gwt.bootstrap.client.v2.base.AbstractTypography;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.DOM;

/**
 *
 * @author carlos
 */
public class Heading extends AbstractTypography {
	
    public Heading(String text, int size) {
        this(size);
        setText(text);
    }
    
    public @UiConstructor Heading(int size) {
        size = size < 1 ? 1 : size > 6 ? 6 : size;
        setElement(DOM.createElement("h" + size));
    }
    
}
