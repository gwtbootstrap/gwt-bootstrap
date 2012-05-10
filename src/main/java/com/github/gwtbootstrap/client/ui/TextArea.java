package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HasAlternateSize;
import com.github.gwtbootstrap.client.ui.base.HasSize;
import com.github.gwtbootstrap.client.ui.base.SizeHelper;
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.constants.AlternateSize;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TextAreaElement;

public class TextArea extends com.google.gwt.user.client.ui.TextArea implements HasSize , HasAlternateSize {

	/**
	 * Creates an empty text area.
	 */
	public TextArea() {
		super(Document.get().createTextAreaElement());
	}

	/**
	 * This constructor may be used by subclasses to explicitly use an existing
	 * element. This element must be a &lt;textarea&gt; element.
	 * 
	 * @param element
	 *            the element to be used
	 */
	protected TextArea(Element element) {
		super(element.<Element> cast());
		TextAreaElement.as(element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAlternateSize(AlternateSize size) {
		StyleHelper.changeStyle(this, size, AlternateSize.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSize(int size) {
		SizeHelper.setSize(this, size);
	}
	
	
}
