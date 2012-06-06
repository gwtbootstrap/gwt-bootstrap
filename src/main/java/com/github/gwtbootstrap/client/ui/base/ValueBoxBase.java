package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.constants.AlternateSize;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.text.shared.Parser;
import com.google.gwt.text.shared.Renderer;

/**
 * A ValueBoxBase extending for Bootstarp style.
 * 
 * <pre>
 * It is GWT's {@link com.google.gwt.user.client.ui.ValueBoxBase} extending for Bootstrap style.
 * 
 * @since 2.0.3.0
 * @author ohashi keisuke
 * @see com.google.gwt.user.client.ui.ValueBoxBase
 * @param <T> the value type
 */
public class ValueBoxBase<T> extends com.google.gwt.user.client.ui.ValueBoxBase<T> implements HasPlaceholder, HasAlternateSize, IsSearchQuery, HasSize, HasId {

	/** placeholderHelper */
	private PlaceholderHelper placeholderHelper = GWT.create(PlaceholderHelper.class);

	/**
	 * Creates a value box that wraps the given browser element handle. This is
	 * only used by subclasses.
	 * 
	 * @param elem
	 *            the browser element to wrap
	 */
	protected ValueBoxBase(Element elem,
		Renderer<T> renderer,
		Parser<T> parser) {
		super(elem, renderer, parser);
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
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		if (enabled) {
			removeStyleName(Constants.DISABLED);
		} else {
			addStyleName(Constants.DISABLED);
		}
	}
}
