package com.geekvigarista.gwt.bootstrap.client.old.form;

import com.geekvigarista.gwt.bootstrap.client.ui.base.ComplexWidget;

public class FormFieldsetLegend extends ComplexWidget {
	public FormFieldsetLegend(String text) {
		super("legend");
		getElement().setInnerText(text);
	}
}
