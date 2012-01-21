package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootStrapButtonBase;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Type;
import com.google.gwt.safehtml.shared.SafeHtml;

/**
 * The BootStrap PrimaryButton (It's blue!)
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class PrimaryButton extends BootStrapButtonBase {
	{
		setType(Type.PRIMARY);
	}

	public PrimaryButton() {
	}

	public PrimaryButton(String html) {
		this();
		setHTML(html);
	}

	public PrimaryButton(SafeHtml html) {
		this();
		setHTML(html);
	}
}
