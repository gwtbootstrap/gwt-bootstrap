package com.geekvigarista.gwt.bootstrap.client;

import com.geekvigarista.gwt.bootstrap.client.ui.TextBox;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapConfigurator;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class BootStrap implements EntryPoint {
	public void onModuleLoad() {
		BootstrapConfigurator.configure();
		
		RootPanel.get().add(new TextBox());
	}
}
