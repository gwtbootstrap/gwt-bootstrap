package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HasAlternateSize;
import com.github.gwtbootstrap.client.ui.base.HasId;
import com.github.gwtbootstrap.client.ui.base.HasSize;
import com.github.gwtbootstrap.client.ui.base.IsSearchQuery;
import com.github.gwtbootstrap.client.ui.base.SearchQueryStyleHelper;
import com.github.gwtbootstrap.client.ui.base.SizeHelper;
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.constants.AlternateSize;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.dom.client.Element;

/**
 * A ListBox for Bootstrap form.
 * 
 * @since 2.0.3.0
 * 
 * @author ohashi keisuke
 * 
 */
public class ListBox extends com.google.gwt.user.client.ui.ListBox implements HasSize, HasAlternateSize, IsSearchQuery,HasId {

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
			}
		}
	}
}
