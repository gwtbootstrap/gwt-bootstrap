package com.github.gwtbootstrap.client.ui.base;

import com.google.gwt.dom.client.Element;
import com.google.gwt.text.shared.testing.PassthroughParser;
import com.google.gwt.text.shared.testing.PassthroughRenderer;

/**
 * Abstract base class for most text entry widgets. and Support boostrap style.
 * 
 * @since 2.0.3.0
 * @author ohashi keisuke
 * @see com.google.gwt.user.client.ui.TextBoxBase
 */
public class TextBoxBase extends ValueBoxBase<String> {

	/**
	 * Creates a text box that wraps the given browser element handle. This is
	 * only used by subclasses.
	 * 
	 * @param elem
	 *            the browser element to wrap
	 */
	protected TextBoxBase(Element elem) {
		super(elem, PassthroughRenderer.instance(), PassthroughParser.instance());
	}

	/**
	 * Overridden to return "" from an empty text box.
	 */
	@Override
	public String getValue() {
		String raw = super.getValue();
		return raw == null
							? ""
							: raw;
	}

}
