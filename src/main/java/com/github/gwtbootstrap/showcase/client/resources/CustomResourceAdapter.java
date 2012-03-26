package com.github.gwtbootstrap.showcase.client.resources;

import com.github.gwtbootstrap.client.ui.resources.ResourceAdapter;
import com.github.gwtbootstrap.client.ui.resources.Resources;


public class CustomResourceAdapter implements ResourceAdapter {

	public Resources getResources() {
		return CustomResources.RESOURCES;
	}

	public boolean hasResponsiveDesign() {
		return false;
	}

}
