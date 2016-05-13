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
import com.github.gwtbootstrap.client.ui.constants.Alignment;
import com.google.gwt.dom.client.Document;

//@formatter:off
/**
 * Left or right aligned blockquote with optional source.
 *
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code <b:Blockquote source="Leonard McCoy">He's dead, Jim</b:Blockquote>}
 * </pre>
 * 
 * All arguments are optional.
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Carlos Alexandro Becker
 * 
 * @see <a href="http://getbootstrap.com/2.3.2/base-css.html#typography">Bootstrap documentation</a>
 */
//@formatter:on
public class Blockquote extends AbstractTypography {

	/**
	 * Creates an empty Blockquote.
	 */
	public Blockquote() {
		setElement(Document.get().createElement("blockquote"));
	}

	/**
	 * Creates a Blockquote of the given text.
	 * 
	 * @param text
	 *            the text of the quote
	 */
	public Blockquote(String text) {
		setText(text);
	}

	/**
	 * Creates a Blockquote of the given text, attributed to the given source.
	 * 
	 * @param text
	 *            the text of the quote
	 * @param source
	 *            the source of the quote
	 */
	public Blockquote(String text, String source) {
		this(text);
		setSource(source);
	}

	/**
	 * Creates a Blockquote of the given text and optionally pulls it to the
	 * right side.
	 * 
	 * @param text
	 *            text of the quote
	 * @param pullRight
	 *            <code>true</code> if the quote should be pulled to the right
	 *            side. Default: <code>false</code>
	 */
	public Blockquote(String text, boolean pullRight) {
		setText(text);
		setPullRight(pullRight);
	}

	/**
	 * Creates a Blockquote of the given text, attributed to the given source
	 * and optionally pulls it to the right side.
	 * 
	 * @param text
	 *            text of the quote
	 * @param source
	 *            source of the quote
	 * @param pullRight
	 *            <code>true</code> if the quote should be pulled to the right
	 *            side. Default: <code>false</code>
	 */
	public Blockquote(String text, String source, boolean pullRight) {
		this(text);
		setSource(source);
		setPullRight(pullRight);
	}

	/**
	 * Sets the source of the quote. This may be a person or the title of a
	 * book, song, ...
	 * 
	 * @param source
	 *            the source of the quote
	 */
	public void setSource(String source) {
		getElement().appendChild(new SmallCite(source).getElement());
	}

	/**
	 * Sets whether the quote should be aligned left or right.
	 * 
	 * @param pullright
	 *            <code>true</code> if the quote should be pulled to the right
	 *            side. Default: <code>false</code>
	 */
	public void setPullRight(boolean pullright) {
		if (pullright)
			setStyle(Alignment.RIGHT);
		else
			setStyle(Alignment.NONE);
	}

	/**
	 * Element that shows the source of the quote.
	 * 
	 * @since 2.0.4.0
	 * 
	 * @author Carlos Alexandro Becker
	 */
	private class Cite extends AbstractTypography {

		/**
		 * Creates a Cite element of the given text
		 * 
		 * @param text
		 *            the text to be set
		 */
		public Cite(String text) {
			setElement(Document.get().createElement("cite"));
			setText(text);
		}
	}

	/**
	 * Element that shows the source of the quote in a smaller font.
	 * 
	 * @since 2.0.4.0
	 * 
	 * @author Carlos Alexandro Becker
	 */
	private class SmallCite extends AbstractTypography {

		private final Cite cite;

		public SmallCite(String text) {
			setElement(Document.get().createElement("small"));
			this.cite = new Cite(text);
			getElement().appendChild(cite.getElement());
		}

		@Override
		public void setText(String text) {
			cite.setText(text);
		}
	}
}
