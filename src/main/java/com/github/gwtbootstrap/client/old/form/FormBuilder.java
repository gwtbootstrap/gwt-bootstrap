package com.github.gwtbootstrap.client.old.form;

import com.github.gwtbootstrap.client.ui.base.ComplexWidget;

public class FormBuilder extends ComplexWidget {

	public FormBuilder() {
		super("form");
	}

	public FormBuilder appendFieldSet(FormFieldSet fs) {
		add(fs);
		return this;
	}
}
