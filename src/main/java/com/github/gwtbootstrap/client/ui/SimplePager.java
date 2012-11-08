/*
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.github.gwtbootstrap.client.ui.constants.Placement;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.cellview.client.AbstractPager;
import com.google.gwt.user.cellview.client.SimplePager.Style;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.view.client.HasRows;
import com.google.gwt.view.client.Range;

/**
 * A pager for controlling a {@link HasRows} that only supports simple page
 * navigation.
 *
 * <p>
 * <h3>Example</h3>
 *
 * <pre>
 *   <b:CellTable pageSize="10" ui:field="table" width="100%" />
 *   <div>
 *     <b:SimplePager display="{table}" location="RIGHT" fastForwardRows="50"/>
 *   </div>
 * </pre>
 *
 * </p>
 */
public class SimplePager extends AbstractPager {

    /**
     * Constant for labeling the simple pager navigational {@link ImageButton}s
     */
    @DefaultLocale("en_US")
    public interface ImageButtonsConstants extends Constants {
        @DefaultStringValue("Fast forward")
        String fastForward();

        @DefaultStringValue("First page")
        String firstPage();

        @DefaultStringValue("Last page")
        String lastPage();

        @DefaultStringValue("Next page")
        String nextPage();

        @DefaultStringValue("Previous page")
        String prevPage();
    }

    /**
     * A ClientBundle that provides styles for this widget.
     */
    public static interface Resources extends ClientBundle {

        /**
         * The styles used in this widget.
         */
        @Source("GwtBootstrapSimplePager.css")
        Style simplePagerStyle();
    }

    /**
     * The location of the text relative to the paging buttons.
     */
    public static enum TextLocation {
        CENTER, LEFT, RIGHT;
    }

    private static final int DEFAULT_FAST_FORWARD_ROWS = 100;
    private static Resources DEFAULT_RESOURCES;

    private static Resources getDefaultResources() {
        if (DEFAULT_RESOURCES == null) {
            DEFAULT_RESOURCES = GWT.create(Resources.class);
        }
        return DEFAULT_RESOURCES;
    }

    private final int tooltipDelay = 1000;
    private final Placement tooltipPlacement = Placement.BOTTOM;

    private final Button fastForward;
    private final Tooltip fastForwardTooltip;

    private int fastForwardRows;

    private final Button firstPage;
    private final Tooltip firstPageTooltip;

    /**
     * We use an {@link HTML} so we can embed the loading image.
     */
    private final HTML label = new HTML();

    private final Button lastPage;
    private final Button nextPage;
    private final Button prevPage;

    private final Tooltip lastPageTooltip;
    private final Tooltip nextPageTooltip;
    private final Tooltip prevPageTooltip;

    /**
     * The {@link Resources} used by this widget.
     */
    private final Resources resources;

    /**
     * The {@link Style} used by this widget.
     */
    private final Style style;

    /**
     * Construct a {@link SimplePager} with the default text location.
     */
    public SimplePager() {
        this(TextLocation.CENTER);
    }

    /**
     * Construct a {@link SimplePager} with the specified text location.
     *
     * @param location
     *            the location of the text relative to the buttons
     */
    @UiConstructor
    // Hack for Google I/O demo
    public SimplePager(TextLocation location) {
        this(location, getDefaultResources(), true, DEFAULT_FAST_FORWARD_ROWS, false);
    }

    /**
     * Construct a {@link SimplePager} with the default resources, fast forward
     * rows and default image button names.
     *
     * @param location
     *            the location of the text relative to the buttons
     * @param showFastForwardButton
     *            if true, show a fast-forward button that advances by a larger
     *            increment than a single page
     * @param showLastPageButton
     *            if true, show a button to go the the last page
     */
    public SimplePager(TextLocation location, boolean showFastForwardButton, boolean showLastPageButton) {
        this(location, showFastForwardButton, DEFAULT_FAST_FORWARD_ROWS, showLastPageButton);
    }

    /**
     * Construct a {@link SimplePager} with the default resources and default
     * image button names.
     *
     * @param location
     *            the location of the text relative to the buttons
     * @param showFastForwardButton
     *            if true, show a fast-forward button that advances by a larger
     *            increment than a single page
     * @param fastForwardRows
     *            the number of rows to jump when fast forwarding
     * @param showLastPageButton
     *            if true, show a button to go the the last page
     */
    public SimplePager(TextLocation location, boolean showFastForwardButton, final int fastForwardRows, boolean showLastPageButton) {
        this(location, getDefaultResources(), showFastForwardButton, fastForwardRows, showLastPageButton);
    }

    /**
     * Construct a {@link SimplePager} with the specified resources.
     *
     * @param location
     *            the location of the text relative to the buttons
     * @param resources
     *            the {@link Resources} to use
     * @param showFastForwardButton
     *            if true, show a fast-forward button that advances by a larger
     *            increment than a single page
     * @param fastForwardRows
     *            the number of rows to jump when fast forwarding
     * @param showLastPageButton
     *            if true, show a button to go the the last page
     * @param imageButtonConstants
     *            Constants that contain the image button names
     */
    public SimplePager(TextLocation location, Resources resources, boolean showFastForwardButton, final int fastForwardRows, boolean showLastPageButton, ImageButtonsConstants imageButtonConstants) {
        this.resources = resources;
        this.fastForwardRows = fastForwardRows;
        this.style = this.resources.simplePagerStyle();
        this.style.ensureInjected();

        // Create the buttons.
        firstPage = new Button();
        firstPage.setType(ButtonType.LINK);
        firstPage.setIcon(IconType.FAST_BACKWARD);
        firstPage.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                firstPage();
            }
        });
        firstPageTooltip = new Tooltip(imageButtonConstants.firstPage());
        firstPageTooltip.setWidget(firstPage);
        firstPageTooltip.setPlacement(tooltipPlacement);
        firstPageTooltip.setShowDelay(tooltipDelay);

        nextPage = new Button();
        nextPage.setType(ButtonType.LINK);
        nextPage.setIcon(IconType.STEP_FORWARD);
        nextPage.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                nextPage();
            }
        });
        nextPageTooltip = new Tooltip(imageButtonConstants.nextPage());
        nextPageTooltip.setWidget(nextPage);
        nextPageTooltip.setPlacement(tooltipPlacement);
        nextPageTooltip.setShowDelay(tooltipDelay);

        prevPage = new Button();
        prevPage.setType(ButtonType.LINK);
        prevPage.setIcon(IconType.STEP_BACKWARD);
        prevPage.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                previousPage();
            }
        });
        prevPageTooltip = new Tooltip(imageButtonConstants.prevPage());
        prevPageTooltip.setWidget(prevPage);
        prevPageTooltip.setPlacement(tooltipPlacement);
        prevPageTooltip.setShowDelay(tooltipDelay);

        if (showLastPageButton) {
            lastPage = new Button();
            lastPage.setType(ButtonType.LINK);
            lastPage.setIcon(IconType.FAST_FORWARD);
            lastPage.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    lastPage();
                }
            });
            lastPageTooltip = new Tooltip(imageButtonConstants.lastPage());
            lastPageTooltip.setWidget(lastPage);
            lastPageTooltip.setPlacement(tooltipPlacement);
            lastPageTooltip.setShowDelay(tooltipDelay);
        } else {
            lastPage = null;
            lastPageTooltip = null;
        }
        if (showFastForwardButton) {
            fastForward = new Button();
            fastForward.setType(ButtonType.LINK);
            fastForward.setIcon(IconType.FORWARD);
            fastForward.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    setPage(getPage() + getFastForwardPages());
                }
            });
            fastForwardTooltip = new Tooltip(imageButtonConstants.fastForward());
            fastForwardTooltip.setWidget(fastForward);
            fastForwardTooltip.setPlacement(tooltipPlacement);
            fastForwardTooltip.setShowDelay(tooltipDelay);
        } else {
            fastForward = null;
            fastForwardTooltip = null;
        }

        // Construct the widget.
        HorizontalPanel layout = new HorizontalPanel();
        layout.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        initWidget(layout);
        if (location == TextLocation.LEFT) {
            layout.add(label);
        }
        layout.add(firstPage);
        layout.add(prevPage);
        if (location == TextLocation.CENTER) {
            layout.add(label);
        }
        layout.add(nextPage);
        if (showFastForwardButton) {
            layout.add(fastForward);
        }
        if (showLastPageButton) {
            layout.add(lastPage);
        }

        layout.add(firstPageTooltip);
        layout.add(prevPageTooltip);
        layout.add(nextPageTooltip);
        if (showFastForwardButton) {
            layout.add(fastForwardTooltip);
        }
        if (showLastPageButton) {
            layout.add(lastPageTooltip);
        }

        if (location == TextLocation.RIGHT) {
            layout.add(label);
        }

        // Add style names to the cells.
        firstPage.getElement().getParentElement().addClassName(style.button());
        prevPage.getElement().getParentElement().addClassName(style.button());
        label.getElement().getParentElement().addClassName(style.pageDetails());
        nextPage.getElement().getParentElement().addClassName(style.button());
        if (showFastForwardButton) {
            fastForward.getElement().getParentElement().addClassName(style.button());
        }
        if (showLastPageButton) {
            lastPage.getElement().getParentElement().addClassName(style.button());
        }

        // Disable the buttons by default.
        setDisplay(null);
    }

    /**
     * Construct a {@link SimplePager} with the specified resources and default
     * image button names.
     *
     * @param location
     *            the location of the text relative to the buttons
     * @param resources
     *            the {@link Resources} to use
     * @param showFastForwardButton
     *            if true, show a fast-forward button that advances by a larger
     *            increment than a single page
     * @param fastForwardRows
     *            the number of rows to jump when fast forwarding
     * @param showLastPageButton
     *            if true, show a button to go the the last page
     */
    public SimplePager(TextLocation location, Resources resources, boolean showFastForwardButton, final int fastForwardRows, boolean showLastPageButton) {
        this(location, resources, showFastForwardButton, fastForwardRows, showLastPageButton, GWT.<ImageButtonsConstants> create(ImageButtonsConstants.class));
    }

    @Override
    public void firstPage() {
        super.firstPage();
    }

    @Override
    public int getPage() {
        return super.getPage();
    }

    @Override
    public int getPageCount() {
        return super.getPageCount();
    }

    @Override
    public boolean hasNextPage() {
        return super.hasNextPage();
    }

    @Override
    public boolean hasNextPages(int pages) {
        return super.hasNextPages(pages);
    }

    @Override
    public boolean hasPage(int index) {
        return super.hasPage(index);
    }

    @Override
    public boolean hasPreviousPage() {
        return super.hasPreviousPage();
    }

    @Override
    public boolean hasPreviousPages(int pages) {
        return super.hasPreviousPages(pages);
    }

    @Override
    public void lastPage() {
        super.lastPage();
    }

    @Override
    public void lastPageStart() {
        super.lastPageStart();
    }

    @Override
    public void nextPage() {
        super.nextPage();
    }

    @Override
    public void previousPage() {
        super.previousPage();
    }

    @Override
    public void setDisplay(HasRows display) {
        // Enable or disable all buttons.
        boolean disableButtons = (display == null);
        setFastForwardDisabled(disableButtons);
        setNextPageButtonsDisabled(disableButtons);
        setPrevPageButtonsDisabled(disableButtons);
        super.setDisplay(display);
    }

    @Override
    public void setPage(int index) {
        super.setPage(index);
    }

    @Override
    public void setPageSize(int pageSize) {
        super.setPageSize(pageSize);
    }

    @Override
    public void setPageStart(int index) {
        super.setPageStart(index);
    }

    /**
     * Let the page know that the table is loading. Call this method to clear
     * all data from the table and hide the current range when new data is being
     * loaded into the table.
     */
    public void startLoading() {
        getDisplay().setRowCount(0, true);
        label.setHTML("");
    }

    /**
     * Get the text to display in the pager that reflects the state of the
     * pager.
     *
     * @return the text
     */
    protected String createText() {
        // Default text is 1 based.
        NumberFormat formatter = NumberFormat.getFormat("#,###");
        HasRows display = getDisplay();
        Range range = display.getVisibleRange();
        int pageStart = range.getStart() + 1;
        int pageSize = range.getLength();
        int dataSize = display.getRowCount();
        int endIndex = Math.min(dataSize, pageStart + pageSize - 1);
        endIndex = Math.max(pageStart, endIndex);
        boolean exact = display.isRowCountExact();
        return formatter.format(pageStart) + "-" + formatter.format(endIndex) + (exact ? " of " : " of over ") + formatter.format(dataSize);
    }

    @Override
    protected void onRangeOrRowCountChanged() {
        HasRows display = getDisplay();
        label.setText(createText());

        // Update the prev and first buttons.
        setPrevPageButtonsDisabled(!hasPreviousPage());

        // Update the next and last buttons.
        if (isRangeLimited() || !display.isRowCountExact()) {
            setNextPageButtonsDisabled(!hasNextPage());
            setFastForwardDisabled(!hasNextPages(getFastForwardPages()));
        }
    }

    /**
     * Check if the next button is disabled. Visible for testing.
     */
    boolean isNextButtonDisabled() {
        return !nextPage.isEnabled();
    }

    /**
     * Check if the previous button is disabled. Visible for testing.
     */
    boolean isPreviousButtonDisabled() {
        return !prevPage.isEnabled();
    }

    /**
     * Get the number of pages to fast forward based on the current page size.
     *
     * @return the number of pages to fast forward
     */
    private int getFastForwardPages() {
        int pageSize = getPageSize();
        return pageSize > 0 ? fastForwardRows / pageSize : 0;
    }

    public int getFastForwardRows() {
        return fastForwardRows;
    }

    public void setFastForwardRows(int fastForwardRows) {
        this.fastForwardRows = fastForwardRows;
    }

    /**
     * Enable or disable the fast forward button.
     *
     * @param disabled
     *            true to disable, false to enable
     */
    private void setFastForwardDisabled(boolean disabled) {
        if (fastForward != null) {
            fastForward.setEnabled(!disabled);
            if (disabled) {
                fastForward.getElement().addClassName(style.disabledButton());
            } else {
                fastForward.getElement().removeClassName(style.disabledButton());
            }
        }
    }

    /**
     * Enable or disable the next page buttons.
     *
     * @param disabled
     *            true to disable, false to enable
     */
    private void setNextPageButtonsDisabled(boolean disabled) {
        nextPage.setEnabled(!disabled);
        if (disabled) {
            nextPage.getElement().addClassName(style.disabledButton());
        } else {
            nextPage.getElement().removeClassName(style.disabledButton());
        }
        if (lastPage != null) {
            lastPage.setEnabled(!disabled);
            if (disabled) {
                lastPage.getElement().addClassName(style.disabledButton());
            } else {
                lastPage.getElement().removeClassName(style.disabledButton());
            }
        }
    }

    /**
     * Enable or disable the previous page buttons.
     *
     * @param disabled
     *            true to disable, false to enable
     */
    private void setPrevPageButtonsDisabled(boolean disabled) {
        firstPage.setEnabled(!disabled);
        prevPage.setEnabled(!disabled);
        if (disabled) {
            firstPage.getElement().addClassName(style.disabledButton());
            prevPage.getElement().addClassName(style.disabledButton());
        } else {
            firstPage.getElement().removeClassName(style.disabledButton());
            prevPage.getElement().removeClassName(style.disabledButton());
        }
    }
}
