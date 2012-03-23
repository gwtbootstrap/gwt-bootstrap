package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.AbstractTypography;
import com.github.gwtbootstrap.client.ui.resources.prettify.HasLang;
import com.github.gwtbootstrap.client.ui.resources.prettify.PrettifyHelper;
import com.google.gwt.user.client.DOM;

/**
 * Simple inline code.
 * 
 * @author Dominik Mayer
 * @author Carlos A Becker
 * 
 */
public class Code extends AbstractTypography implements HasLang {

	private final PrettifyHelper helper;
	
	public Code() {
		setElement(DOM.createElement("code"));
		helper = new PrettifyHelper(this);
	}
	
	@Override
	protected void onLoad() {
		super.onLoad();
		helper.configure();
	}

	public void setLang(String lang) {
		helper.setLang(lang);
	}
}
