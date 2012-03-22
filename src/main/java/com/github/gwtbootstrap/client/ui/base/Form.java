package com.github.gwtbootstrap.client.ui.base;

public class Form extends ComplexWidget {

	public Form() {
		super("form");
		getElement().setAttribute("type", "text");
	}
}
