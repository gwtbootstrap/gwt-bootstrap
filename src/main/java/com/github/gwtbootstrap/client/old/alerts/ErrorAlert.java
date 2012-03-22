package com.github.gwtbootstrap.client.old.alerts;

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;

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
