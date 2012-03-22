package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DropdownBase;
import com.github.gwtbootstrap.client.ui.base.IconAnchor;

/**
 * Dropdown button.
 * 
 * @author Dominik Mayer
 *
 */
public class SplitDropdownButton extends DropdownBase {

	private Button button;
	
	private Button trigger;
	
	public SplitDropdownButton() {
		super("div");
		addStyleName("btn-group");
	}
	
	public SplitDropdownButton(String text) {
		this();
		setText(text);
	}

	@Override
	public void setText(String text) {
		button.setText(text);
	}
	
	@Override
	protected IconAnchor createTrigger() {
		button = new Button();
		addWidget(button);
		trigger = new Button();
		trigger.setCaret(true);
		return trigger;
	}
}
