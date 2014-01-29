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

import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.resources.prettify.HasProgrammingLanguage;
import com.github.gwtbootstrap.client.ui.resources.prettify.PrettifyHelper;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasHTML;

//@formatter:off
/**
 * Block of Code with syntax highlighting.
 * <p>
 * Line breaks have to be escaped with "\n".
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code 
 * <b:CodeBlock linenums="true">}
 *     public class Person { \n
 *     \n
 *     private final String name;\n
 *     private final int age;\n
 *     }
 * {@code </b:CodeBlock>}
 * </pre>
 * All arguments are optional.
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @author Carlos Alexandro Becker
 * 
 * @see <a href="http://twitter.github.com/bootstrap/base-css.html#code">Bootstrap documentation</a>
 * @see Code
 */
//@formatter:on
public class CodeBlock extends HTMLPanel implements HasProgrammingLanguage, HasHTML {

	private final PrettifyHelper helper;
	private boolean linenums = false;

	/**
	 * Creates an empty widget.
	 */
	public CodeBlock() {
		super("pre", "");
		helper = new PrettifyHelper(this);
	}

	/**
	 * Creates a widget with the content set.
	 * 
	 * @param content
	 *            the content of the widget
	 */
	public CodeBlock(String content) {
		this();
		setHTML(content);
	}

	/**
	 * Sets whether the widget should be restricted to a maximum height of 350
	 * px with y-axis scrollbars enabled.
	 * 
	 * @param scrollable
	 *            <code>true</code> to show scrollbars. Default:
	 *            <code>false</code>
	 */
	public void setScrollable(boolean scrollable) {
		if (scrollable)
		    addStyleName(Constants.PRE_SCROLLABLE);
		else
			removeStyleName(Constants.PRE_SCROLLABLE);
	}

	/**
	 * Sets whether line numbers are shown.
	 * 
	 * @param linenums
	 *            <code>true</code> to show line numbers. Default:
	 *            <code>false</code>
	 */
	public void setLinenums(boolean linenums) {
		this.linenums = linenums;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getHTML() {
		return getElement().getInnerHTML();
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
		String[] lines = html.split("\\\\n");
		SafeHtmlBuilder shb = new SafeHtmlBuilder();

		for (String s : lines) {
			shb.appendEscaped(s);
			shb.appendHtmlConstant("<br/>");
		}
		
		if(getStyleName().contains("prettyprinted")) {
		    removeStyleName("prettyprinted");
		}

		getElement().setInnerHTML(shb.toSafeHtml().asString());
		
		if(isAttached()) {
		    helper.configure(linenums);
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return getHTML();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setText(String text) {
		setHTML(text);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setLang(String programmingLanguage) {
		helper.setLang(programmingLanguage);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onLoad() {
		super.onLoad();
		helper.configure(linenums);
	}
}
