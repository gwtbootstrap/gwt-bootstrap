package com.geekvigarista.gwt.bootstrap.client.ui.form;

import com.geekvigarista.gwt.bootstrap.client.ui.base.ComplexWidget;

public class FormBuilder extends ComplexWidget {

	public FormBuilder() {
		super("form");
	}

	public FormBuilder appendFieldSet(FormFieldSet fs) {
		add(fs);
		return this;
	}
}
