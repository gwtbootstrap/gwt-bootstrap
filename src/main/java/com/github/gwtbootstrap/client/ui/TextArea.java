package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HasAlternateSize;
import com.github.gwtbootstrap.client.ui.base.HasId;
import com.github.gwtbootstrap.client.ui.base.HasPlaceholder;
import com.github.gwtbootstrap.client.ui.base.HasSize;
import com.github.gwtbootstrap.client.ui.base.PlaceholderHelper;
import com.github.gwtbootstrap.client.ui.base.SizeHelper;
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.constants.AlternateSize;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

/**
 * A TextArea for Bootstrap form.
 * 
 * @since 2.0.3.0
 * @author ohashi keisuke
 */
public class TextArea extends com.google.gwt.user.client.ui.TextArea implements HasSize , HasAlternateSize, HasPlaceholder, HasId {

	/** placeholderHelper */
	private PlaceholderHelper placeholderHelper = GWT.create(PlaceholderHelper.class);

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPlaceholder(String placeholder) {
		placeholderHelper.setPlaceholer(getElement(), placeholder);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPlaceholder() {
		return placeholderHelper.getPlaceholder(getElement());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return getElement().getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(String id) {
		getElement().setId(id);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		if(enabled) {
			removeStyleName(Constants.DISABLED);
		} else {
			addStyleName(Constants.DISABLED);
		}
	}


}
