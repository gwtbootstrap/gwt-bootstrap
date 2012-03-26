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

import com.github.gwtbootstrap.client.ui.base.Style;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.ui.InlineLabel;

/**
 * A Inline Label Component. You could have multiple types :)
 * 
 * @author Carlos Alexandro Becker
 * @author Dominik Mayer
 * @since 23/01/2012
 */
public class Label extends InlineLabel {

	public Label() {
		setStyle(Bootstrap.Label.DEFAULT);
	}

	public Label(String text) {
		this();
		setText(text);
	}

	public Label(String text, Bootstrap.Label type) {
		setText(text);
		setType(type);
	}

	public void setType(Bootstrap.Label type) {
		assert type != null : "type should not be null";
		
		setStyle(type);
	}
	
	private void setStyle(Style style) {
		setStyleName(style.get());
	}

	public void setType(String typename) {
		if (typename.equalsIgnoreCase("success"))
			setStyle(Bootstrap.Label.SUCCESS);
		else if (typename.equalsIgnoreCase("warning"))
			setStyle(Bootstrap.Label.WARNING);
		else if (typename.equalsIgnoreCase("important"))
			setStyle(Bootstrap.Label.IMPORTANT);
		else if (typename.equalsIgnoreCase("info"))
			setStyle(Bootstrap.Label.INFO);
		else if (typename.equalsIgnoreCase("inverse"))
			setStyle(Bootstrap.Label.INVERSE);
		else
			setStyle(Bootstrap.Label.DEFAULT);
	}

}
