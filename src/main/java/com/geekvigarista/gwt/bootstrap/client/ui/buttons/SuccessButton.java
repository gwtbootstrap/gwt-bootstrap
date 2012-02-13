package com.geekvigarista.gwt.bootstrap.client.ui.buttons;

import com.google.gwt.safehtml.shared.SafeHtml;

/**
 * The BootStrap SuccessButton (it's green!)
 *
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class SuccessButton extends BootStrapButtonBase {
	{
		setType(ButtonType.SUCCESS);
	}

	public SuccessButton() {
	}

	public SuccessButton(String html) {
		this();
		setHTML(html);
	}

	public SuccessButton(SafeHtml html) {
		this();
		setHTML(html);
	}
}
