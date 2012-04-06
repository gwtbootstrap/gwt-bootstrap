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
