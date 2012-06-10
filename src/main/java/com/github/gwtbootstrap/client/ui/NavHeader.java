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

import com.github.gwtbootstrap.client.ui.base.ListItem;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.ui.HasText;

//@formatter:off
/**
 * Header for menus in a navigation context.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:NavList>
 *     <b:NavHeader>I'm the Header</b:NavHeader>
 *     <b:NavLink>I'm a link to nowhere.</b:NavLink>
 * </b:NavList>
 * }
 * </pre>
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#navs">Bootstrap documentation</a>
 * @see NavList
 * @see WellNavList
 * @see Dropdown
 */
//@formatter:on
public class NavHeader extends ListItem implements HasText {

	/**
	 * Creates an empty widget.
	 */
	public NavHeader() {
		setStyleName(Bootstrap.nav_header);
	}

	/**
	 * Creates a widget and sets the given text.
	 * 
	 * @param text
	 *            the text of the widget
	 */
	public NavHeader(String text) {
		this();
		setText(text);
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

}
