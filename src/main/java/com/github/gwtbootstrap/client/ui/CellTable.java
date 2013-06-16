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

import com.github.gwtbootstrap.client.ui.base.HasStyle;
import com.github.gwtbootstrap.client.ui.base.IsResponsive;
import com.github.gwtbootstrap.client.ui.base.ResponsiveHelper;
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.constants.Device;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.CssResource.ImportedWithPrefix;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ProvidesKey;

/**
 * 
 * CellTable for Bootstrap style.
 * 
 * @since 2.0.4.0
 * @author ohashi keisuke
 * 
 * @param <T>
 *            Data Set
 */
public class CellTable<T> extends
        com.google.gwt.user.cellview.client.CellTable<T> implements HasStyle,
        IsResponsive {

    public static enum TableType implements
            com.github.gwtbootstrap.client.ui.base.Style {
        BORDERED("table-bordered"), STRIPED("table-striped"), CONDENSED("table-condensed"),
        HOVER("table-hover");

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

    public interface Resources extends
            com.google.gwt.user.cellview.client.CellTable.Resources {

        @Override
        @Source(Style.DEFAULT_CSS)
        public Style cellTableStyle();
    }

    public interface SelectableResources extends Resources {

        @Override
        @Source(SelectableStyle.DEFAULT_CSS)
        public Style cellTableStyle();
    }

    @ImportedWithPrefix("gwt-bootstrap-cellTable")
    public interface Style extends
            com.google.gwt.user.cellview.client.CellTable.Style {

        String DEFAULT_CSS = "com/github/gwtbootstrap/client/ui/GwtBootstrapCellTable.css";
    }

    @ImportedWithPrefix("gwt-bootstrap-cellTable")
    public interface SelectableStyle extends
            com.google.gwt.user.cellview.client.CellTable.Style {

        String DEFAULT_CSS = "com/github/gwtbootstrap/client/ui/GwtBootstrapCellTableSelectable.css";
    }

    public CellTable() {
        this(DEFAULT_PAGESIZE);
    }

    public CellTable(int pageSize, Resources resources,
            ProvidesKey<T> keyProvider, Widget loadingIndicator) {
        super(pageSize, resources, keyProvider, loadingIndicator);
        setStyleName("table");
    }

    public CellTable(int pageSize,
            Resources resources,
            ProvidesKey<T> keyProvider) {
        this(pageSize, resources, keyProvider, createDefaultLoadingIndicator(getDefaultResources()));
    }

    public CellTable(int pageSize, Resources resources) {
        this(pageSize, resources , null);
    }

    public CellTable(int pageSize, ProvidesKey<T> keyProvider) {
        this(pageSize, keyProvider, createDefaultLoadingIndicator(getDefaultResources()));
    }

    public CellTable(int pageSize, ProvidesKey<T> keyProvider, Widget loadingIndicator) {
        this(pageSize, getDefaultResources(), keyProvider, loadingIndicator);
    }

    public CellTable(int pageSize) {
        this(pageSize, getDefaultResources());
    }

    public CellTable(ProvidesKey<T> keyProvider) {
        this(DEFAULT_PAGESIZE, keyProvider);
    }

    public void setStriped(boolean striped) {
        if (striped) {
            StyleHelper.addStyle(this, TableType.STRIPED);
        } else {
            StyleHelper.removeStyle(this, TableType.STRIPED);
        }
    }

    public void setBordered(boolean bordered) {
        if (bordered) {
            StyleHelper.addStyle(this, TableType.BORDERED);
        } else {
            StyleHelper.removeStyle(this, TableType.BORDERED);
        }
    }

    public void setCondensed(boolean condensed) {
        if (condensed) {
            StyleHelper.addStyle(this, TableType.CONDENSED);
        } else {
            StyleHelper.removeStyle(this, TableType.CONDENSED);
        }
    }

    public void setHover(boolean hover) {
        if (hover) {
            StyleHelper.addStyle(this, TableType.HOVER);
        } else {
            StyleHelper.removeStyle(this, TableType.HOVER);
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
        return (loadingImg == null) ? null : new Image(loadingImg);
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
    public void setStyle(com.github.gwtbootstrap.client.ui.base.Style style) {
        StyleHelper.setStyle(this, style);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addStyle(com.github.gwtbootstrap.client.ui.base.Style style) {
        StyleHelper.addStyle(this, style);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeStyle(com.github.gwtbootstrap.client.ui.base.Style style) {
        StyleHelper.removeStyle(this, style);

    }
}
