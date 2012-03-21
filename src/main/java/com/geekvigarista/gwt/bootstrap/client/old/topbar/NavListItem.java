package com.geekvigarista.gwt.bootstrap.client.old.topbar;

import com.geekvigarista.gwt.bootstrap.client.old.ListItem;
import com.geekvigarista.gwt.bootstrap.client.ui.Navbar;
import com.google.gwt.user.client.ui.Anchor;

/**
 * A ListItem with a Anchor inside it, to be used in {@linkplain Navbar}.
 * 
 * @author Carlos Alexandro Becker
 * @since 25/01/2012
 */
public class NavListItem extends ListItem {

	public NavListItem(String text, String href) {
		Anchor a = new Anchor();
		a.setText(text);
		a.setHref(href);
		add(a);
	}
}
