package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.Icon;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.HasText;

public class IconAnchor extends ComplexWidget implements HasText {

	private String text;

	public IconAnchor() {

		super("a");
		getElement().appendChild(Document.get().createElement("i"));
	}

	public void setIcon(Icon icon) {
		if (icon == null) {
			return;
		}
		setIcon(icon.getStyleName());
	}

	public void setIcon(String iconname) {
		String[] iconnames = iconname.split(" ");
		String output = "";
		for (String s : iconnames) {
			output += (" icon-" + s);
		}
		getElement().getElementsByTagName("i").getItem(0).setClassName(output);
	}

	public void setText(String text) {
		this.text = text;
		Element i = getElement().getElementsByTagName("i").getItem(0);
		getElement().setInnerHTML(
				(i != null ? i.toString() : "<i></i>") + " " + text);
	}

	public String getText() {
		return text;
	}
}
