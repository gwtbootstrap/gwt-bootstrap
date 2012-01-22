package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.JavaScriptInjector;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Resources;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Type;
import com.google.gwt.user.client.ui.Label;

/**
 * A simple AlertMessage Component based on Twitter's Bootstrap Alert.
 * 
 * @author Carlos Alexandro Becker
 * @since 22/01/2012
 */
public class Alert extends Label {

	{
		JavaScriptInjector.inject(Resources.RESOURCES.alerts().getText());
		setStyleName(BootstrapCssResources.alert_message);
		addStyleName(BootstrapCssResources.fade);
		addStyleName(BootstrapCssResources.in);
	}

	public Alert(String text) {
		setText(text);
	}

	public Alert(String text, Type type) {
		setText(text);
		setType(type);
	}

	public Alert(Type type) {
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
	protected void onLoad() {
		super.onLoad();
		jsPluginConfigurator();
	}
	
	@Override
	public void setText(String text) {
		getElement().setInnerHTML(
				"<a class=\"close\" href=\"#\">×</a><p>" + text + "</p>");
	}

	private static native void jsPluginConfigurator() /*-{
		$wnd.jQuery(".alert-message").alert();
	}-*/;

}
