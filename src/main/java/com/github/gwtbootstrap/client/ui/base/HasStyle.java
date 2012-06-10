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

/**
 * Interface for components that have a {@link Style}
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 */
public interface HasStyle {

	/**
	 * Replaces the widet's style with the provided one.
	 * 
	 * @param style
	 *            the style to be applied to the Widget.
	 */
	void setStyle(Style style);

	/**
	 * Adds the provided style to the widget.
	 * 
	 * @param style
	 *            the style to be added to the Widget.
	 */
	void addStyle(Style style);

	/**
	 * Removes the provided style from the widget.
	 * 
	 * @param style
	 *            the style to be removed from the Widget.
	 */
	void removeStyle(Style style);
}
