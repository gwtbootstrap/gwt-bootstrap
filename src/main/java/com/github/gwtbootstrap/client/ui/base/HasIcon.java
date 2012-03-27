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

/**
 * Interface for widgets that have icons.
 * 
 * @since 2.0.2.0
 * 
 * @author Dominik Mayer
 *
 */
public interface HasIcon {
	
	/**
	 * Sets the Type of the Icon.
	 * 
	 * @param type
	 */
	public void setIcon(Icon.Type type);

	/**
	 * Sets the type of the Icon based on the Bootstrap class name.
	 * 
	 * @param iconName name of the class to add without the leading "icon-".
	 */
	public void setIcon(String iconName);

	/**
	 * Sets the color of the icon.
	 * 
	 * <p>
	 * Default is black.
	 * 
	 * @param color the new color.
	 */
	public void setIconColor(Icon.Color color);
	
	/**
	 * Sets the color of the icon.
	 * 
	 * @param color <code>"black"</code> (default) or <code>"white"</code>
	 */
	public void setIconColor(String color);
}
