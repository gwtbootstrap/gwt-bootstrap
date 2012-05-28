package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.CssResource.ImportedWithPrefix;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ProvidesKey;

public class CellTable<T> extends com.google.gwt.user.cellview.client.CellTable<T> {

	public static enum TableType implements com.github.gwtbootstrap.client.ui.base.Style {
		BORDERED("table-bordered"),
		STRIPED("table-striped"),
		CONDENSED("table-condensed");
		
		private final String styleName;

		private TableType(String styleName) {
			this.styleName = styleName;
		}

		@Override
		public String get() {
			return styleName;
		}
	}
	
	/**
	 * The default page size.
	 */
	private static final int DEFAULT_PAGESIZE = 15;

	private static Resources DEFAULT_RESOURCES = null;

	private static Resources getDefaultResources() {
		if (DEFAULT_RESOURCES == null) {
			DEFAULT_RESOURCES = GWT.create(Resources.class);
		}
		return DEFAULT_RESOURCES;
	}

	public interface Resources extends com.google.gwt.user.cellview.client.CellTable.Resources {

		@Override
		@Source(Style.DEFAULT_CSS)
		public Style cellTableStyle();
	}

	@ImportedWithPrefix("gwt-bootstrap-cellTable")
	public interface Style extends com.google.gwt.user.cellview.client.CellTable.Style {

		String DEFAULT_CSS = "com/github/gwtbootstrap/client/ui/GwtBootstrapCellTable.css";
	}

	public CellTable() {
		this(DEFAULT_PAGESIZE);
	}

	public CellTable(int pageSize, ProvidesKey<T> keyProvider) {
		this(pageSize, keyProvider , createDefaultLoadingIndicator(getDefaultResources()));
	}

	public CellTable(int pageSize, ProvidesKey<T> keyProvider, Widget loadingIndicator) {
		super(pageSize, getDefaultResources(), keyProvider, loadingIndicator);
		setStyleName("table");
	}

	public CellTable(int pageSize) {
		this(pageSize, null);
	}

	public CellTable(ProvidesKey<T> keyProvider) {
		this(DEFAULT_PAGESIZE, keyProvider);
	}
	
	public void setStriped(boolean striped) {
		if(striped) {
			StyleHelper.addStyle(this, TableType.STRIPED);
		} else {
			StyleHelper.removeStyle(this, TableType.STRIPED);
		}
	}
	
	public void setBordered(boolean bordered) {
		if(bordered) {
			StyleHelper.addStyle(this, TableType.BORDERED);
		} else {
			StyleHelper.removeStyle(this, TableType.BORDERED);
		}
	}

	public void setCondensed(boolean condensed) {
		if(condensed) {
			StyleHelper.addStyle(this, TableType.CONDENSED);
		} else {
			StyleHelper.removeStyle(this, TableType.CONDENSED);
		}
	}
	/**
	 * Create the default loading indicator using the loading image in the
	 * specified {@link Resources}.
	 * 
	 * @param resources
	 *            the resources
	 * @return a widget loading indicator
	 */
	private static Widget createDefaultLoadingIndicator(Resources resources) {
		ImageResource loadingImg = resources.cellTableLoading();
		return (loadingImg == null)
									? null
									: new Image(loadingImg);
	}
}
