package com.github.gwtbootstrap.showcase.client.resources;

import com.github.gwtbootstrap.client.ui.resources.Resources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.TextResource;

public interface CustomResources extends Resources {
	
	public static final CustomResources RESOURCES = GWT.create(CustomResources.class);
	
	@Source("css/bootstrap-custom.css")
	TextResource bootstrap_css();

}
