package com.geekvigarista.gwt.bootstrap.client.old.alerts;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.Bootstrap;

/**
 * A simple DangerAlertMessage Component based on Twitter's Bootstrap Alert.
 * 
 * @author Carlos Alexandro Becker
 * @since 22/01/2012
 */
public class ErrorAlert extends Alert {

	{
		addStyleName(Bootstrap.error);
	}

	public ErrorAlert(String text) {
		setText(text);
	}
}
