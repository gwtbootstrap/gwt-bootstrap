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

import com.github.gwtbootstrap.client.ui.base.*;
import com.github.gwtbootstrap.client.ui.constants.AlternateSize;
import com.google.gwt.core.client.GWT;

/**
 * A TextBox for Bootstrap form.
 * 
 * @since 2.0.3.0
 * 
 * @author Carlos Alexandro Becker
 * @author ohashi keisuke
 * 
 */
public class TextBox extends com.github.gwtbootstrap.client.ui.base.TextBox implements HasPlaceholder, HasAlternateSize, IsSearchQuery {

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

	// TODO 2012/05/05 ohashi keisuke. Should create setter for
	// uneditable,disable,size
}
