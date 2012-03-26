package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.github.gwtbootstrap.client.ui.resources.Style;
import com.google.gwt.user.client.ui.InlineLabel;

/**
 * A Inline Label Component. You could have multiple types :)
 * 
 * @author Carlos Alexandro Becker
 * @author Dominik Mayer
 * @since 23/01/2012
 */
public class Label extends InlineLabel {

	public Label() {
		setStyle(Bootstrap.Label.DEFAULT);
	}

	public Label(String text) {
		this();
		setText(text);
	}

	public Label(String text, Bootstrap.Label type) {
		setText(text);
		setType(type);
	}

	public void setType(Bootstrap.Label type) {
		assert type != null : "type should not be null";
		
		setStyle(type);
	}
	
	private void setStyle(Style style) {
		setStyleName(style.get());
	}

	public void setType(String typename) {
		if (typename.equalsIgnoreCase("success"))
			setStyle(Bootstrap.Label.SUCCESS);
		else if (typename.equalsIgnoreCase("warning"))
			setStyle(Bootstrap.Label.WARNING);
		else if (typename.equalsIgnoreCase("important"))
			setStyle(Bootstrap.Label.IMPORTANT);
		else if (typename.equalsIgnoreCase("info"))
			setStyle(Bootstrap.Label.INFO);
		else if (typename.equalsIgnoreCase("inverse"))
			setStyle(Bootstrap.Label.INVERSE);
		else
			setStyle(Bootstrap.Label.DEFAULT);
	}

}
