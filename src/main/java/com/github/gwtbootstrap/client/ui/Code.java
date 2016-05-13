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
import com.github.gwtbootstrap.client.ui.resources.prettify.HasProgrammingLanguage;
import com.github.gwtbootstrap.client.ui.resources.prettify.PrettifyHelper;
import com.google.gwt.dom.client.Document;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.HasHTML;

//@formatter:off
/**
 * Simple inline code with syntax highlighting.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code 
 * <b:Code><a href="http://gwtbootstrap.github.com">Link</a></b:Code>}
 * </pre>
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @author Carlos Alexandro Becker
 * 
 * @see <a href="http://getbootstrap.com/2.3.2/base-css.html#code">Bootstrap documentation</a>
 * @see CodeBlock
 */
//@formatter:on
public class Code extends AbstractTypography implements HasProgrammingLanguage,
		HasHTML {

	private final PrettifyHelper helper;

	/**
	 * Creates an empty widget.
	 */
	public Code() {
		setElement(Document.get().createElement("code"));
		helper = new PrettifyHelper(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onLoad() {
		super.onLoad();
		helper.configure();
	}

	//TODO
	/**
	 * {@inheritDoc}
	 */
	public void setLang(String programmingLanguage) {
		helper.setLang(programmingLanguage);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getHTML() {
		return getText();
	}

	/**
	 * Sets the widget's text.
	 * <p>
	 * Any HTML content is escaped and displayed as text.
	 * 
	 * @param html
	 *            the text to be set
	 */
	public void setHTML(String html) {
		getElement().setInnerHTML(SafeHtmlUtils.htmlEscapeAllowEntities(html));
	}
}
