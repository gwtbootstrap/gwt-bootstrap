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
package com.github.gwtbootstrap.client.ui.navbar;

import com.github.gwtbootstrap.client.ui.ListItem;
import com.github.gwtbootstrap.client.ui.Navbar;
import com.github.gwtbootstrap.client.ui.UnordenedList;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Anchor;

/**
 * Dropdown ListItem for {@link Navbar} and TabBar (FIXME: link).
 * 
 * @author Carlos Alexandro Becker
 * @since 25/01/2012
 */
public class DropdownListItem extends ListItem {

//	static {
//		ResourceInjector.injectJs(Resources.RESOURCES.dropdown());
//	}

	{
		setStyleName(Bootstrap.menu);
	}

	private final UnordenedList ul;
	private final Anchor a;

	public DropdownListItem(String text) {
		a = new Anchor(text);
		a.setHref("#");
		a.setStyleName(Bootstrap.menu);

		add(a);

		ul = new UnordenedList();
		ul.setStyleName(Bootstrap.menu_dropdown);

		add(ul);
	}

	public void addItem(ListItem li) {
		ul.add(li);
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		configure(getElement());
	}

	private native void configure(Element e) /*-{
		$wnd.jQuery(e).dropdown();
	}-*/;
}
