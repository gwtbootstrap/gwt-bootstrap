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
import com.github.gwtbootstrap.client.ui.base.ComplexWidget;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.HasText;

//@formatter:off
/**
 * Heading with optional subtext.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code 
 * <b:Heading size="2" text="And I'm the subtext">I'm the heading</b:Heading>}
 * </pre>
 * Specifying the <code>size</code> is mandatory.
 * </p>
 *
 * @since 2.0.4.0
 * 
 * @author Carlos Alexandro Becker
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/base-css.html#typography">Bootstrap documentation</a>
 */
//@formatter:on
public class Heading extends ComplexWidget implements HasText {

	private static final int HEADER_MINIMUM = 1;

	private static final int HEADER_MAXIMUM = 6;

	private Small small = new Small();

	private String text;

	/**
	 * Creates a new Heading of given size.
	 * 
	 * @param size
	 *            the size of the heading
	 */
	public @UiConstructor
	Heading(int size) {
		super("h" + size);
		if (size < HEADER_MINIMUM || size > HEADER_MAXIMUM)
			throw new IllegalArgumentException(
					"The size of the header must be between 1 and 6.");

		super.add(small);
	}

	/**
	 * Creates a new Heading of given size and text.
	 * 
	 * @param size
	 *            size of the heading
	 * @param text
	 *            text of the heading
	 */
	public Heading(int size, String text) {
		this(size);
		setText(text);
	}

	/**
	 * Creates a new Heading of given size, text and subtext.
	 * 
	 * @param size
	 *            size of the heading
	 * @param text
	 *            text of the heading
	 * @param subtext
	 *            subtext of the heading
	 */
	public Heading(int size, String text, String subtext) {
		this(size, text);
		setSubtext(subtext);
	}

	/**
	 * Sets the heading's subtext.
	 * 
	 * @param subtext
	 *            the heading's subtext
	 */
	public void setSubtext(String subtext) {
		small.setText(subtext);
		redraw();
	}

	private void redraw() {
		setText(this.text);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setText(String text) {
		this.text = text;

	    // Add a space after the main heading text to get the same effect as Twitter Bootstrap.
        // <h1>Some text <small>Some subtext</small></h1>
        //              ^- Note the space
		getElement().setInnerHTML(text + " " + small.toString());
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return text;
	}

	private class Small extends AbstractTypography {

		public Small() {
			super("small");
		}
	}
}
