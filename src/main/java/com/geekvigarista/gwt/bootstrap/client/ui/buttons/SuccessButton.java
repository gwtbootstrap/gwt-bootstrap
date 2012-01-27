package com.geekvigarista.gwt.bootstrap.client.ui.buttons;

import com.geekvigarista.gwt.bootstrap.client.ui.base.BootStrapButtonBase;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Type;
import com.google.gwt.safehtml.shared.SafeHtml;

/**
 * The BootStrap SuccessButton (it's green!)
 *
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class SuccessButton extends BootStrapButtonBase {
	{
		setType(Type.SUCCESS);
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
