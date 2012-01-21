package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootStrapButtonBase;
import com.google.gwt.safehtml.shared.SafeHtml;

/**
 * Default BootStrap Button.
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class Button extends BootStrapButtonBase {

	public Button() {

	}

	public Button(SafeHtml html) {
		this(html.asString());
	}

	public Button(String html) {
		this();
		setHTML(html);
	}

}
