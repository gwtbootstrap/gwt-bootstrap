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

import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.i18n.shared.DirectionEstimator;
import com.google.gwt.i18n.shared.HasDirectionEstimator;
import com.google.gwt.user.client.ui.DirectionalTextHelper;

/**
 * ControlLabel is a form widget.That can show form input label.
 * <p>
 * ControlLabel can include html and widget
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:ControlLabel>
 * 	ControlLabel can include html and widgets<br/>
 * 	<b:Code>Code</b:Code>
 * 	<a href="#"></a>
 * </b:ControlLabel>
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
public class ControlLabel extends FormLabel implements HasDirectionEstimator {

	final DirectionalTextHelper directionalTextHelper;

	/**
	 * Creates a widget with  the html set..
	 * @param html content html
	 */
	public ControlLabel(String html) {
		super(html);
		setStyleName(Constants.CONTROL_LABEL);
		directionalTextHelper = new DirectionalTextHelper(getElement(), true);
	}

	/**
	 * Creates an empty widget.
	 */
	public ControlLabel() {
		this("");
	}

	/**
	 * {@inheritDoc}
	 */
	public DirectionEstimator getDirectionEstimator() {
		return directionalTextHelper.getDirectionEstimator();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setDirectionEstimator(boolean enabled) {
		directionalTextHelper.setDirectionEstimator(enabled);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setDirectionEstimator(DirectionEstimator directionEstimator) {
		directionalTextHelper.setDirectionEstimator(directionEstimator);
	}
}
