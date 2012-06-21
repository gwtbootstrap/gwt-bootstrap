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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasConstrainedValue;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SimpleKeyProvider;

/**
 * The TW Bootstrap style ValueListBox
 * 
 * @param <T> the value type
 * @author ohashi keisuke
 * @since 2.0.4.0
 */
public class ValueListBox<T> extends Composite implements HasConstrainedValue<T>, IsEditor<TakesValueEditor<T>>, HasName, HasId, HasEnabled, HasSize, HasAlternateSize, IsSearchQuery, IsResponsive, HasStyle {

	private final Map<Object, Integer> valueKeyToIndex = new HashMap<Object, Integer>();

	private final List<T> valueList = new ArrayList<T>();

	private final Renderer<T> renderer;

	private final ProvidesKey<T> keyProvider;

	private TakesValueEditor<T> editor;

	private T value;

	public ValueListBox(Renderer<T> renderer) {
		this(renderer, new SimpleKeyProvider<T>());
	}

	public ValueListBox(Renderer<T> renderer,
		ProvidesKey<T> keyProvider) {
		this.keyProvider = keyProvider;
		this.renderer = renderer;
		initWidget(new ListBox());

		getListBox().addChangeHandler(new ChangeHandler() {

			public void onChange(ChangeEvent event) {
				int selectedIndex = getListBox().getSelectedIndex();

				if (selectedIndex < 0) {
					return;
				}
				T newValue = valueList.get(selectedIndex);
				setValue(newValue, true);
			}
		});
	}

	public void setName(String name) {
		getListBox().setName(name);
	}

	public String getName() {
		return getListBox().getName();
	}

	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<T> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}

	/**
	 * Returns a {@link TakesValueEditor} backed by the ValueListBox.
	 */
	public TakesValueEditor<T> asEditor() {
		if (editor == null) {
			editor = TakesValueEditor.of(this);
		}
		return editor;
	}

	public T getValue() {
		return value;
	}

	public void setAcceptableValues(Collection<T> newValues) {

		valueList.clear();
		
		valueKeyToIndex.clear();
		
		ListBox listBox = getListBox();
		
		listBox.clear();

		for (T nextNewValue : newValues) {
			addValue(nextNewValue);
		}

		updateListBox();
	}

	/**
	 * Set the value and display it in the select element. Add the value to the
	 * acceptable set if it is not already there.
	 */
	public void setValue(T value) {
		setValue(value, false);
	}

	public void setValue(T value, boolean fireEvents) {
		if (value == this.value || (this.value != null && this.value.equals(value))) {
			return;
		}

		T before = this.value;
		this.value = value;
		updateListBox();

		if (fireEvents) {
			ValueChangeEvent.fireIfNotEqual(this, before, value);
		}
	}

	private void addValue(T value) {
		Object key = keyProvider.getKey(value);
		if (valueKeyToIndex.containsKey(key)) {
			throw new IllegalArgumentException("Duplicate value: " + value);
		}

		valueKeyToIndex.put(key, valueList.size());
		valueList.add(value);
		getListBox().addItem(renderer.render(value));
		assert valueList.size() == getListBox().getItemCount();
	}

	private ListBox getListBox() {
		return (ListBox) getWidget();
	}

	private void updateListBox() {
		Object key = keyProvider.getKey(value);
		Integer index = valueKeyToIndex.get(key);
		if (index == null) {
			addValue(value);
		}

		index = valueKeyToIndex.get(key);
		getListBox().setSelectedIndex(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return getListBox().getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(String id) {
		getListBox().setId(id);
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
	public void setEnabled(boolean enabled) {
		getListBox().setEnabled(enabled);
		if(enabled) {
			removeStyleName(Constants.DISABLED);
		} else {
			addStyleName(Constants.DISABLED);
		}
	}

	@Override
	public boolean isEnabled() {
		return getListBox().isEnabled();
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
