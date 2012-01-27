package com.geekvigarista.gwt.bootstrap.client.ui.form;

import com.geekvigarista.gwt.bootstrap.client.ui.base.ComplexWidget;

public class FormFieldSet extends ComplexWidget {
	public FormFieldSet() {
		super("fieldset");
	}

	public FormFieldSet(String legend) {
		this();
		add(new FormFieldsetLegend(legend));
	}

	public FormFieldSet appendField(FormField<?, ?> f) {
		add(f);
		return this;
	}
}
