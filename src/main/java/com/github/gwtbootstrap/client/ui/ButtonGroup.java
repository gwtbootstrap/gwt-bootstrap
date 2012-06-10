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
import com.github.gwtbootstrap.client.ui.constants.ToggleType;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off
/**
 * ButtonGroups take buttons and combine them to one optically integrated
 * widget.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code 
 * <b:ButtonGroup>
 *     <b:Button>First Button</b:Button>
 *     <b:Button>Second Button</b:Button>
 *     <b:Button>Third Button</b:Button>
 * </b:ButtonGroup>}
 * </pre>
 * 
 * You can also use the buttons as checkboxes or radio buttons:
 * 
 * <pre>
 * {@code
 * <b:ButtonGroup toggle="radio">
 * 	<b:Button text="1" />
 * 		<b:Button text="2" />
 * 	<b:Button text="3" />
 * 	<b:Button text="4" />
 * </b:ButtonGroup>
 * }
 * </pre>
 * 
 * @since 2.0.4.0
 * 
 * @author Carlos Alexandro Becker
 * 
 * @see <a
 *      href="http://twitter.github.com/bootstrap/components.html#buttonGroups">Bootstrap
 *      documentation</a>
 * @see Button
 * @see ButtonToolbar
 */
// @formatter:on
public class ButtonGroup extends DivWidget {

	/**
	 * Creates an empty ButtonGroup.
	 */
	public ButtonGroup() {
		setStyleName(Constants.BTN_GROUP);
	}

	/**
	 * Creates a ButtonGroup containing the provided Buttons.
	 * 
	 * @param buttons
	 *            the widgets to be added to the ButtonGroup
	 */
	public ButtonGroup(Button... buttons) {
		this();
		for (Button btn : buttons) {
			add(btn);
		}
	}

	/**
	 * Adds a new {@link Button} to the group.
	 * 
	 * @param widget
	 *            the Button to be added.
	 */
	@Override
	public void add(Widget widget) {
		if (!(widget instanceof Button))
			throw new IllegalArgumentException(
					"A ButtonGroup can only contain Buttons.");

		super.add(widget);
		// super.add(widget);
	}

	/**
	 * Set/unset the data-toggle behavior.
	 * 
	 * @param type
	 */
	public void setToggle(ToggleType type) {
		if (type == null || type == ToggleType.NONE) {
			getElement().removeAttribute(Constants.DATA_TOGGLE);
			return;
		}
		getElement().setAttribute(Constants.DATA_TOGGLE, type.get());

	}

	/**
	 * Set/unset the data-toggle behavior.
	 * 
	 * @param toggle
	 */
	public void setToggle(String toggle) {
		try {
			setToggle(ToggleType.valueOf(toggle.toUpperCase()));
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid toggle option.");
		}
	}
}
