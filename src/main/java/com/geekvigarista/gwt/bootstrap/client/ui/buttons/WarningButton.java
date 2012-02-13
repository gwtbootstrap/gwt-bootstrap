package com.geekvigarista.gwt.bootstrap.client.ui.buttons;

import com.google.gwt.safehtml.shared.SafeHtml;

public class WarningButton extends BootStrapButtonBase {
	{
		setType(ButtonType.WARNING);
	}

	public WarningButton() {
	}

	public WarningButton(String html) {
		this();
		setHTML(html);
	}

	public WarningButton(SafeHtml html) {
		this();
		setHTML(html);
	}
}
