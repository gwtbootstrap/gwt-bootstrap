package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.BootStrapButtonBase;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Type;
import com.google.gwt.safehtml.shared.SafeHtml;

/**
 * The BootStrap InfoButton (it's a kind green or blue, now sure!)
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class InfoButton extends BootStrapButtonBase {
	{
		setType(Type.INFO);
	}

	public InfoButton() {
	}

	public InfoButton(String html) {
		this();
		setHTML(html);
	}

	public InfoButton(SafeHtml html) {
		this();
		setHTML(html);
	}
}
