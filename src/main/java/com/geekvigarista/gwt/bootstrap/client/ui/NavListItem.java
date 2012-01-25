package com.geekvigarista.gwt.bootstrap.client.ui;

import com.google.gwt.user.client.ui.Anchor;

public class NavListItem extends ListItem {
	public NavListItem(String text, String href) {
		Anchor a = new Anchor();
		a.setText(text);
		a.setHref(href);
		add(a);
	}
}
