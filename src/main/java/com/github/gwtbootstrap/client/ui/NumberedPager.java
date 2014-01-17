/*
 *  Copyright 2013 GWT-Bootstrap
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

import com.github.gwtbootstrap.client.ui.base.HasId;
import com.github.gwtbootstrap.client.ui.base.HasStyle;
import com.github.gwtbootstrap.client.ui.base.IsResponsive;
import com.github.gwtbootstrap.client.ui.constants.Device;
import com.github.gwtbootstrap.client.ui.constants.IconPosition;
import com.github.gwtbootstrap.client.ui.constants.IconSize;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.AbstractPager;
import com.google.gwt.view.client.HasRows;
import com.google.web.bindery.event.shared.HandlerRegistration;

import java.util.ArrayList;
import java.util.List;

/**
 * A pager for controlling a {@link HasRows} using {@link Pagination}.
 * Just bind the NumberedPager using {@code NumberedPager.setDisplay} to some {@link HasRows} implementation like
 * {@link CellTable} or {@link DataGrid}, and the pager is automatically generated fully working.
 * <p/>
 * <p>
 * <h3>Example</h3>
 * <p/>
 * <pre>
 *   <code>
 *     <b:NumberedPager display="{table}"/>
 *     <b:CellTable pageSize="10" ui:field="table" width="100%" />
 *   </code>
 * </pre>
 * <p/>
 * </p>
 */
public class NumberedPager extends AbstractPager implements HasStyle, IsResponsive, HasId {

    private final Pagination pagination = new Pagination();
    private final List<HandlerRegistration> handlerRegistrationList = new ArrayList<HandlerRegistration>();

    private int visiblePages = -1;
    private String nextCustomStyleName;
    private String previousCustomStyleName;
    private NavLink nextLink = new NavLink(">");
    private NavLink previousLink = new NavLink("<");

    public NumberedPager() {
        initWidget(pagination);
    }

    /**
     * {@inheritDoc}
     */
    public String getId() {
        return pagination.getId();
    }

    /**
     * {@inheritDoc}
     */
    public void setId(String id) {
        pagination.setId(id);
    }

    /**
     * Pulls the widget to the right side.
     *
     * @param pullRight <code>true</code> if the widget should be aligned right.
     */
    public void setPullRight(boolean pullRight) {
        pagination.setPullRight(pullRight);
    }

    public void setAlignment(String alignment) {
        pagination.setAlignment(alignment);
    }

    /**
     * Limit the number of visible pages in the Pagination widget.
     *
     * @param visiblePages number of visible pages
     */
    public void setVisiblePages(int visiblePages) {
        this.visiblePages = visiblePages;
        if (visiblePages > 0) {
            setRangeLimited(false);
        }/* else {
            setRangeLimited(true);
        }*/
    }

    /**
     * {@inheritDoc}
     */
    public void setShowOn(Device device) {
        pagination.setShowOn(device);
    }

    /**
     * {@inheritDoc}
     */
    public void setHideOn(Device device) {
        pagination.setHideOn(device);
    }

    public void setSize(Pagination.PaginationSize size) {
        pagination.setSize(size);
    }

    /**
     * {@inheritDoc}
     */
    public void setStyle(com.github.gwtbootstrap.client.ui.base.Style style) {
        pagination.setStyle(style);
    }

    /**
     * {@inheritDoc}
     */
    public void addStyle(com.github.gwtbootstrap.client.ui.base.Style style) {
        pagination.addStyle(style);
    }

    /**
     * {@inheritDoc}
     */
    public void removeStyle(com.github.gwtbootstrap.client.ui.base.Style style) {
        pagination.removeStyle(style);
    }

    public void setNextCustomStyleName(String nextCustomStyleName) {
        this.nextCustomStyleName = nextCustomStyleName;
    }

    public void setNextText(String nextText) {
        nextLink.setText(nextText);
    }

    public void setNextIcon(IconType type) {
        nextLink.setIcon(type);
    }

    public void setNextCustomIconStyle(String customIconStyle) {
        nextLink.setCustomIconStyle(customIconStyle);
    }

    public void setNextIconPosition(IconPosition position) {
        nextLink.setIconPosition(position);
    }

    public void setNextIconSize(IconSize size) {
        nextLink.setIconSize(size);
    }

    public void setPreviousCustomStyleName(String previousCustomStyleName) {
        this.previousCustomStyleName = previousCustomStyleName;
    }

    public void setPreviousText(String previousText) {
        previousLink.setText(previousText);
    }

    public void setPreviousIcon(IconType type) {
        previousLink.setIcon(type);
    }

    public void setPreviousCustomIconStyle(String customIconStyle) {
        previousLink.setCustomIconStyle(customIconStyle);
    }

    public void setPreviousIconPosition(IconPosition position) {
        previousLink.setIconPosition(position);
    }

    public void setPreviousIconSize(IconSize size) {
        previousLink.setIconSize(size);
    }

    @Override
    protected void onRangeOrRowCountChanged() {
        final HasRows display = super.getDisplay();
        final int pageSize = super.getPageSize();
        final int calculatedPage = display.getVisibleRange().getStart() / pageSize;
        final int pageCount = super.getPageCount();

        // Workaround GWT misbehavior:
        // Calculating wrong page when dynamically changing pageSize to a lower value and start index is between two pages.
        // This logic aims to correct the start index.
        if (pageCount > 0 && (calculatedPage != super.getPage())) {
            display.setVisibleRange(pageSize * calculatedPage, pageSize);
        } else {
            // Proceed with normal paging logic
            if (pageCount > 0) {
                if (pagination.getWidgetCount() == 0) {
                    // Lazy init for not displaying back and forward buttons unnecessarily
                    initPagination();
                }

                int widgetCount = pagination.getWidgetCount();
                if (pageCount + 2 > widgetCount) {
                    // If there are *more* pages then links, then add the remaining links
                    for (int i = widgetCount - 1; i <= pageCount; i++) {
                        NavLink page = pagination.addPageLink(i);
                        page.addClickHandler(createPageClickHandler(i - 1));
                    }
                } else if (pageCount + 2 < widgetCount) {
                    // If there are *less* pages then links, then remove the exceeding links
                    for (int i = widgetCount - 2; i > pageCount; i--) {
                        pagination.remove(i);
                    }
                }

                // Set the actual page link as disabled
                updateButtonsState();
            } else {
                if (pagination.getWidgetCount() > 0) {
                    resetPagination();
                }
            }
        }
    }

    private void initPagination() {
        if (previousCustomStyleName != null) previousLink.addStyleName(previousCustomStyleName);
        handlerRegistrationList.add(previousLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                NumberedPager.this.previousPage();
            }
        }));
        pagination.add(previousLink);

        NavLink page = pagination.addPageLink(1);
        page.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                NumberedPager.this.setPage(0);
            }
        });
        page.setDisabled(true);

        if (nextCustomStyleName != null) nextLink.addStyleName(nextCustomStyleName);
        handlerRegistrationList.add(nextLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                NumberedPager.this.nextPage();
            }
        }));
        pagination.add(nextLink);
    }

    private void updateButtonsState() {
        final int pageCount = getPageCount();
        final int currentPage = getPage();

        // If visiblePages is set, then treat circular exhibition
        if (visiblePages > 0) {
            // Calculate offsets
            final int maxPages = visiblePages < pageCount ? visiblePages : pageCount;
            final int pagesToShow = Math.min(pageCount, maxPages);
            int firstVisibleIndex = 1;

            if (currentPage >= pageCount - (maxPages / 2)) {
                firstVisibleIndex = pageCount - maxPages + 1;
            } else if (currentPage > maxPages / 2) {
                firstVisibleIndex = currentPage - (maxPages / 2) + 1;
            }

            final int firstNotVisibleIndex = pagesToShow + firstVisibleIndex;

            // Set out of range pages as invisible (before initial threshold)
            for (int i = 1; i < firstVisibleIndex; i++) {
                pagination.getWidget(i).setVisible(false);
            } // (after final threshold)
            for (int i = firstNotVisibleIndex; i < pagination.getWidgetCount() - 1; i++) {
                pagination.getWidget(i).setVisible(false);
            }

            // Set in range pages as visible
            for (int i = firstVisibleIndex; i < firstNotVisibleIndex; i++) {
                pagination.getWidget(i).setVisible(true);
            }
        }

        // Set all numbered buttons as enabled
        for (int i = 1; i < pagination.getWidgetCount() - 1; i++) {
            NavLink navLink = (NavLink) pagination.getWidget(i);
            navLink.setDisabled(false);
            navLink.setActive(false);
        }

        // Set the button of the current page as disable
        NavLink navLink = (NavLink) pagination.getWidget(currentPage + 1);
        navLink.setDisabled(true);
        navLink.setActive(true);

        // Update the state of previous and next buttons
        updatePreviousAndNextButtons();
    }

    private void updatePreviousAndNextButtons() {
        previousLink.setDisabled(!super.hasPreviousPage());
        nextLink.setDisabled(!super.hasNextPage());
    }

    private ClickHandler createPageClickHandler(final int page) {
        return new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                NumberedPager.this.setPage(page);
            }
        };
    }

    private void resetPagination() {
        // Deregister click handlers
        for (HandlerRegistration handlerRegistration : handlerRegistrationList) {
            handlerRegistration.removeHandler();
        }
        pagination.clear();
        if (previousCustomStyleName != null) previousLink.removeStyleName(previousCustomStyleName);
        if (nextCustomStyleName != null) nextLink.removeStyleName(nextCustomStyleName);
    }
}