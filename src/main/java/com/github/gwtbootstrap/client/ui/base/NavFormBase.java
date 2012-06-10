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

import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.Form;
import com.github.gwtbootstrap.client.ui.constants.Alignment;

//@formatter:off
/**
 * Base class for forms inside a {@link com.github.gwtbootstrap.client.ui.Navbar
 * Navbar.}
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#navbar">Bootstrap documentation</a>
 */
//@formatter:on
public class NavFormBase extends Form implements HasAlignment, HasSize {

	private TextBox input = new TextBox();

	/**
	 * Creates a new, left-aligned form.
	 */
	public NavFormBase() {
		addStyle(Alignment.LEFT);
		add(input);
	}

	//@formatter:off
	/**
	 * Creates a new, left aligned form of the given size.
	 * 
	 * @param size the size of the form in the <a href="http://twitter.github.com/bootstrap/scaffolding.html#gridSystem">Bootstrap grid system</a>
	 */
	//@formatter:on
	public NavFormBase(int size) {
		this();
		setSize(size);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setAlignment(Alignment alignment) {
		removeStyle(Alignment.RIGHT);
		removeStyle(Alignment.LEFT);
		addStyle(alignment);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setSize(int size) {
		SizeHelper.setSize(input, size);
	}

	/**
	 * Returns the {@link TextBox} used by the widget.
	 * <p>
	 * Use it to append your own handlers or change its behavior.
	 * 
	 * @return the TextBox
	 */
	public TextBox getTextBox() {
		return input;
	}

	/**
	 * Sets a placeholder in the the TextBox.
	 * <p>
	 * A placeholder is a piece of text in the TextBox that disappears when the
	 * TextBox receives focus.
	 * 
	 * @param placeholder
	 *            the placeholder text
	 */
	public void setPlaceholder(String placeholder) {
		input.setPlaceholder(placeholder);
	}
}
