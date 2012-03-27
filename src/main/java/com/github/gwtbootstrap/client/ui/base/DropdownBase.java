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
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off
/**
 * Base class for dropdown widgets.
 * 
 * @since 2.0.2.0
 * 
 * @author Carlos A Becker
 * @author Dominik Mayer
 * 
 */
//@formatter:on
public abstract class DropdownBase extends ComplexWidget {

	private UnorderedList menu = new UnorderedList();

	private IconAnchor trigger;

	private NavLink link;

	/**
	 * Creates a new widget of the given type.
	 * 
	 * @param type
	 *            the HTML tag to be used for the widget
	 */
	public DropdownBase(String type) {
		super(type);
		createAndAddTrigger();
		menu.setStyleName("dropdown-menu");
		super.add(menu);
	}

	private void createAndAddTrigger() {
		trigger = createTrigger();
		trigger.addStyleName("dropdown-toggle");
		trigger.getElement().setAttribute(Constants.DATA_TOGGLE, "dropdown");
		super.add(trigger);
	}

	/**
	 * Sets the text of the dropdown trigger.
	 * 
	 * @param text
	 */
	public void setText(String text) {
		trigger.setText(text);
	}

	/**
	 * Implement this method to create the trigger appropriate for your widget.
	 * It has to be an {@link IconAnchor} or a subtype.
	 * 
	 * @return the created trigger
	 */
	protected abstract IconAnchor createTrigger();

	public void setDropup(boolean dropup) {
		if (dropup)
			addStyleName(Constants.DROPUP);
		else
			removeStyleName(Constants.DROPUP);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onLoad() {
		super.onLoad();
		if (trigger != null) {
			configure(trigger.getElement());
		}
	}

	/**
	 * Adds a widget to the dropdown menu.
	 * 
	 * @param widget
	 *            the widget that will be added to the menu
	 * 
	 * @see #addWidget(Widget)
	 */
	@Override
	public void add(Widget widget) {
		if (canBeAdded(widget))
			menu.add(widget);
		else
			throw new IllegalArgumentException("Only NavLink, NavText and "
					+ "Divider can be added to the Dropdown");
	}

	/**
	 * Checks whether a widget can be added to the dropdown.
	 * <p>
	 * By default, the dropdown accepts {@link NavLink}, {@link NavText} and
	 * {@link Divider} widgets. Override this class to allow more widgets.
	 * 
	 * @param widget
	 *            the widget that should be added
	 * 
	 * @return <code>true</code> if the widget can be added to the Dropdown
	 */
	protected boolean canBeAdded(Widget widget) {
		return ((widget instanceof NavLink) || (widget instanceof NavText) || (widget instanceof Divider));
	}

	/**
	 * Adds a widget to the the dropdown widget, <b>not</b> to the dropdown
	 * menu.
	 * 
	 * <p>
	 * Use {@link #add(Widget)} if you want to add a widget to the dropdown
	 * menu.
	 * 
	 * @param widget
	 *            the widget to be added.
	 */
	protected void addWidget(Widget widget) {
		super.add(widget);
	}

	private native void configure(Element e) /*-{
		$wnd.jQuery(e).dropdown();
	}-*/;
}
