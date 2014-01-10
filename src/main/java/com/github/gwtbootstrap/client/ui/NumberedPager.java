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
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.AbstractPager;
import com.google.gwt.view.client.HasRows;

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

    private int visiblePages = -1;
    private String nextText = ">";
    private String previousText = "<";
    private NavLink nextLink;
    private NavLink previousLink;

    private final Pagination pagination = new Pagination();

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

    // limit number of pages shown
    public void setVisiblePages(int visiblePages) {
        this.visiblePages = visiblePages;
    }

    // set text of next button
    public void setNextText(String nextText) {
        this.nextText = nextText;
    }

    // set text of previous button
    public void setPreviousText(String previousText) {
        this.previousText = previousText;
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

    @Override
    protected void onRangeOrRowCountChanged() {
        int pageCount = super.getPageCount();
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
                pagination.clear();
            }
        }
    }

    private void initPagination() {
        previousLink = new NavLink(previousText);
        previousLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                NumberedPager.this.previousPage();
            }
        });
        pagination.add(previousLink);

        NavLink page = pagination.addPageLink(1);
        page.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                NumberedPager.this.setPage(0);
            }
        });
        page.setDisabled(true);

        nextLink = new NavLink(nextText);
        nextLink.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                NumberedPager.this.nextPage();
            }
        });
        pagination.add(nextLink);
    }

    private void updateButtonsState() {
        if (visiblePages > 0) {
            // calculate offsets
            final int currentPage = getPage();
            final int pageCount = getPageCount();
            final int pagesToShow = Math.min(pageCount, visiblePages);
            int firstVisibleIndex = 1;

            if (currentPage >= pageCount - (visiblePages / 2)) {
                firstVisibleIndex = pageCount - visiblePages + 1;
            } else if (currentPage > visiblePages / 2) {
                firstVisibleIndex = currentPage - (visiblePages / 2) + 1;
            }

            final int lastVisibleIndex = pagesToShow + firstVisibleIndex;

            // set out of range pages as invisible (before initial threshold)
            for (int i = 1; i < firstVisibleIndex; i++) {
                pagination.getWidget(i).setVisible(false);
            } // (after final threshold)
            for (int i = lastVisibleIndex; i < pagination.getWidgetCount() - 1; i++) {
                pagination.getWidget(i).setVisible(false);
            }

            // set in range pages as visible
            for (int i = firstVisibleIndex; i < lastVisibleIndex; i++) {
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
        NavLink navLink = (NavLink) pagination.getWidget(super.getPage() + 1);
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
}