/*
 *  Copyright 2012 GWT-Bootstrap
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HasAlternateSize;
import com.github.gwtbootstrap.client.ui.base.HasId;
import com.github.gwtbootstrap.client.ui.base.HasSize;
import com.github.gwtbootstrap.client.ui.base.HasStyle;
import com.github.gwtbootstrap.client.ui.base.InlineLabel;
import com.github.gwtbootstrap.client.ui.base.IsResponsive;
import com.github.gwtbootstrap.client.ui.base.IsSearchQuery;
import com.github.gwtbootstrap.client.ui.base.ResponsiveHelper;
import com.github.gwtbootstrap.client.ui.base.SearchQueryStyleHelper;
import com.github.gwtbootstrap.client.ui.base.SizeHelper;
import com.github.gwtbootstrap.client.ui.base.Style;
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.constants.AlternateSize;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.Device;
import com.google.gwt.dom.client.Element;
import com.google.gwt.i18n.shared.DirectionEstimator;
import com.google.gwt.user.client.ui.Label;



/**
 * Uneditable style text input.
 * 
 * @since 2.0.4.0
 * @author ohashi keisuke
 */
public class UneditableInput extends InlineLabel implements HasAlternateSize, IsSearchQuery, HasSize, HasId, HasStyle, IsResponsive {

	/**
	 * Creates an empty widget.
	 */
	public UneditableInput() {
		super();
		setStyleName(Constants.UNEDITABLE_INPUT);
	}

	/**
	 * This constructor may be used by subclasses to explicitly use an existing
	 * element. This element must be either a &lt;div&gt; &lt;span&gt; element.
	 * 
	 * @param element
	 *            the element to be used
	 */
	protected UneditableInput(Element element) {
		super(element);
	}

	/**
	 * Creates a label with the specified text and direction.
	 * 
	 * @param text
	 *            the new label's text
	 * @param dir
	 *            the text's direction. Note: {@code Direction.DEFAULT} means
	 *            direction should be inherited from the widget's parent
	 *            element.
	 */
	public UneditableInput(String text, Direction dir) {
		super(text, dir);
	}

	/**
	 * Creates a label with the specified text and a default direction
	 * estimator.
	 * 
	 * @param text
	 *            the new label's text
	 * @param directionEstimator
	 *            A DirectionEstimator object used for automatic direction
	 *            adjustment. For convenience,
	 *            {@link Label#DEFAULT_DIRECTION_ESTIMATOR} can be used.
	 */
	public UneditableInput(String text, DirectionEstimator directionEstimator) {
		super(text, directionEstimator);
	}

	/**
	 * Creates a widget with the specified text.
	 * 
	 * @param text
	 *            the new widget's text
	 */
	public UneditableInput(String text) {
		super(text);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSearchQuery(boolean searchQuery) {
		SearchQueryStyleHelper.setSearchQuery(this, searchQuery);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSearchQuery() {
		return SearchQueryStyleHelper.isSearchQuery(this);
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
	public void setShowOn(Device device) {
		ResponsiveHelper.setShowOn(this, device);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setHideOn(Device device) {
		ResponsiveHelper.setHideOn(this, device);
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStyle(Style style) {
		StyleHelper.setStyle(this, style);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addStyle(Style style) {
		StyleHelper.addStyle(this, style);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeStyle(Style style) {
		StyleHelper.removeStyle(this, style);
		
	}
}
