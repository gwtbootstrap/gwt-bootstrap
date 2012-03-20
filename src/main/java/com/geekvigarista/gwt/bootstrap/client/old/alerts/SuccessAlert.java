package com.geekvigarista.gwt.bootstrap.client.old.alerts;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;

/**
 * A simple SuccessAlertMessage Component based on Twitter's Bootstrap Alert.
 * 
 * @author Carlos Alexandro Becker
 * @since 22/01/2012
 */
public class SuccessAlert extends Alert {

	{
		addStyleName(BootstrapCssResources.success);
	}

	public SuccessAlert(String text) {
		setText(text);
	}
}
