package com.geekvigarista.gwt.bootstrap.client.ui.form;

import com.geekvigarista.gwt.bootstrap.client.ui.base.ComplexWidget;

public class FormFieldLabel extends ComplexWidget {
	public FormFieldLabel(String forId, String text) {
		super("label");
		getElement().setInnerText(text);
		getElement().setAttribute("for", forId);
	}
}
