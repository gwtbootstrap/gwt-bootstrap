package com.geekvigarista.gwt.bootstrap.client.ui.form;

import com.geekvigarista.gwt.bootstrap.client.v2.base.ComplexWidget;

public class FormFieldsetLegend extends ComplexWidget {
	public FormFieldsetLegend(String text) {
		super("legend");
		getElement().setInnerText(text);
	}
}
