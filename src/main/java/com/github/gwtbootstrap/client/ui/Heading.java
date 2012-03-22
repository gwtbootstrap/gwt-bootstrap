package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.ComplexWidget;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.HasText;

/**
 *
 * @author carlos
 * @author Dominik Mayer
 */
public class Heading extends ComplexWidget implements HasText {
	
	private static final String SMALL = "small";
	
	private String text;
	
    public Heading(String text, int size) {
    	
        this(size);
        getElement().appendChild(Document.get().createElement(SMALL));
        setText(text);
    }
    
    public @UiConstructor Heading(int size) {
    	super("h" + (size < 1 ? 1 : size > 6 ? 6 : size));
    }
    
    public void setSubtext(String text) {
    	Element i = getElement().getElementsByTagName(SMALL).getItem(0);
    	i.setInnerText(text);
	}
    
    public void setText(String text) {
    	this.text = text;
        Element i = getElement().getElementsByTagName(SMALL).getItem(0);
        getElement().setInnerHTML(text + " " +
        		(i != null ? i.toString() : "<" + SMALL + "></" + SMALL + ">"));
    }

	public String getText() {
		return text;
	}
}
