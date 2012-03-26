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
package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.Divider;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.NavText;
import com.github.gwtbootstrap.client.ui.UnorderedList;
import com.github.gwtbootstrap.client.ui.base.ComplexWidget;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author Carlos A Becker
 * @author Dominik Mayer
 */
public abstract class DropdownBase extends ComplexWidget {

	private UnorderedList menu = new UnorderedList();
	private IconAnchor trigger;
	
	private NavLink link;

	public DropdownBase(String type) {
		super(type);

		trigger = createTrigger();
		trigger.addStyleName("dropdown-toggle");
		trigger.getElement().setAttribute(Bootstrap.data_toggle, "dropdown");
		super.add(trigger);
		
		menu.setStyleName("dropdown-menu");
		super.add(menu);
	}

	public void setText(String text) {
		trigger.setText(text);
	}
	
	protected abstract IconAnchor createTrigger();
	
	public void setDropup(boolean dropup) {
		if (dropup)
			addStyleName(Bootstrap.dropup);
		else
			removeStyleName(Bootstrap.dropup);
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		if (trigger != null) {
			configure(trigger.getElement());
		}
	}

	@Override
	public void add(Widget w) {
		if ((w instanceof NavLink) || (w instanceof NavText) || 
				(w instanceof Divider))
			menu.add(w);
		else
			throw new IllegalArgumentException("Only NavLink, NavText and " +
					"Divider can be added to the Dropdown");
	}
	
	protected void addWidget(Widget w) {
		super.add(w);
	}

	private native void configure(Element e) /*-{
		$wnd.jQuery(e).dropdown();
	}-*/;
}
