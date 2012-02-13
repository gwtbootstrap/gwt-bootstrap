package com.geekvigarista.gwt.bootstrap.client.ui.buttons;

import com.google.gwt.safehtml.shared.SafeHtml;

/**
 * The BootStrap PrimaryButton (It's blue!)
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class PrimaryButton extends BootStrapButtonBase {
	{
		setType(ButtonType.PRIMARY);
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
