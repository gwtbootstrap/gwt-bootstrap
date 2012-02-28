package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.v2.base.ComplexWidget;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.google.gwt.dom.client.Element;

/**
 * Twipsy - The tooltip plugin from Twitter Bootstrap.
 * 
 * @author Carlos Alexandro Becker
 * @since 23/01/2012
 */
public class Twipsy extends ComplexWidget {

//	static {
//		ResourceInjector.injectJs(Resources.RESOURCES.twipsy());
//	}

	public Twipsy() {
		super("a");
		getElement().setAttribute("rel", BootstrapCssResources.twipsy);
	}

	public Twipsy(String title, String href, String text) {
		this();
		setTitle(title);
		setHref(href);
		setText(text);
	}

	@Override
	public void setTitle(String title) {
		getElement().setAttribute("title", title);
	}

	public void setText(String text) {
		getElement().setInnerText(text);
	}

	public void setHref(String href) {
		getElement().setAttribute("href", href);
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		twipsy(getElement());
	}

	private native void twipsy(Element e) /*-{
//		$wnd.jQuery(e).twipsy();
	}-*/;

}
