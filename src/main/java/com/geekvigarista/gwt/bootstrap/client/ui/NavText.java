package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.Bootstrap;

/**
 * A Text in the Navbar.
 * 
 * @author Dominik Mayer
 */
public class NavText extends Paragraph {

	private Paragraph paragraph = new Paragraph();
	
	public NavText() {
		addStyleName(Bootstrap.navbar_text);
		addStyleName(Bootstrap.pull_left);
	}
	
	public NavText(String text) {
		this();
		paragraph.setText(text);
	}
	
	public void setAlignment(String alignment) {
		if (alignment.equalsIgnoreCase("left")) {
			removeStyleName(Bootstrap.pull_right);
			addStyleName(Bootstrap.pull_left);
		} else if (alignment.equalsIgnoreCase("right")) {
			removeStyleName(Bootstrap.pull_left);
			addStyleName(Bootstrap.pull_right);
		}
	}
}
