package com.github.gwtbootstrap.client.old.form;

import com.github.gwtbootstrap.client.ui.base.ComplexWidget;

public class FormFieldsetLegend extends ComplexWidget {
	public FormFieldsetLegend(String text) {
		super("legend");
		getElement().setInnerText(text);
	}
}
