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

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Widget;

/**
 * This is part of TwBootstrap Grid System. enjoy it.
 * 
 * @since 2.0.2.0
 * 
 * @author Carlos Alexandro Becker
 * @author Dominik Mayer
 * 
 * @see Row
 */
public class Column extends DivWidget {

	@UiConstructor
	public Column(int size) {
		super();
		size = size < 1 ? 1 : size > 12 ? 12 : size;
		setStyleName("span" + size);
	}

	public Column(int size, int offset) {
		this(size);
		setOffset(offset);
	}

	public Column(int size, int offset, Widget... childs) {
		this(size, offset);
		add(childs);
	}

	public Column(int size, Widget... childs) {
		this(size);
		add(childs);
	}

	public void setOffset(int offset) {
		offset = offset > 0 ? offset : 1;
		addStyleName("offset" + offset);
	}

	public void add(Widget... childs) {
		for (Widget child : childs) {
			add(child);
		}
	}
}
