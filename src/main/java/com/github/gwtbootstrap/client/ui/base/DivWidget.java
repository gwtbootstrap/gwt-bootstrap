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

import com.github.gwtbootstrap.client.ui.constants.Device;
import com.github.gwtbootstrap.client.ui.constants.ResponsiveStyle;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * A simple <code>div</code> widget with support for child widgets.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:DivWidget>
 *     <b:SomeChildWidget />
 *     <b:AnotherChildWidget />
 * </b:DivWidget>}
 * </pre>
 * 
 * </p>
 * 
 * @since 2.0.2.0
 * 
 * @author Carlos Alexandro Becker
 * @author Dominik Mayer
 */
public class DivWidget extends FlowPanel implements HasStyle, IsResponsive {

	/**
	 * Creates an empty widget.
	 */
	public DivWidget() {
		super();
	}

	/**
	 * Creates a widget and sets the provided style name. Technically it
	 * replaces the <code>div<code>s <code>class</code> property with the
	 * provided String.
	 * 
	 * @param styleName
	 *            the class to be added to the <code>div</code>
	 */
	public DivWidget(String styleName) {
		super();
		setStyleName(styleName);
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
	 * 
	 * @deprecated This Method should never be called directly. It will break
	 *             your implementation if any style names change. The only valid
	 *             use is inside UiBinder files where it processes the
	 *             <code>showOn="..."</code> argument. Use
	 *             {@link #setShowOn(Device)} instead!
	 */
	@Deprecated
	public void setShowOn(String device) {
		if (device.equalsIgnoreCase("phone")) {
			setShowOn(Device.PHONE);
		} else if (device.equalsIgnoreCase("tablet")) {
			setShowOn(Device.TABLET);
		} else if (device.equalsIgnoreCase("desktop")) {
			setShowOn(Device.DESKTOP);
		}
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

	/**
	 * {@inheritDoc}
	 * 
	 * @deprecated This Method should never be called directly. It will break
	 *             your implementation if any style names change. The only valid
	 *             use is inside UiBinder files where it processes the
	 *             <code>showOn="..."</code> argument. Use
	 *             {@link #setHideOn(Device)} instead!
	 * 
	 */
	@Deprecated
	public void setHideOn(String device) {
		if (device.equalsIgnoreCase("phone")) {
			setHideOn(Device.PHONE);
		} else if (device.equalsIgnoreCase("tablet")) {
			setHideOn(Device.TABLET);
		} else if (device.equalsIgnoreCase("desktop")) {
			setHideOn(Device.DESKTOP);
		}
	}
}
