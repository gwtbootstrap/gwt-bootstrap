/*
 *  Copyright 2012 GWT Bootstrap
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
import com.google.gwt.user.client.ui.HasText;

/**
 * An Anchor with optional image and caret.
 * 
 * <p>
 * It uses a HTML {@code <a>} tag and can contain text and child widgets. 
 * But not both at the same time.
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
 * <pre>{@code <b:IconAnchor icon="star" text="There is a widget so the text goes here">
 *     <b:Icon type="star" />
 * </b:IconAnchor>}
 * </pre>
 * 
 * All parameter are optional. All setters can be used as parameters.
 * </p>
 * 
 * @since 2.0.2.0
 * 
 * @author Dominik Mayer
 *
 */
public class IconAnchor extends ComplexWidget implements HasText, HasIcon {

	private Icon icon = new Icon();
	
	private InlineLabel label = new InlineLabel();
	
	private String text = "";
	
	private Caret caret = new Caret(false);

	/**
	 * Creates the widget and sets the {@code href} property to 
	 * {@code javascript:;} in order to avoid problems when clicking on it.
	 */
	public IconAnchor() {
		super("a");
		super.add(icon);
		super.add(label);
		super.add(caret);
		setHref("javascript:;");
	}

	/**
	 * {@inheritDoc}
	 */
	public void setIcon(Icon.Type type) {
		if (type != null)
			this.icon.setType(type);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @deprecated This method should never be called directly. It will break
	 * your implementation if any style names change. The only valid use is 
	 * inside UiBinder files where it processes the <code>icon="..."</code>
	 * argument. Use {@link #setIcon(Icon.Type)} instead!
	 */
	@Deprecated
	public void setIcon(String iconName) {
		icon.setType(iconName);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setIconColor(Icon.Color color) {
		icon.setColor(color);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @deprecated This method should never be called directly. It will break
	 * your implementation if any style names change. The only valid use is 
	 * inside UiBinder files where it processes the <code>icon="..."</code>
	 * argument. Use {@link #setIconColor(Icon.Color)} instead!
	 */
	@Deprecated
	public void setIconColor(String color) {
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
	 * Sets the <code>href</code> property of the anchor tag.
	 * <p>
	 * Use it only to set links to another page. Links on the same page or
	 * GWT tokens should be set with {@code #setTargetHistoryToken(String)}
	 * 
	 * @param href the website URL
	 */
	public void setHref(String href) {
		getElement().setAttribute("href", href);
	}
	
	/**
	 * @return the URL of the website this link is pointing to
	 */
	public String getHref() {
		return getElement().getAttribute("href");
	}
	
	/**
	 * Shows or hides the caret.
	 * 
	 * @param visible <code>true</code> if the caret should be shown.
	 */
	public void setCaret(boolean visible) {
		caret.setVisible(visible);
	}

	/**
	 * Sets the <code>href</code> property of the anchor tag to
	 * <code>"#" + targetHistoryToken</code>.
	 * 
	 * @param targetHistoryToken the history token
	 */
	public void setTargetHistoryToken(String targetHistoryToken) {
		setHref("#" + targetHistoryToken);
	}

}
