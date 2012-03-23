package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.ComplexWidget;
import com.google.gwt.uibinder.client.UiConstructor;


public class Section extends ComplexWidget {

	public @UiConstructor Section(String target) {
		super("section");
		getElement().setId(target);
	}
}
