package com.github.gwtbootstrap.showcase.client.framework;

import com.github.gwtbootstrap.showcase.client.framework.HasMenuPlace.Menu;


public enum Menus implements Menu {
    OVERVIEW("overview" , "Overview"),
	LAYOUT("layout" , "Layout"),
	BASE("base", "Base Widgets"), 
	COMPONENT("component" , "Component"),
	GWT("gwt", "GWT Feature")
	;

	private final String name;
	private final String display;

	private Menus(String name, String display) {
		this.name = name;
		this.display = display;
		
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDisplay() {
		return display;
	}

}
