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

import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author carlos
 */
public class Icon extends Widget {

	public enum Color {

		WHITE, BLACK;
	}

	private static final String PREFIX = "icon-";

	private String type = "";

	private String color = "";

	public Icon() {
		setElement(DOM.createElement("i"));
	}

	public Icon(IconType type, Color color) {
		this(type);
		setColor(color);
	}

	public Icon(IconType type) {
		this(type.get());
	}

	public @UiConstructor
	Icon(String type) {
		this();
		setType(type);
	}

	public void setType(IconType type) {
		setType(type.get());
	}

	public void setType(String type) {
		this.type = PREFIX + type;
		setStyles();
	}

	public void setColor(String color) {
		this.color = PREFIX + color;
		setStyles();
	}

	public void setColor(Color color) {
		if (color == Color.WHITE) {
			setColor("white");
		} else
			setColor("");
	}

	private void setStyles() {
		setStyleName("");
		if (!type.isEmpty())
			addStyleName(type);
		if (!color.isEmpty())
			addStyleName(color);
	}
}
