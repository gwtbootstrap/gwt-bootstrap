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

public class ControlLabel extends FormLabel implements HasDirectionEstimator {

	final DirectionalTextHelper directionalTextHelper;

	public ControlLabel(String html) {
		super(html);
		setStyleName(Constants.CONTROL_LABEL);
		directionalTextHelper = new DirectionalTextHelper(getElement(), true);
	}

	public ControlLabel() {
		this("");
	}

	public void setFor(String id) {
		getElement().setAttribute("for", id);
	}

	public DirectionEstimator getDirectionEstimator() {
		return directionalTextHelper.getDirectionEstimator();
	}

	public void setDirectionEstimator(boolean enabled) {
		directionalTextHelper.setDirectionEstimator(enabled);
	}

	public void setDirectionEstimator(DirectionEstimator directionEstimator) {
		directionalTextHelper.setDirectionEstimator(directionEstimator);
	}
}
