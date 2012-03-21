package com.geekvigarista.gwt.bootstrap.client.old.alerts;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.Bootstrap;

/**
 * A simple InfoAlertMessage Component based on Twitter's Bootstrap Alert.
 * 
 * @author Carlos Alexandro Becker
 * @since 22/01/2012
 */
public class InfoAlert extends Alert {

	{
		addStyleName(Bootstrap.info);
	}

	public InfoAlert(String text) {
		setText(text);
	}
}
