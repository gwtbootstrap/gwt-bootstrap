package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DropdownBase;
import com.github.gwtbootstrap.client.ui.base.IconAnchor;

/**
 * 
 * @author Carlos A Becker
 * @author Dominik Mayer
 */
public class Dropdown extends DropdownBase {

	public Dropdown() {
		super("li");
		addStyleName("dropdown");
	}

	public Dropdown(String text) {
		this();
		setText(text);
	}
	
	@Override
	protected IconAnchor createTrigger() {
		IconAnchor trigger = new IconAnchor();
		trigger.setCaret(true);
		return trigger;
	}
}
