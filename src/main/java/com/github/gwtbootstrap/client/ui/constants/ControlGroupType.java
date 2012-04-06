package com.github.gwtbootstrap.client.ui.constants;

import com.github.gwtbootstrap.client.ui.base.Style;

public enum ControlGroupType implements Style {

	WARNING("warning"),
	ERROR("error"),
	SUCCESS("success"), ;

	private String className;

	private ControlGroupType(String className) {
		this.className = className;
	}

	public String get() {
		return className;
	}

}
