package com.geekvigarista.gwt.bootstrap.client.ui.topbar;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HasValue;

/**
 * SearchItem to be added into the {@linkplain Topbar}'s container.
 * 
 * @author Carlos Alexandro Becker
 * @since 25/01/2012
 */
public class SearchItem extends FocusWidget implements HasValue<String> {

	private Element input;
	private boolean valueChangeHandlerInitialized;

	static {
		exportDisbleOnEnter();
	}

	{
		setElement(DOM.createForm());
		setStyleName(BootstrapCssResources.pull_left);
		input = DOM.createInputText();
		// disable form submit on enter press.
		input.setAttribute("onKeyPress", "return disableEnterKey(event);");
		getElement().appendChild(input);
	}

	public SearchItem(String placeholder) {
		input.setAttribute("placeholder", placeholder);
	}

	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<String> handler) {
		if (!valueChangeHandlerInitialized) {
			valueChangeHandlerInitialized = true;
			addChangeHandler(new ChangeHandler() {
				public void onChange(ChangeEvent event) {
					ValueChangeEvent.fire(SearchItem.this, getValue());
				}
			});
		}
		return addHandler(handler, ValueChangeEvent.getType());
	}

	public HandlerRegistration addChangeHandler(ChangeHandler handler) {
		return addDomHandler(handler, ChangeEvent.getType());
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

	private static native void exportDisbleOnEnter() /*-{
		$wnd.disableEnterKey = function(e) {
			var key;
			if (window.event) {
				key = window.event.keyCode;
			} else {
				key = e.which;
			}
			if (key == 13) {
				return false;
			} else {
				return true;
			}
		}
	}-*/;

}
