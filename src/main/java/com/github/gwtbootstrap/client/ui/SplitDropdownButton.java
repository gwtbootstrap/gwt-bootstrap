package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DropdownBase;
import com.github.gwtbootstrap.client.ui.base.IconAnchor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Dropdown button.
 * 
 * @author Dominik Mayer
 *
 */
public class SplitDropdownButton extends DropdownBase 
		implements HasClickHandlers {

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
	
	public void setOptions(String options) {
		button.setOptions(options);
	}
	
	public void setIcon(String icon) {
		button.setIcon(icon);
	}

	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return button.addClickHandler(handler);
	}
}
