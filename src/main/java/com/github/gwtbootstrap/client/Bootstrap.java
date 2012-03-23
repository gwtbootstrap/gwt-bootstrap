package com.github.gwtbootstrap.client;

import com.github.gwtbootstrap.client.ui.resources.ResourceInjector;
import com.google.gwt.core.client.EntryPoint;

public class Bootstrap implements EntryPoint {

	public void onModuleLoad() {
		ResourceInjector.configure();
	}

}
