package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.AbstractTypography;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.DOM;

/**
 *
 * @author carlos
 */
public class Abbreviation extends AbstractTypography {

    public Abbreviation(String text, String title) {
    	this(title);
        setText(text);
    }
    
    public @UiConstructor Abbreviation(String title) {
    	setElement(DOM.createElement("abbr"));
    	setTitle(title);
    }

}