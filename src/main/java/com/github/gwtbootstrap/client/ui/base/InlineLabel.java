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
package com.github.gwtbootstrap.client.ui.base;

/**
 * {@link com.google.gwt.user.client.ui.InlineLabel InlineLabel} without the GWT
 * CSS Styles.
 * 
 * @since 2.0.2.0
 * 
 * @author Dominik Mayer
 * 
 */
public class InlineLabel extends com.google.gwt.user.client.ui.InlineLabel {

	/**
	 * Creates an empty widget.
	 */
	public InlineLabel() {
		super();
		setStyleName("");
	}

	/**
	 * Creates a widget with the specified text.
	 * 
	 * @param text
	 *            the new widget's text
	 */
	public InlineLabel(String text) {
		this();
		setText(text);
	}

}
