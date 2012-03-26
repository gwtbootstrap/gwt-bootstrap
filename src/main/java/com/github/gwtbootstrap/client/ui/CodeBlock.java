/*
 *  Copyright 2012 GWT Bootstrap
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

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.github.gwtbootstrap.client.ui.resources.prettify.HasLang;
import com.github.gwtbootstrap.client.ui.resources.prettify.PrettifyHelper;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * A block of Code
 * 
 * @author Dominik Mayer
 */
public class CodeBlock extends HTMLPanel implements HasLang {

	private final PrettifyHelper helper;
	private boolean linenums = false;
	
	public CodeBlock() {
		super("pre", "");
		helper = new PrettifyHelper(this);
	}

	public CodeBlock(String html) {
		super("pre", html);
		helper = new PrettifyHelper(this);
		setHTML(html);
	}

	public void setScrollable(boolean scrollable) {
		if (scrollable)
			addStyleName(Bootstrap.pre_scrollable);
		else
			removeStyleName(Bootstrap.pre_scrollable);
	}

	public void setLinenums(boolean linenums) {
		this.linenums = linenums;
	}

	public String getHTML() {
		return getElement().getInnerHTML();
	}

	public void setHTML(String html) {
		String[] lines = html.split("\\\\n");
		SafeHtmlBuilder shb = new SafeHtmlBuilder();

		for (String s : lines) {
			shb.appendEscaped(s);
			shb.appendHtmlConstant("<br/>");
		}

		getElement().setInnerHTML(shb.toSafeHtml().asString());
	}

	public String getText() {
		return getHTML();
	}

	public void setText(String text) {
		setHTML(text);
	}

	public void setLang(String lang) {
		helper.setLang(lang);
	}
	
	@Override
	protected void onLoad() {
		super.onLoad();
		helper.configure(linenums);
	}
}
