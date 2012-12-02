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
import com.github.gwtbootstrap.client.ui.base.IconAnchor;
import com.github.gwtbootstrap.client.ui.constants.*;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;

//@formatter:off
/**
 * Button with a dropdown menu.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:DropdownButton text="I am the Caption">
 *     <b:NavHeader>Header</b:NavHeader>
 *     <b:NavLink>Link 1</b:NavLink>
 *     <b:NavLink>Link 2</b:NavLink>
 * </b:DropdownButton>
 * }
 * </pre>
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#buttonDropdowns">Bootstrap documentation</a>
 * @see Dropdown
 * @see SplitDropdownButton
 */
//@formatter:on
public class DropdownButton extends DropdownBase {

	private Button trigger;

	/**
	 * Creates a DropdownButton without a caption.
	 */
	public DropdownButton() {
		super("div");
		addStyleName("btn-group");
	}

	/**
	 * Creates a DropdownButton with the given caption.
	 * 
	 * @param caption
	 *            the button's caption
	 */
	public DropdownButton(String caption) {
		this();
		setText(caption);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IconAnchor createTrigger() {
		trigger = new Button();
		trigger.setCaret(true);
		return trigger;
	}

	/**
	 * Sets the button's size.
	 * 
	 * @param size
	 *            the button's size
	 */
	public void setSize(ButtonSize size) {
		trigger.setSize(size);
	}

	/**
	 * Sets the button's type.
	 * 
	 * @param type
	 *            the button's type
	 */
	public void setType(ButtonType type) {
		trigger.setType(type);
	}

	/**
	 * Sets the button's icon.
	 * 
	 * @param type
	 *            the icon's type
	 */
    @Override
    public void setIcon(IconType type) {
        setBaseIcon(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBaseIcon(BaseIconType type) {
        trigger.setBaseIcon(type);
    }

    @Override
    public HandlerRegistration addClickHandler(ClickHandler handler) {
        return trigger.addClickHandler(handler);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconSize(IconSize size) {
        trigger.setIconSize(size);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setCustomIconStyle(String customIconStyle) {
        trigger.setCustomIconStyle(customIconStyle);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconPosition(IconPosition position) {
        trigger.setIconPosition(position);
    }
}
