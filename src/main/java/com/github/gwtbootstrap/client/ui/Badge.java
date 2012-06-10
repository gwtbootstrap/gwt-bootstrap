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
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HasType;
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.constants.BadgeType;
import com.google.gwt.user.client.ui.InlineLabel;

//@formatter:off
/**
 * Badge to show some kind of count.
 *  
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code <b:Badge type="ERROR">2</b:Badge>}
 * </pre>
 * 
 * All arguments are optional.
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#badges">Bootstrap documentation</a>
 * @see Label
 */
//@formatter:on
public class Badge extends InlineLabel implements HasType<BadgeType> {

	/**
	 * Creates an empty default type Badge.
	 */
	public Badge() {
		this(BadgeType.DEFAULT);
	}

	/**
	 * Creates a default type Badge with the text set.
	 * 
	 * @param text
	 *            the text of the Badge
	 * 
	 * @see #Badge(int)
	 */
	public Badge(String text) {
		this();
		setText(text);
	}

	/**
	 * Creates a default type Badge with the text set.
	 * 
	 * @param number
	 *            text to be set
	 * 
	 * @see #Badge(String)
	 */
	public Badge(int number) {
		this();
		setText(String.valueOf(number));
	}

	/**
	 * Creates an empty Badge of the provided type.
	 * 
	 * @param type
	 *            the badge's type
	 */
	public Badge(BadgeType type) {
		setType(type);
	}

	/**
	 * Sets the type of the Badge.
	 * 
	 * @param type
	 *            the new type
	 */
	public void setType(BadgeType type) {
		StyleHelper.changeStyle(this, type, BadgeType.class);
	}
}
