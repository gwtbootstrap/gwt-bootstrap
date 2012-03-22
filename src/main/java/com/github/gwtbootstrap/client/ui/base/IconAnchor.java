package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.Icon;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.HasText;

public class IconAnchor extends ComplexWidget implements HasText {

	private String text = "";
	
	private boolean caret = false;

	public IconAnchor() {

		super("a");
		setHref("javascript:;");
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
				(i != null ? i.toString() : "<i></i>") + " " + text + " " + 
				getCaret());
	}

	public String getText() {
		return text;
	}

	public void setHref(String href) {
		getElement().setAttribute("href", href);
	}
	
	public String getHref() {
		return getElement().getAttribute("href");
	}
	
	public void setCaret(boolean caret) {
		this.caret = caret;
		setText(text);
	}
	
	private String getCaret() {
		if (caret)
			return Bootstrap.caret;
		else
			return "";
	}

}
