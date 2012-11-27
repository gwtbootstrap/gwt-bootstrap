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

import com.github.gwtbootstrap.client.ui.constants.BaseIconType;
import com.github.gwtbootstrap.client.ui.constants.IconPosition;
import com.github.gwtbootstrap.client.ui.constants.IconSize;
import com.github.gwtbootstrap.client.ui.constants.IconType;

/**
 * Interface for widgets that have icons.
 * 
 * @since 2.0.4.0
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
	public void setIcon(IconType type);

	/**
	 * Sets the BaseType of the Icon.
	 *
	 * @param type
	 */
	public void setBaseIcon(BaseIconType type);

	/**
	 * Sets the size of the icon.
	 * 
	 * <p>
	 * Default is DEFAULT.
	 * 
	 * @param size
	 *            the new size.
	 */
	public void setIconSize(IconSize size);
	
	/**
	 * Set custom icon style.
	 * <p>
	 * It sets css class name to {@literal <i>} tag.
	 * You can set any icons style.
	 * </p>
	 * 
	 * @param customIconStyle
	 */
	public void setCustomIconStyle(String customIconStyle);
	
	/**
	 * Set icon position , left or right
	 * @param position icon's position
	 */
	public void setIconPosition(IconPosition position);
}
