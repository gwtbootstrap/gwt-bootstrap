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
package com.github.gwtbootstrap.client.ui.incubator;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasHTML;

//@formatter:off
/**
 * Header for the column of a {@link Table}.
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/base-css.html#tables">Bootstrap documentation</a>
 */
//@formatter:on
public class TableHeader extends HTMLPanel implements HasHTML {

	public TableHeader() {
		super("th", "");
	}

	public TableHeader(String html) {
		this();
		setHTML(html);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return getElement().getInnerText();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setText(String text) {
		getElement().setInnerText(text);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getHTML() {
		return getElement().getInnerHTML();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setHTML(String html) {
		getElement().setInnerHTML(html);
	}
}
