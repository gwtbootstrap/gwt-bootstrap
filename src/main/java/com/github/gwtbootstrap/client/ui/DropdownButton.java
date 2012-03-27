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
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DropdownBase;
import com.github.gwtbootstrap.client.ui.base.IconAnchor;

/**
 * A Button with a dropdown menu.
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#buttonDropdowns">Bootstrap documentation</a>
 *
 */
public class DropdownButton extends DropdownBase {
	
	private Button trigger;

	public DropdownButton() {
		super("div");
		addStyleName("btn-group");
	}

	public DropdownButton(String text) {
		this();
		setText(text);
	}

	@Override
	protected IconAnchor createTrigger() {
		trigger = new Button();
		trigger.setCaret(true);
		return trigger;
	}
	
	public void setSize(String size) {
		trigger.setSize(size);
	}
	
	public void setType(String type) {
		trigger.setType(type);
	}
	
	public void setIcon(String icon) {
		trigger.setIcon(icon);
	}
	
}
