package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.Paragraph;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;

/**
 * A Text in the Navbar.
 * 
 * @author Dominik Mayer
 */
public class NavText extends Paragraph {

	private Paragraph paragraph = new Paragraph();
	
	public NavText() {
		addStyleName(BootstrapCssResources.navbar_text);
		addStyleName(BootstrapCssResources.pull_left);
	}
	
	public NavText(String text) {
		this();
		paragraph.setText(text);
	}
	
	public void setAlignment(String alignment) {
		if (alignment.equalsIgnoreCase("left")) {
			removeStyleName(BootstrapCssResources.pull_right);
			addStyleName(BootstrapCssResources.pull_left);
		} else if (alignment.equalsIgnoreCase("right")) {
			removeStyleName(BootstrapCssResources.pull_left);
			addStyleName(BootstrapCssResources.pull_right);
		}
	}
}
