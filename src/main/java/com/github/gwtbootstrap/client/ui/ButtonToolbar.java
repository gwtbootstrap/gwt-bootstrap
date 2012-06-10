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
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off
/**
 * Toolbar that places different Buttons in a horizontal line.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code 
 * <b:ButtonToolbar>
 *     <b:ButtonGroup>
 *         <b:Button>1</b:Button>
 *         <b:Button>2</b:Button>
 *         <b:Button>3</b:Button>
 *     </b:ButtonGroup>
 *     <b:Button>4</b:Button>
 *     <b:Button>5</b:Button>
 *     <b:DropdownButton text="6">
 *         <b:NavLink>Some NavLink</b:NavLink>
 *         <b:NavLink>Another NavLink</b:NavLink>
 *     </b:DropdownButton>
 *     <b:SplitDropdownButton text="7">
 *         <b:NavLink>Some NavLink</b:NavLink>
 *         <b:NavLink>Another NavLink</b:NavLink>
 *     </b:SplitDropdownButton>
 * </b:ButtonToolbar>
 * }
 * </pre>
 * 
 * @since 2.0.4.0
 *
 * @author Carlos Alexandro Becker
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#buttonGroups">Bootstrap documentation</a>
 * @see Button
 * @see ButtonGroup
 * @see DropdownButton
 * @see SplitDropdownButton
 */
//@formatter:on
public class ButtonToolbar extends DivWidget {

	/**
	 * Creates an empty toolbar.
	 */
	public ButtonToolbar() {
		setStyleName(Constants.BTN_TOOLBAR);
	}

	/**
	 * Adds a new widget to the toolbar.
	 * 
	 * @param widget
	 *            the widget to be added
	 */
	@Override
	public void add(Widget widget) {

		Widget addingWidget = widget;

		if (!canBeAdded(widget))
			throw new IllegalArgumentException("A widget of "
					+ widget.getClass() + " cannot be added to the toolbar.");

		if (widget instanceof Button)
			addingWidget = new ButtonGroup((Button) widget);

		super.add(addingWidget);
	}

	/**
	 * This method decides whether a widget can be added to the toolbar or not.
	 * <p>
	 * Override it to allow other than the default widgets.
	 * 
	 * @param widget
	 *            the widget that should be added to the toolbar.
	 * @return <code>true</code> if the widget can be added to the toolbar.
	 */
	protected boolean canBeAdded(Widget widget) {
		return (widget instanceof ButtonGroup) || (widget instanceof Button)
				|| (widget instanceof DropdownButton)
				|| (widget instanceof SplitDropdownButton);
	}

}
