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

import com.github.gwtbootstrap.client.ui.constants.IconColor;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @since 2.0.2.0
 * 
 * @author Carlos Alexandro Becker
 * 
 * @author Dominik Mayer
 */
public class Icon extends Widget {

	public Icon() {
		setElement(DOM.createElement("i"));
	}

	public Icon(IconType type, IconColor color) {
		this(type);
		setColor(color);
	}

	public @UiConstructor
	Icon(IconType type) {
		this();
		setType(type);
	}

	public void setType(IconType type) {
		for (IconType t : IconType.values())
			removeStyleName(t.get());

		addStyleName(type.get());
	}

	public void setColor(IconColor color) {
		for (IconColor c : IconColor.values())
			if (!c.get().isEmpty())
				removeStyleName(c.get());

		if (!color.get().isEmpty())
			addStyleName(color.get());
	}
}
