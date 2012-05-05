package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HasPlaceholder;
import com.github.gwtbootstrap.client.ui.base.PlaceholderHelper;
import com.google.gwt.core.client.GWT;

/**
 * A TextBox with a placeholder attribute.
 * 
 * @since 2.0.3.0
 * 
 * @author Carlos Alexandro Becker
 * @author ohashi keisuke
 * 
 */
public class TextBox extends com.github.gwtbootstrap.client.ui.base.TextBox implements HasPlaceholder {

	/** placeholderHelper */
	private PlaceholderHelper placeholderHelper = GWT.create(PlaceholderHelper.class);
	
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
	
	//TODO 2012/05/05 ohashi keisuke. Should create setter for uneditable,disable,size,alternate size
}
