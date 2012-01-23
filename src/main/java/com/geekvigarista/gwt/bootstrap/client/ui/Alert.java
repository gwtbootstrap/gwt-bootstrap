package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapConfigurator;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Resources;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.SizeHelper;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Span;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Type;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Label;

/**
 * A simple AlertMessage Component based on Twitter's Bootstrap Alert.
 * 
 * @author Carlos Alexandro Becker
 * @since 22/01/2012
 */
public class Alert extends Label {

	static {
		BootstrapConfigurator.injectJs(Resources.RESOURCES.alerts());
	}

	{
		setStyleName(BootstrapCssResources.alert_message);
		addStyleName(BootstrapCssResources.fade);
		addStyleName(BootstrapCssResources.in);
		setSize(Span._10);
	}

	private final String closebutton = "<a class=\"close\" href=\"#\">×</a>";

	protected Alert() {

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

	public void setSize(Span spanSize) {
		SizeHelper.setSize(spanSize, this);
	}

	public void setType(Type type) {
		assert type != null : "must specify a type.";
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
		jsPluginConfigurator(getElement());
	}

	public void setHTMLText(String... text) {
		getElement().setInnerHTML(closebutton);
		for (String html : text) {
			getElement().setInnerHTML(getElement().getInnerHTML() + html);
		}
	}

	@Override
	public void setText(String text) {
		getElement().setInnerHTML(closebutton + "<p>" + text + "</p>");
	}

	public void close() {
		close(getElement());
	}

	/*
	 * native functions.
	 */

	private native void jsPluginConfigurator(Element e) /*-{
		$wnd.jQuery(e).alert();
	}-*/;

	private native void close(Element e) /*-{
		$wnd.jQuery(e).alert('close');
	}-*/;

}
