package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.DOM;


public class Caret extends AbstractTypography {

	public Caret() {
		this(true);
	}
	
	public Caret(boolean visible) {
		setElement(DOM.createElement("span"));
		if (visible)
			show();
	}
	
	public void show() {
		setStyleName(Bootstrap.caret);
	}
	
	public void hide() {
		removeStyleName(Bootstrap.caret);
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible)
			show();
		else
			hide();
	}
}
