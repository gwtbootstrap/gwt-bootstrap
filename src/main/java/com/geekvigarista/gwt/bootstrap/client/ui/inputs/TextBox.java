package com.geekvigarista.gwt.bootstrap.client.ui.inputs;

import com.geekvigarista.gwt.bootstrap.client.v2.resources.Span;

/**
 * The BootStrap TextBox.
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class TextBox extends com.google.gwt.user.client.ui.TextBox {

	public TextBox() {
		super();
		setSize(Span._3);
	}

	public TextBox(Span size) {
		super();
		setSize(size);
	}

	public void setSize(Span size) {
		setStyleName(size.getSize());
	}
}
