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
package com.github.gwtbootstrap.client.ui.constants;

import com.github.gwtbootstrap.client.ui.base.Style;

/**
 * The way a responsive widget is shown.
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 */
public enum ResponsiveStyle implements Style {

	/**
	 * The widget is only shown on {@link Device#PHONE phones.}
	 */
	VISIBLE_PHONE(true, Device.PHONE),

	/**
	 * The widget is hidden on {@link Device#PHONE phones}.
	 */
	HIDDEN_PHONE(false, Device.PHONE),

	/**
	 * The widget is only shown on {@link Device#TABLET tablets.}
	 */
	VISIBLE_TABLET(true, Device.TABLET),

	/**
	 * The widget is hidden on {@link Device#TABLET tablets}.
	 */
	HIDDEN_TABLET(false, Device.TABLET),

	/**
	 * The widget is only shown on {@link Device#DESKTOP desktop computers.}
	 */
	VISIBLE_DESKTOP(true, Device.DESKTOP),

	/**
	 * The widget is hidden on {@link Device#DESKTOP desktop computers}.
	 */
	HIDDEN_DESKTOP(false, Device.DESKTOP);

	private static final String VISBILE_PREFIX = "visible-";

	private static final String HIDDEN_PREFIX = "hidden-";

	private boolean visible;

	private Device device;

	private ResponsiveStyle(boolean visible, Device device) {
		this.visible = visible;
		this.device = device;
	}

	/**
	 * {@inheritDoc}
	 */
	public String get() {
		String className;
		if (visible)
			className = VISBILE_PREFIX;
		else
			className = HIDDEN_PREFIX;

		return className + device.get();
	}
}
