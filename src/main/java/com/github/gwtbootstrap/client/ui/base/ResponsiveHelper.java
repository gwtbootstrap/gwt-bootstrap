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

import com.github.gwtbootstrap.client.ui.config.Configurator;
import com.github.gwtbootstrap.client.ui.constants.Device;
import com.github.gwtbootstrap.client.ui.constants.ResponsiveStyle;

/**
 * The Helper class for {@link IsResponsive} interface.
 * 
 * @since 2.0.4.0
 * 
 * @see IsResponsive
 * @see Device
 * @author ohashi keisuke
 */
public class ResponsiveHelper {

	/**
	 * Sets the kind of device, this widget is shown on.
	 * 
	 * <p>
	 * The widget is not shown on any other device.
	 * </p>
	 * 
	 * <p>
	 * <b>Only works if responsive design is turned on!</b> Testlink
	 * </p>
	 * 
	 * @param widget
	 *            The widget to be applyed responsive.
	 * 
	 * @param device
	 *            The device to show widget.
	 * @see Configurator#hasResponsiveDesign()
	 * @see #setHideOn(HasStyle, Device)
	 */
	public static <T extends HasStyle> void setShowOn(T widget, Device device) {
		removeResponsiveStyles(widget);
		switch (device) {
			case PHONE:
				widget.addStyle(ResponsiveStyle.VISIBLE_PHONE);
				break;
			case TABLET:
				widget.addStyle(ResponsiveStyle.VISIBLE_TABLET);
				break;
			case DESKTOP:
				widget.addStyle(ResponsiveStyle.VISIBLE_DESKTOP);
				break;
		}
	}

	/**
	 * Sets the kind of device, this widget is hidden on.
	 * 
	 * <p>
	 * The widget is not hidden on any other device.
	 * </p>
	 * 
	 * <p>
	 * <b>Only works if responsive design is turned on!</b>
	 * </p>
	 * 
	 * @param widget
	 *            The widget to be applyed responsive.
	 * 
	 * @param device
	 *            The device to hide widget.
	 * 
	 * @see Configurator#hasResponsiveDesign()
	 * @see #setShowOn(HasStyle, Device)
	 */
	public static <T extends HasStyle> void setHideOn(T widget, Device device) {
		removeResponsiveStyles(widget);
		switch (device) {
			case PHONE:
				widget.addStyle(ResponsiveStyle.HIDDEN_PHONE);
				break;
			case TABLET:
				widget.addStyle(ResponsiveStyle.HIDDEN_TABLET);
				break;
			case DESKTOP:
				widget.addStyle(ResponsiveStyle.HIDDEN_DESKTOP);
				break;
		}
	}

	private static <T extends HasStyle> void removeResponsiveStyles(T element) {
		
		element.removeStyle(ResponsiveStyle.VISIBLE_PHONE);
		element.removeStyle(ResponsiveStyle.VISIBLE_TABLET);
		element.removeStyle(ResponsiveStyle.VISIBLE_DESKTOP);
		element.removeStyle(ResponsiveStyle.HIDDEN_PHONE);
		element.removeStyle(ResponsiveStyle.HIDDEN_TABLET);
		element.removeStyle(ResponsiveStyle.HIDDEN_DESKTOP);
	}

}
