package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DropdownBase;
import com.github.gwtbootstrap.client.ui.base.IconAnchor;

/**
 * A Button with a dropdown menu.
 * 
 * @author Dominik Mayer
 *
 */
public class DropdownButton extends DropdownBase {
	
	private Button trigger;

	public DropdownButton() {
		super("div");
		addStyleName("btn-group");
	}

	public DropdownButton(String text) {
		this();
		setText(text);
	}

	@Override
	protected IconAnchor createTrigger() {
		trigger = new Button();
		trigger.setCaret(true);
		return trigger;
	}
	
	public void setSize(String size) {
		trigger.setSize(size);
	}
	
	public void setType(String type) {
		trigger.setType(type);
	}
	
	public void setIcon(String icon) {
		trigger.setIcon(icon);
	}
	
}
