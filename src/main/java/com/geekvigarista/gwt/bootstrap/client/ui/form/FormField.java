package com.geekvigarista.gwt.bootstrap.client.ui.form;

import com.geekvigarista.gwt.bootstrap.client.ui.DivPanel;
import com.geekvigarista.gwt.bootstrap.client.v2.base.ComplexWidget;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

public class FormField<T, W extends Widget & HasValue<T>> extends ComplexWidget
		implements HasValue<T> {

	private String id;
	private W w;

	public FormField(String label, W w) {
		super("div");
		this.w = w;
		this.id = w.hashCode() + "";
		setStyleName(BootstrapCssResources.clearfix);
		w.getElement().setId(id);
		add(new FormFieldLabel(id, label));
		DivPanel c = new DivPanel();
		c.add(w);
		c.setStyleName(BootstrapCssResources.input);
		add(c);
	}

	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<T> handler) {
		return w.addValueChangeHandler(handler);
	}

	public T getValue() {
		return w.getValue();
	}

	public void setValue(T value) {
		w.setValue(value);
	}

	public void setValue(T value, boolean fireEvents) {
		w.setValue(value, fireEvents);
	}
}