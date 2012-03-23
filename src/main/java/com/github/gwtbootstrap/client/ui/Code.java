package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.AbstractTypography;
import com.github.gwtbootstrap.client.ui.resources.JavaScriptInjector;
import com.github.gwtbootstrap.client.ui.resources.prettify.PrettifyResources;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.DOM;

/**
 * Simple inline code.
 * 
 * @author Dominik Mayer
 * @author Carlos A Becker
 * 
 */
public class Code extends AbstractTypography {

	static {
		JavaScriptInjector.inject(PrettifyResources.RESOURCES.prettify_js().getText());
		StyleInjector.inject(PrettifyResources.RESOURCES.prettify_css().getText());
	}

	public Code() {
		setElement(DOM.createElement("code"));
		addStyleName("prettyprint");
	}

	public void setLang(String lang) {
		int i = PrettifyResources.speciallangs.indexOf(lang);
		if (i > -1) {
			TextResource tr = null;
			switch (i) {
			case 0:
				tr = PrettifyResources.RESOURCES.apollo();
				break;
			case 1:
				tr = PrettifyResources.RESOURCES.clj();
				break;
			case 2:
				tr = PrettifyResources.RESOURCES.css();
				break;
			case 3:
				tr = PrettifyResources.RESOURCES.go();
				break;
			case 4:
				tr = PrettifyResources.RESOURCES.hs();
				break;
			case 5:
				tr = PrettifyResources.RESOURCES.lisp();
				break;
			case 6:
				tr = PrettifyResources.RESOURCES.lua();
				break;
			case 7:
				tr = PrettifyResources.RESOURCES.ml();
				break;
			case 8:
				tr = PrettifyResources.RESOURCES.ml();
				break;
			case 9:
				tr = PrettifyResources.RESOURCES.n();
				break;
			case 10:
				tr = PrettifyResources.RESOURCES.proto();
				break;
			case 11:
				tr = PrettifyResources.RESOURCES.scala();
				break;
			case 12:
				tr = PrettifyResources.RESOURCES.sql();
				break;
			case 13:
				tr = PrettifyResources.RESOURCES.tex();
				break;
			case 14:
				tr = PrettifyResources.RESOURCES.vb();
				break;
			case 15:
				tr = PrettifyResources.RESOURCES.vhdl();
				break;
			case 16:
				tr = PrettifyResources.RESOURCES.wiki();
				break;
			case 17:
				tr = PrettifyResources.RESOURCES.xq();
				break;

			default:
				break;
			}
			if(tr != null)
			{
				JavaScriptInjector.inject(tr.getText());
			}
		}
	}
	
	@Override
	protected void onLoad() {
		super.onLoad();
		configure();
	}
	
	private native void configure() /*-{
		$wnd.prettyPrint();
	}-*/;
}
