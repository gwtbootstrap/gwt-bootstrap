package com.geekvigarista.gwt.bootstrap.client.ui.resources;

public enum ComponentTypeBase {

	OI("oi");

	private String style;

	ComponentTypeBase(String style) {
		this.style = style;
	}

	public String getStyle() {
		return style;
	}
}
