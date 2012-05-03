/*
 *  Copyright 2012 GWT-Bootstrap
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.Icon;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.IconColor;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.user.client.ui.HasText;

/**
 * An Anchor with optional image and caret.
 * 
 * <p>
 * It uses a HTML {@code <a>} tag and can contain text and child widgets. But
 * not both at the same time.
 * </p>
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * {@code <b:IconAnchor icon="plane" href="www.twitter.com">Some Text</b:IconAnchor>}
 * </p>
 * 
 * <p>
 * Here we add a second Icon:
 * 
 * <pre>
 * {@code <b:IconAnchor icon="STAR" text="There is a widget so the text goes here">
 *     <b:Icon type="STAR" />
 * </b:IconAnchor>}
 * </pre>
 * 
 * All parameter are optional. All setters can be used as parameters.
 * </p>
 * 
 * @since 2.0.3.0
 * 
 * @author Dominik Mayer
 * 
 */
public class IconAnchor extends ComplexWidget implements HasText, HasIcon,
		HasHref {

	private Icon icon = new Icon();

	private InlineLabel label = new InlineLabel();

	private String text = "";

	private Caret caret = new Caret();

	/**
	 * Creates the widget and sets the {@code href} property to
	 * {@code javascript:;} in order to avoid problems when clicking on it.
	 */
	public IconAnchor() {
		super("a");
		super.add(icon);
		super.add(label);
		setEmptyHref();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setIcon(IconType type) {
		if (type != null)
			this.icon.setType(type);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setIconColor(IconColor color) {
		icon.setColor(color);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setText(String text) {
		this.text = text;
		label.setText(" " + text + " ");
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return text;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setHref(String href) {
		getElement().setAttribute("href", href);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getHref() {
		return getElement().getAttribute("href");
	}

	/**
	 * Shows or hides the caret.
	 * 
	 * @param visible
	 *            <code>true</code> if the caret should be shown.
	 */
	public void setCaret(boolean visible) {
		if (visible)
			super.add(caret);
		else
			super.remove(caret);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setTargetHistoryToken(String targetHistoryToken) {
		setHref("#" + targetHistoryToken);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getTargetHistoryToken() {
		String[] hrefs = getHref().split("#");
		return hrefs[1];
	}

	/**
	 * Sets the <code>href</code>property of this element to "javascript:;" in
	 * order to get another cursor (hand).
	 */
	public void setEmptyHref() {
		setHref(Constants.EMPTY_HREF);
	}

	/**
	 * Inverts the color of the icon.
	 */
	public void invertIconColor() {
		icon.invertColor();
	}
}
