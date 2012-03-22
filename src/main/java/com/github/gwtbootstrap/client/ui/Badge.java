package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap.Style;
import com.google.gwt.user.client.ui.InlineLabel;

/**
 * A Badge to show some kind of count.
 * 
 * @author Dominik Mayer
 */
public class Badge extends InlineLabel {
	
	public Badge() {
		this(Bootstrap.Badge.DEFAULT);
	}
	
	public Badge(Bootstrap.Badge type) {
		setStyle(type);
	}
	
	private void setStyle(Style style) {
		setStyleName(style.get());
	}

	public void setType(String typename) {
		addStyleName("badge-" + typename);
	}
}
