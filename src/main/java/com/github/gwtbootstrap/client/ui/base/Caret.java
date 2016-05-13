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

import com.github.gwtbootstrap.client.ui.Dropdown;
import com.github.gwtbootstrap.client.ui.DropdownButton;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.dom.client.Document;

/**
 * Icon used in Dropdowns to show the presence of a menu. Can point up- or
 * downwards, depending on the context.
 * <p>
 * <h3>UiBinder Usage:</h3>
 * {@code <b:Caret/>}
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see AbstractDropdownBase
 * @see Dropdown
 * @see DropdownButton
 * 
 */
public class Caret extends AbstractTypography {

	/**
	 * Creates a visible widget.
	 */
	public Caret() {
		this(true);
	}

	/**
	 * Creates a widget that can initially be hidden.
	 * 
	 * @param visible
	 *            <code>false</code> if the caret should be hidden. Default:
	 *            <code>true</code>
	 */
	public Caret(boolean visible) {
		setElement(Document.get().createSpanElement());
		if (visible)
			show();
	}

	/**
	 * Shows the widget.
	 */
	public void show() {
		setStyleName(Constants.CARET);
	}

	/**
	 * Hides the widget.
	 */
	public void hide() {
		removeStyleName(Constants.CARET);
	}

	/**
	 * Sets the visibility of the widget.
	 * 
	 * @param visible
	 *            <code>false</code> if the caret should be hidden. Default:
	 *            <code>true</code>
	 */
	@Override
	public void setVisible(boolean visible) {
		if (visible)
			show();
		else
			hide();
	}
}
