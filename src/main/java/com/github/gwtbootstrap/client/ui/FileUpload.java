package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HasAlternateSize;
import com.github.gwtbootstrap.client.ui.base.HasSize;
import com.github.gwtbootstrap.client.ui.base.IsSearchQuery;
import com.github.gwtbootstrap.client.ui.base.SearchQueryStyleHelper;
import com.github.gwtbootstrap.client.ui.base.SizeHelper;
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.constants.AlternateSize;


/**
 * A FileInput for Bootstrap form.
 * @since 2.0.3.0
 * @author ohashi keisuke
 *
 */
public class FileUpload extends com.google.gwt.user.client.ui.FileUpload implements HasSize, HasAlternateSize, IsSearchQuery {
	{
		setStyleName("");
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

}
