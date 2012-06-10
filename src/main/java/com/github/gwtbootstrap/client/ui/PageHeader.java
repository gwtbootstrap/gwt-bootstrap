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

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.ui.HasText;

//@formatter:off
/**
 * Header sections of the website.
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#typography">Bootstrap documentation</a>
 */
//@formatter:on
public class PageHeader extends DivWidget implements HasText {

	private final Heading heading = new Heading(1);

	public PageHeader() {
		setStyleName(Bootstrap.page_header);
		add(heading);
	}

	public String getText() {
		return heading.getText();
	}

	public void setText(String text) {
		heading.setText(text);
	}

	public void setSubtext(String text) {
		heading.setSubtext(text);
	}

}
