package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.Icon;
import com.google.gwt.user.client.ui.HasText;

/**
 * An Anchor with optional image and caret.
 * 
 * @author Dominik Mayer
 *
 */
public class IconAnchor extends ComplexWidget implements HasText {

	private Icon icon = new Icon();
	
	private InlineLabel label = new InlineLabel();
	
	private String text = "";
	
	private Caret caret = new Caret(false);

	public IconAnchor() {

		super("a");
		super.add(icon);
		super.add(label);
		super.add(caret);
		setHref("javascript:;");
	}

	public void setIcon(Icon icon) {
		if (icon == null) {
			return;
		}
		setIcon(icon.getStyleName());
	}

	public void setIcon(String iconname) {
		icon.setType(iconname);
	}

	public void setText(String text) {
		this.text = text;
		label.setText(" " + text + " ");
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
		this.caret.setVisible(caret);
	}

	public void setTargetHistoryToken(String targetHistoryToken) {
		setHref("#" + targetHistoryToken);
	}

	public void setIconColor(String color) {
		icon.setColor(color);
	}

}
