package com.github.gwtbootstrap.showcase.client.util;

import com.google.gwt.text.shared.AbstractRenderer;


public class EnumRenderer<T extends Enum<T>> extends AbstractRenderer<T> {

	private final String emptyString;

	public EnumRenderer() {
		this("");
	}

	public EnumRenderer(String emptyString) {
		this.emptyString = emptyString;
	}
	
	
	@Override
	public String render(T object) {
		return object == null? emptyString : object.name();
	}

}
