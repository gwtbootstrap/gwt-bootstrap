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
package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.Icon;
import com.github.gwtbootstrap.client.ui.InputAddOn;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.IconSize;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.user.client.ui.HasText;


/**
 * Input add-on.
 * <p>
 * AddOn can set text or icon.
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <!-- text addon -->
 * <b:AddOn text="@"/>
 * 
 * <!-- text addon another usage -->
 * <b:AddOn>@</b:AddOn>
 * 
 * <!-- icon addon -->
 * <b:AddOn icon="STAR"/>
 * }
 * </pre>
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author ohashi keisuke
 * @see InputAddOn
 * @see IconType
 * @see <a href="http://twitter.github.com/bootstrap/base-css.html#forms">Bootstrap Docs</a>
 */
public class AddOn extends ComplexWidget implements HasText, HasIcon {

	/** text */
	private String text;
	
	/** icon */
	private Icon icon = new Icon();

	/**
	 * Creates an empty widget.
	 */
	public AddOn() {
		super("span");
		setStyleName(Constants.ADD_ON);
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
		this.text = text;

		if(icon.isAttached()) {
			icon.removeFromParent();
		}
		getElement().setInnerText(text);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setIcon(IconType iconType) {
		
		if(text != null) {
			getElement().setInnerHTML("");
		}

		icon.setType(iconType);
		
		if(!icon.isAttached()) {
			add(icon);
		}
	}

    @Override
    public void setIconSize(IconSize size) {
        icon.setIconSize(size);
    }

}
