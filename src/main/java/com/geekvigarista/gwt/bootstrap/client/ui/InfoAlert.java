package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;

/**
 * A simple InfoAlertMessage Component based on Twitter's Bootstrap Alert.
 * 
 * @author Carlos Alexandro Becker
 * @since 22/01/2012
 */
public class InfoAlert extends Alert {

	{
		addStyleName(BootstrapCssResources.info);
	}

	public InfoAlert(String text) {
		setText(text);
	}
}
