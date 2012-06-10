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
import com.github.gwtbootstrap.client.ui.base.HtmlWidget;
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.ControlGroupType;

/**
 * ControlGroup is a form widget.
 * <p>
 * ControlGroup can include html and widget
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:ControlGroup>
 * 	ControlGroup can include html and widgets<br/>
 * 	<b:Controls/>
 * 	<a href="#"></a>
 * </b:ControlGroup>
 * }
 * </pre>
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author kokubo yusuke 
 * @author ohashi keisuke
 * 
 * @see Controls
 * @see Fieldset
 * @see <a href="http://twitter.github.com/bootstrap/base-css.html#forms">Bootstrap documentation</a>
 */
public class ControlGroup extends HtmlWidget implements HasType<ControlGroupType> {

	/**
	 * Creates a widget with  the html set..
	 * @param html content html
	 */
	public ControlGroup(String html) {
		super("div", html);
		setStyleName(Constants.CONTROL_GROUP);
	}

	/**
	 * Creates an empty widget.
	 */
	public ControlGroup() {
		this("");
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setType(ControlGroupType type) {
		StyleHelper.changeStyle(this, type, ControlGroupType.class);
	}
}
