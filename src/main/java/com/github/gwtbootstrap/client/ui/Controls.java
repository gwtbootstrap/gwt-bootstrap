package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HtmlWidget;
import com.github.gwtbootstrap.client.ui.constants.Constants;

public class Controls extends HtmlWidget {

	public Controls(String html) {
		super("div", html);
		setStyleName(Constants.CONTROLS);
	}

	public Controls() {
		this("");
	}
}
