package com.github.gwtbootstrap.showcase.client.forms;

import com.google.gwt.text.shared.AbstractRenderer;


public class DisplayLabelRenderer<T extends HasDisplayLabel> extends AbstractRenderer<T> {

	@Override
	public String render(T object) {
		
		return object != null? object.getDisplayLabel() : "";
	}

}
