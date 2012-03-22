package com.github.gwtbootstrap.client.old.form;

import com.github.gwtbootstrap.client.ui.base.ComplexWidget;

public class FormFieldLabel extends ComplexWidget {
	public FormFieldLabel(String forId, String text) {
		super("label");
		getElement().setInnerText(text);
		getElement().setAttribute("for", forId);
	}
}
