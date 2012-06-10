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

/**
 * An interface for classes with a dedicated responsive behavior.
 * 
 * <p>
 * <b>They are only used if the responsive design is turned on!</b>
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see Configurator#hasResponsiveDesign()
 * @see <a
 *      href="http://twitter.github.com/bootstrap/scaffolding.html#responsive">Bootstrap
 *      documentation</a>
 * 
 */
public interface IsResponsive {

	/**
	 * Sets the kind of device, this widget is shown on.
	 * 
	 * <p>
	 * The widget is not shown on any other device.
	 * </p>
	 * 
	 * <p>
	 * <b>Only works if responsive design is turned on!</b>
	 * </p>
	 * 
	 * @param device
	 * 
	 * @see Configurator#hasResponsiveDesign()
	 * @see #setHideOn(Device)
	 */
	void setShowOn(Device device);

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
	 * @param device
	 * 
	 * @see Configurator#hasResponsiveDesign()
	 * @see #setShowOn(Device)
	 */
	void setHideOn(Device device);
}
