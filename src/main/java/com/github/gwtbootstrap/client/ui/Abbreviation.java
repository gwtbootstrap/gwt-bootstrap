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

import com.github.gwtbootstrap.client.ui.base.AbstractTypography;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.dom.client.Document;
import com.google.gwt.uibinder.client.UiConstructor;

/**
 * A text element that shows more information in a tooltip.
 * 
 * <p>
 * It is usually used to show the meaning of abbreviations. The text is lightly
 * underlined and on hover, the default cursor is replaced with a help cursor.
 * </p>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <code>{@code <b:Abbreviation title="This is the tooltip.">Some text</b:Abbreviation>}</code>
 * </p>
 * 
 * @author Carlos Alexandro Becker
 * @author Dominik Mayer
 * 
 * @since 2.0.4.0
 * 
 * @see <a
 *      href="http://getbootstrap.com/2.3.2/base-css.html#typography">Bootstrap
 *      documentation</a>
 */
public class Abbreviation extends AbstractTypography {

	/**
	 * Creates a new Abbreviation with both text and title set.
	 * 
	 * @param text
	 *            the underlined text
	 * @param title
	 *            the content of the popup
	 */
	public Abbreviation(String text, String title) {
		this(title);
		setText(text);
	}

	/**
	 * Creates an empty Abbreviation with only the content for the tooltip set.
	 * 
	 * @param title
	 *            The content of the popup
	 */
	public @UiConstructor
	Abbreviation(String title) {
		setElement(Document.get().createElement("abbr"));
		setTitle(title);
	}

	/**
	 * Specifies whether a slightly smaller text size should be used for the
	 * abbreviation. This does not affect the tooltip.
	 * 
	 * @param initialism
	 *            <code>true</code> for the slightly smaller size. Default:
	 *            <code>false</code>
	 */
	public void setInitalism(boolean initialism) {
		if (initialism)
			addStyleName(Constants.INITIALISM);
		else
			removeStyleName(Constants.INITIALISM);
	}

}