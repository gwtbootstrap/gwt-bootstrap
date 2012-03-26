package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
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
				return Bootstrap.AlertStyle.ALERT.get();
			}
		},
		MODAL {
			@Override
			String get() {
				return "modal"; // FIXME
			}
		} ;
		abstract String get();
	}
	
	public Close() {
		setStyleName(Bootstrap.close);
		setHTML("&times;");
	}
	
	public Close(DataDismiss dismiss) {
		this();
		setDataDismiss(dismiss);
	}

	public void setDataDismiss(DataDismiss dismiss) {
		getElement().setAttribute(
				Bootstrap.data_dismiss, dismiss.get());
	}
	
	
}
