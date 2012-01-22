package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Type;
import com.google.gwt.user.client.ui.Label;

public class Alert extends Label {

	public Alert() {
		super();
		setStyleName(BootstrapCssResources.alert_message);
		addStyleName(BootstrapCssResources.fade);
		addStyleName(BootstrapCssResources.in);
	}

	public Alert(String text) {
		this();
		setText(text);
	}

	public Alert(String text, Type type) {
		this();
		setText(text);
		setType(type);
	}

	public Alert(Type type) {
		this();
		setType(type);
	}

	public void setType(Type type) {
		// remove all types first
		for (Type t : Type.values()) {
			if (t.getType() != "") {
				removeStyleName(t.getType());
			}
		}
		addStyleName(type.getType());
	}

	@Override
	public void setText(String text) {
		getElement().setInnerHTML(
				"<a class=\"close\" href=\"#\">×</a><p>" + text + "</p>");
	}

	private native void jsPluginConfigurator()/*-{
		if (typeof $wnd.jQuery != "undefined") {
			$wnd.onload = function(){ jQuery(".alert-message").alert(); };
		}
	}-*/;

}
