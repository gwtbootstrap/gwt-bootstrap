package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.google.gwt.user.client.ui.Anchor;

/**
 * A close icon.
 * 
 * @author Dominik Mayer
 */
public class Close extends Anchor {

	public enum DataDismiss {

		ALERT {
			@Override
			String get() {
				return BootstrapCssResources.alert;
			}
		};
		abstract String get();
	}
	
	public Close() {
		setStyleName(BootstrapCssResources.close);
		setHTML("&times;");
	}
	
	public Close(DataDismiss dismiss) {
		this();
		setDataDismiss(dismiss);
	}

	public void setDataDismiss(DataDismiss dismiss) {
		getElement().setAttribute(
				BootstrapCssResources.data_dismiss, dismiss.get());
	}
	
	
}
