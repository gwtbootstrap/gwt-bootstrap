package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HasType;
import com.github.gwtbootstrap.client.ui.base.HtmlWidget;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.ControlGroupType;

public class ControlGroup extends HtmlWidget implements HasType<ControlGroupType> {

	public ControlGroup(String html) {
		super("div", html);
		setStyleName(Constants.CONTROL_GROUP);
	}

	public ControlGroup() {
		this("");
	}
	
	public void setType(ControlGroupType type) {
		for (ControlGroupType t : ControlGroupType.values())
			removeStyle(t);
		addStyle(type);
	}
}
