package com.geekvigarista.gwt.bootstrap.client.ui.navbar;

import com.geekvigarista.gwt.bootstrap.client.ui.base.Form;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.ui.TextBox;

public class NavFormBase extends Form {

	private TextBox input = new TextBox();
	
	public NavFormBase() {
		addStyleName(Bootstrap.pull_left);
		add(input);
	}
	
	public NavFormBase(int size) {
		this();
		setSize(size);
	}
	
	public void setAlignment(String alignment) {
		if (alignment.equalsIgnoreCase("left")) {
			removeStyleName(Bootstrap.pull_right);
			addStyleName(Bootstrap.pull_left);
		} else if (alignment.equalsIgnoreCase("right")) {
			removeStyleName(Bootstrap.pull_left);
			addStyleName(Bootstrap.pull_right);
		}
	}
	
	public void setSize(int size) {
		input.addStyleName("span" + size);
	}
	
	public TextBox getTextBox() {
		return input;
	}
	
	public void setPlaceholder(String placeholder) {
		input.setText(placeholder);
	}
}
