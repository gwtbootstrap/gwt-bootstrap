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
import com.google.gwt.dom.client.Document;

//@formatter:off
/**
 * Simple wrapper for an HTML {@code <em>} tag.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:Emphasis>I'm important</b:Emphasis>
 * }
 * </pre>
 * </p>
 *
 * @since 2.0.4.0
 * 
 * @author Carlos Alexandro Becker
 * 
 * @see <a href="http://getbootstrap.com/2.3.2/base-css.html#typography">Bootstrap documentation</a>
 */
//@formatter:on
public class Emphasis extends AbstractTypography {

	/**
	 * Creates an empty widget.
	 */
	public Emphasis() {
		setElement(Document.get().createElement("em"));
	}

	/**
	 * Creates a widget with the given text.
	 * 
	 * @param text
	 *            the widget's text
	 */
	public Emphasis(String text) {
		this();
		setText(text);
	}

}
