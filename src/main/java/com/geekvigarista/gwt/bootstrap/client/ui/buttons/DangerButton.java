package com.geekvigarista.gwt.bootstrap.client.ui.buttons;

import com.google.gwt.safehtml.shared.SafeHtml;

/**
 * The BootStrap DangerButton (it's red!!)
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class DangerButton extends BootStrapButtonBase {
	{
		setType(ButtonType.DANGER);
	}

	public DangerButton() {
	}

	public DangerButton(String html) {
		this();
		setHTML(html);
	}

	public DangerButton(SafeHtml html) {
		this();
		setHTML(html);
	}
}
