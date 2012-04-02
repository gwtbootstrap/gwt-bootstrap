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

import com.github.gwtbootstrap.client.ui.base.ComplexWidget;
import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off
/**
 * ButtonGroups take buttons and combine them to one optically integrated widget.
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
 * @since 2.0.2.0
 * 
 * @author Carlos Alexandro Becker
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#buttonGroups">Bootstrap documentation</a>
 * @see Button
 * @see ButtonToolbar
 */
//@formatter:on
public class ButtonGroup extends DivWidget {

	private ComplexWidget span = new ComplexWidget("span");

	/**
	 * Creates an empty ButtonGroup.
	 */
	public ButtonGroup() {
		setStyleName(Constants.BTN_GROUP);
//		super.add(span);
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

//		span.add(widget);
		super.add(widget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return
	 */
	@Override
	public boolean remove(Widget widget) {
		return span.remove(widget);
	}
}
