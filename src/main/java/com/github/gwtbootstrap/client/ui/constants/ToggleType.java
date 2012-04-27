package com.github.gwtbootstrap.client.ui.constants;

import com.github.gwtbootstrap.client.ui.ButtonGroup;
import com.github.gwtbootstrap.client.ui.base.Style;

/**
 * Type of a {@link ButtonGroup} toggle behavior.
 * 
 * @author Carlos A Becker
 * @since 2.0.2.0
 * 
 */
public enum ToggleType implements Style {
	NONE(""), RADIO("radio"), CHECKBOX("checkbox");

	private String className;

	private ToggleType(String className) {
		this.className = className;
	}

	public String get() {
		if (className == null || className.trim().isEmpty())
			return "";
		else
			return "buttons-" + className;
	}

}
