package com.geekvigarista.gwt.bootstrap.client.ui;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HasText;

/**
 * A Link in the Navbar.
 * 
 * @author Dominik Mayer
 */
public class NavLink extends ListItem implements HasText {

	private final Anchor anchor;

	public NavLink() {
		anchor = new Anchor();
		super.add(anchor);
	}
	
	public NavLink(String text) {
		this();
		anchor.setText(text);
	}

	public NavLink(String text, String href) {
		this();
		setText(text);
		setHref(href);
	}
	
	public void setHref(String href) {
		anchor.setHref(href);
	}
	
	public void setText(String text) {
		anchor.setText(text);
	}

	public String getText() {
		return anchor.getText();
	}
}
