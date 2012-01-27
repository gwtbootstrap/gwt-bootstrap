package com.geekvigarista.gwt.bootstrap.client.ui.buttons;

import com.geekvigarista.gwt.bootstrap.client.ui.base.BootStrapButtonBase;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.ResourceInjector;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Resources;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.shared.SafeHtml;

/**
 * Default BootStrap Button.
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class Button extends BootStrapButtonBase {

	static {
		ResourceInjector.injectJs(Resources.RESOURCES.buttons());
	}

	public Button() {

	}

	public Button(SafeHtml html) {
		this(html.asString());
	}

	public Button(String html) {
		this();
		setHTML(html);
	}
	
	// TODO: use Button plugin, set loading state etc..
	private native void configure(Element e, String action) /*-{
		if (typeof action == "undefined" || action == null || action == "") {
			$wnd.jQuery(e).button();
		} else {
			$wnd.jQuery(e).button(action);
		}
	}-*/;

}
