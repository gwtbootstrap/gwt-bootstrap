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

import com.github.gwtbootstrap.client.ui.base.HtmlWidget;
import com.github.gwtbootstrap.client.ui.constants.Constants;

/**
 * Controls is a form widget.
 * <p>
 * Controls can include html and widget
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:Controls>
 * 	Controls can include html and widgets<br/>
 * 	<b:ControlLabel>Email</b:ControlLabel>
 * 	<a href="#"></a>
 * </b:Controls>
 * }
 * </pre>
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author kokubo yusuke 
 * @author ohashi keisuke
 * 
 * @see ControlGroup
 * @see ControlLabel
 * @see <a href="http://twitter.github.com/bootstrap/base-css.html#forms">Bootstrap documentation</a>
 */
public class Controls extends HtmlWidget {

	/**
	 * Creates a widget with  the html set..
	 * @param html content html
	 */
	public Controls(String html) {
		super("div", html);
		setStyleName(Constants.CONTROLS);
	}

	/**
	 * Creates an empty widget.
	 */
	public Controls() {
		this("");
	}
	
	/**
	 * Set this as a controls-row
	 * @param controlsRow
	 */
	public void setControlsRow(boolean controlsRow) {
	    setStyleName(Constants.CONTROLS_ROW, controlsRow);
	}
}
