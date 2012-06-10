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

import com.github.gwtbootstrap.client.ui.base.HasType;
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.LabelType;
import com.google.gwt.user.client.ui.InlineLabel;

//@formatter:off
/**
 * Colored label to show warnings, tags, ... You could have multiple types :)
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:Label type="INFO">I'm the text!</b:Label>
 * }
 * </pre>
 * All arguments are optional.
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Carlos Alexandro Becker
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#labels">Bootstrap documentation</a>
 * @see Badge
 */
//@formatter:on
public class Label extends InlineLabel implements HasType<LabelType> {

	/**
	 * Creates an empty Label.
	 */
	public Label() {
		setStyleName(Constants.LABEL);
	}

	/**
	 * Creates a Label with the given text.
	 * 
	 * @param text
	 *            the text for the Label
	 */
	public Label(String text) {
		this();
		setText(text);
	}

	/**
	 * Creates a Label of given Type with the given text.
	 * 
	 * @param type
	 *            the type of the Label
	 * @param text
	 *            the text of the Label
	 */
	public Label(LabelType type, String text) {
		this(text);
		setType(type);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setType(LabelType type) {
		StyleHelper.changeStyle(this, type, LabelType.class);
	}

}
