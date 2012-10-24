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

import com.google.gwt.user.client.ui.UIObject;

/**
 * The Helper class for {@link HasStyle} interface.
 *
 * @since 2.0.4.0
 *
 * @see HasStyle
 * @see Style
 *
 * @author ohashi keisuke
 * @author Carlos A Becker
 */
public class StyleHelper {

	/**
	 * Adds the provided style to the widget.
	 *
	 * @param widget
	 *            the widget to be added style.
	 * @param style
	 *            the style to be added to the Widget.
	 */
	public static <T extends UIObject> void addStyle(T widget, Style style) {
	    
	    if(style == null || style.get().isEmpty()) {
	        return;
	    }
	    
	    widget.addStyleName(style.get());
	}

	/**
	 * Replaces the widget's style with the provided one.
	 *
	 * @param widget
	 *            the widget to be applied style.
	 * @param style
	 *            the style to be applied to the Widget.
	 */
	public static <T extends UIObject> void setStyle(T widget, Style style) {
		widget.setStyleName(style.get());
	}

	/**
	 * Removes the provided style from the widget.
	 *
	 * @param widget
	 *            the widget to be removed style.
	 * @param style
	 *            the style to be removed from the Widget.
	 */
	public static <T extends UIObject> void removeStyle(T widget, Style style) {
		String styleString = style.get();

		if (!styleString.isEmpty()) {
			widget.removeStyleName(styleString);
		}
	}

	/**
	 * Change the style.
	 * @param widget the widget to be changed style.
	 * @param style the style to be applied to the widget.
	 * @param styleEnums other styles.
	 */
	public static <S extends Enum<S> & Style> void changeStyle(UIObject widget, S style,Class<S> styleEnums) {
		assert styleEnums != null : "styleEnums should not be null.";

		changeStyle(widget, style, styleEnums.getEnumConstants());
	}

	/**
	 * Change the style.
	 * @param widget the widget to be changed style.
	 * @param style the style to be applied to the widget.
	 * @param otherStyles other styles.
	 */
	public static <S extends Style> void changeStyle(UIObject widget,S style,S[] otherStyles) {

		assert widget != null && otherStyles != null : "any args should not be null.";

		for(S s : otherStyles) {
			removeStyle(widget, s);
		}

		addStyle(widget, style);
	}
	
}
