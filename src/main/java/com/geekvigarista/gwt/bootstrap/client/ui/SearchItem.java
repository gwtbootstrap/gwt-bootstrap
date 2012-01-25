package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

/**
 * SearchItem to be added into the {@linkplain Topbar}'s container.
 * 
 * @author Carlos Alexandro Becker
 * @since 25/01/2012
 */
public class SearchItem extends Widget implements HasValue<String> {

	private Element input;

	{
		setElement(DOM.createForm());
		setStyleName(BootstrapCssResources.pull_left);
		input = DOM.createInputText();
		getElement().appendChild(input);
	}

	public SearchItem(String placeholder) {
		input.setAttribute("placeholder", placeholder);
	}

	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<String> handler) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getValue() {
		return input.getAttribute("value");
	}

	public void setValue(String value) {
		input.setAttribute("value", value);
	}

	public void setValue(String value, boolean fireEvents) {
		setValue(value);
	}

}
