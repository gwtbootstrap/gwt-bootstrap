package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.google.gwt.user.client.ui.HasText;

/**
 * Header for the nav list.
 * 
 * @author Dominik Mayer
 */
public class NavHeader extends ListItem implements HasText {

	public NavHeader() {
		setStyleName(BootstrapCssResources.nav_header);
	}

	public String getText() {
		return getElement().getInnerText();
	}

	public void setText(String text) {
		getElement().setInnerText(text);
	}
	
	
}
