package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.ComplexWidget;
import com.google.gwt.user.client.ui.HasText;

/**
 * Simple Paragraph.
 * 
 * @author Dominik Mayer
 */
public class Paragraph extends ComplexWidget implements HasText {

	public Paragraph() {
		super("p");
	}

	public String getText() {
		return getElement().getInnerText();
	}

	public void setText(String text) {
		getElement().setInnerText(text);
	}
	
	
}
