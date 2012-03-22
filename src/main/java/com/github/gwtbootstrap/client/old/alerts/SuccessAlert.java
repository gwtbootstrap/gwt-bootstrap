package com.github.gwtbootstrap.client.old.alerts;

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;

/**
 * A simple SuccessAlertMessage Component based on Twitter's Bootstrap Alert.
 * 
 * @author Carlos Alexandro Becker
 * @since 22/01/2012
 */
public class SuccessAlert extends Alert {

	{
		addStyleName(Bootstrap.success);
	}

	public SuccessAlert(String text) {
		setText(text);
	}
}
