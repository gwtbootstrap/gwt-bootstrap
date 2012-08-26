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

import com.github.gwtbootstrap.client.ui.base.DropdownBase;
import com.github.gwtbootstrap.client.ui.base.HasType;
import com.github.gwtbootstrap.client.ui.base.IconAnchor;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.IconSize;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

//@formatter:off
/**
 * Split Dropdown button.
 * 
 * @author Dominik Mayer
 * @since 2.0.4.0
 * @see <a
 *      href="http://twitter.github.com/bootstrap/components.html#buttonDropdowns">Bootstrap
 *      documentation</a>
 * 
 */
//@formatter:on
public class SplitDropdownButton extends DropdownBase implements
		HasClickHandlers , HasType<ButtonType> {

	private Button button;

	private Button trigger;

	/**
	 * Create an Empty Split Dropdown Button
	 */
	public SplitDropdownButton() {
		super("div");
		addStyleName("btn-group");
	}

	/**
	 * Create an Empty Split Dropdown Button with text.
	 * @param text
	 */
	public SplitDropdownButton(String text) {
		this();
		setText(text);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setText(String text) {
		button.setText(text);
	}

	@Override
	protected IconAnchor createTrigger() {
		button = new Button();
		addWidget(button);
		trigger = new Button();
		trigger.setCaret(true);
		return trigger;
	}

	/**
	 * Set Button size
	 * @param size button size
	 */
	public void setSize(ButtonSize size) {
		trigger.setSize(size);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setType(ButtonType type) {
		trigger.setType(type);
	}

    /**
     * {@inheritDoc}
     */
    @Override
	public void setIcon(IconType type) {
		button.setIcon(type);
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return button.addClickHandler(handler);
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconSize(IconSize size) {
        button.setIconSize(size);
    }
}
