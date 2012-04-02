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

import com.github.gwtbootstrap.client.ui.constants.Device;
import com.github.gwtbootstrap.client.ui.constants.ResponsiveStyle;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

/**
 * Helper class for widgets that have text.
 * 
 * @since 2.0.2.0
 * 
 * @author Carlos Alexandro Becker
 * 
 */
public abstract class AbstractTypography extends Widget implements HasText,
		HasStyle, IsResponsive {

	/**
	 * Creates a new widget without setting a DOM element.
	 */
	public AbstractTypography() {
		super();
	}

	/**
	 * Creates a new widget based on the given HTML tag.
	 * 
	 * @param tag
	 *            the HTML tag to be used
	 */
	public AbstractTypography(String tag) {
		setElement(DOM.createElement(tag));
	}

	/**
	 * {@inheritDoc}
	 */
	public void setText(String text) {
		getElement().setInnerText(text);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return getElement().getInnerText();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setStyle(Style style) {
		setStyleName(style.get());
	}

	/**
	 * {@inheritDoc}
	 */
	public void addStyle(Style style) {
		addStyleName(style.get());
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeStyle(Style style) {
		String styleString = style.get();
		if (!styleString.isEmpty())
			removeStyleName(styleString);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setShowOn(Device device) {
		removeResponsiveStyles();
		switch (device) {
			case PHONE:
				addStyle(ResponsiveStyle.VISIBLE_PHONE);
				break;
			case TABLET:
				addStyle(ResponsiveStyle.VISIBLE_TABLET);
				break;
			case DESKTOP:
				addStyle(ResponsiveStyle.VISIBLE_DESKTOP);
				break;
		}
	}

	private void removeResponsiveStyles() {
		removeStyle(ResponsiveStyle.VISIBLE_PHONE);
		removeStyle(ResponsiveStyle.VISIBLE_TABLET);
		removeStyle(ResponsiveStyle.VISIBLE_DESKTOP);
		removeStyle(ResponsiveStyle.HIDDEN_PHONE);
		removeStyle(ResponsiveStyle.HIDDEN_TABLET);
		removeStyle(ResponsiveStyle.HIDDEN_DESKTOP);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setHideOn(Device device) {
		removeResponsiveStyles();
		switch (device) {
			case PHONE:
				addStyle(ResponsiveStyle.HIDDEN_PHONE);
				break;
			case TABLET:
				addStyle(ResponsiveStyle.HIDDEN_TABLET);
				break;
			case DESKTOP:
				addStyle(ResponsiveStyle.HIDDEN_DESKTOP);
				break;
		}
	}
}
