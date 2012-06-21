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

/**
 * A ListBox for Bootstrap form.
 * 
 * @since 2.0.4.0
 * 
 * @author ohashi keisuke
 * 
 */
public class ListBox extends com.google.gwt.user.client.ui.ListBox implements HasSize, HasAlternateSize, IsSearchQuery, HasId , IsResponsive , HasStyle{

	{
		setStyleName("");
	}

	/**
	 * Creates an empty list box in single selection mode.
	 */
	public ListBox() {
		super();
	}

	/**
	 * Creates an empty list box. The preferred way to enable multiple
	 * selections is to use this constructor rather than
	 * {@link #setMultipleSelect(boolean)}.
	 * 
	 * @param isMultipleSelect
	 *            specifies if multiple selection is enabled
	 */
	public ListBox(boolean isMultipleSelect) {
		super(isMultipleSelect);
	}

	/**
	 * This constructor may be used by subclasses to explicitly use an existing
	 * element. This element must be a &lt;select&gt; element.
	 * 
	 * @param element
	 *            the element to be used
	 */
	protected ListBox(Element element) {
		super(element);
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
	 * Get Selected Value.
	 * <p>
	 * If set multiple,return first selected value.
	 * @return Selected Value.(If there is nothing selected item,return null)
	 */
	public String getValue() {

		if(getSelectedIndex() == -1) {
			return null;
		}

		return getValue(getSelectedIndex());
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

	/**
	 * Selects item which has the given value. If value
	 * is not found, nothing is done.
	 * @param value to be selected (<code>null</code>-safe)
	 */
	public void setSelectedValue(String value) {
		if (value == null) {
			value = "";
		}
		for(int i = 0; i < getItemCount(); i++) {
			if (getValue(i).equals(value)) {
				setSelectedIndex(i);
				return;
			}
		}
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
