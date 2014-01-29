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
import com.github.gwtbootstrap.client.ui.constants.BaseIconType;
import com.github.gwtbootstrap.client.ui.constants.IconPosition;
import com.github.gwtbootstrap.client.ui.constants.IconSize;
import com.github.gwtbootstrap.client.ui.constants.IconType;

//@formatter:off
/**
 * Dropdown menus that are usually used in a navigation context.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:Dropdown text="I am the Caption">
 *     <b:NavHeader>Header</b:NavHeader>
 *     <b:NavLink>Link 1</b:NavLink>
 *     <b:NavLink>Link 2</b:NavLink>
 * </b:Dropdown>
 * }
 * </pre>
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Carlos Alexandro Becker
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/javascript.html#dropdowns">Bootstrap documentation</a>
 * @see DropdownButton
 * @see SplitDropdownButton
 */
//@formatter:on
public class Dropdown extends DropdownBase {

	/**
	 * Creates an empty Dropdown without a caption.
	 */
	public Dropdown() {
		super("li");
		addStyleName("dropdown");
	}

	/**
	 * Creates an empty Dropdown with the given caption.
	 * 
	 * @param caption
	 *            the dropdown's caption
	 */
	public Dropdown(final String caption) {
		this();
		setText(caption);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IconAnchor createTrigger() {
		final IconAnchor trigger = new IconAnchor();
		trigger.setCaret(true);
		return trigger;
	}

    /**
     * {@inheritDoc}
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
