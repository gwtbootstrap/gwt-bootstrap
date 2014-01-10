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
 *
 * <p>
 * <h3>Example</h3>
 *
 * <pre>
 *   <code>
 *     <b:NumberedPager display="{table}"/>
 *     <b:CellTable pageSize="10" ui:field="table" width="100%" />
 *   </code>
 * </pre>
 *
 * </p>
 */
public class NumberedPager extends AbstractPager implements HasStyle, IsResponsive, HasId {
	
	String prevText = "<";
	String nextText = ">";

    final Pagination pagination = new Pagination();
    final NavLink prev = new NavLink(prevText);
    final NavLink next = new NavLink(nextText);
    int maxPages = -1;

    public NumberedPager() {
        initWidget(pagination);
    }

    public void setAlignment(String alignment) {
        pagination.setAlignment(alignment);
    }
    
    // limit number of pages shown
    public void setMaxPages(int maxPages) {
        this.maxPages = maxPages;
    }
    // set text of prev button
    public void setPrevText(String prevText) {
        this.prevText = prevText;
    }
    // set text of next button
    public void setNextText(String nextText) {
        this.nextText = nextText;
    }

    

    public void setSize(Pagination.PaginationSize size) {
        pagination.setSize(size);
    }

    /**
     * Pulls the widget to the right side.
     *
     * @param pullRight
     *            <code>true</code> if the widget should be aligned right.
     */
    public void pullRight(boolean pullRight) {
        pagination.pullRight(pullRight);
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

    @Override
    protected void onRangeOrRowCountChanged() {
    	int pageCount = super.getPageCount();
    	if (pageCount > 0) {

    		// shows all pages and rebuilt incrementally
    		if (maxPages < 0) {
    			if (pagination.getWidgetCount() == 0) {
    				// Lazy init for not displaying back and forward buttons unnecessarily
    				initPagination();
    			}
    			int widgetCount = pagination.getWidgetCount();
    			if (pageCount + 2 > widgetCount) {
    				// If has there are *more* pages then links, then add the remaining links
    				for (int i = widgetCount-1; i <= pageCount; i++) {
    					NavLink page = pagination.addPageLink(i);
    					page.addClickHandler(createPageClickHandler(i - 1));
    				}
    			} else if (pageCount + 2 < widgetCount) {
    				// If has there are *less* pages then links, then remove the exceeding links
    				for (int i = widgetCount - 2; i > pageCount; i--) {
    					pagination.remove(i);
    				}
    			}

    			// shows a rotated fixed number of pages (determined by 'maxpages') and rebuilt from scratch
    		} else {
    			// built it from scratch
    			pagination.clear();

    			// calculate offsets
    			int currentPage = getPage();
    			int pagesToShow = Math.min(getPageCount(), maxPages);
    			int firstPageToShow = 1;

    			if (maxPages > getPageCount())
    				firstPageToShow = 1;
    			else if (currentPage > getPageCount() - (maxPages / 2))
    				firstPageToShow = getPageCount() - maxPages + 1;  
    			else if(currentPage > maxPages / 2)
    				firstPageToShow = currentPage - (maxPages / 2) + 1;          		

    			// add prev
    			final NavLink prev1 = new NavLink(prevText);
    			prev1.addClickHandler(new ClickHandler() {
    				@Override
    				public void onClick(ClickEvent event) {
    					NumberedPager.this.previousPage();
    				}
    			});
    			pagination.add(prev1);

    			// add pages
    			for(int i = 1; i < firstPageToShow; i++)			// workaround. base component need all previous children, create fake (not visible)
    				pagination.addPageLink(i).setVisible(false);
    			for (int i = firstPageToShow; i < pagesToShow + firstPageToShow; i++) {
    				NavLink page = pagination.addPageLink(i);
    				page.addClickHandler(createPageClickHandler(i - 1));
    			}

    			// add next
    			final NavLink next1 = new NavLink(nextText);
    			next1.addClickHandler(new ClickHandler() {
    				@Override
    				public void onClick(ClickEvent event) {
    					NumberedPager.this.nextPage();
    				}
    			});
    			pagination.add(next1);

    			prev1.setDisabled(!super.hasPreviousPage());
    			next1.setDisabled(!super.hasNextPage());
    		}

    		// Set the actual page link as disabled
    		updateButtonsState();
    	} else {
    		if (pagination.getWidgetCount() > 0) {
    			pagination.clear();
    		}
    	}
    }

    private ClickHandler createPageClickHandler(final int page) {
        return new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                NumberedPager.this.setPage(page);
            }
        };
    }

    private void updateButtonsState() {
        // Set all numbered buttons as enabled
        for (int i = 1; i < pagination.getWidgetCount()-1; i++) {
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

    private void initPagination() {
        prev.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                NumberedPager.this.previousPage();
            }
        });
        pagination.add(prev);

        NavLink page = pagination.addPageLink(1);
        page.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                NumberedPager.this.setPage(0);
            }
        });
        page.setDisabled(true);

        next.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                NumberedPager.this.nextPage();
            }
        });
        pagination.add(next);
    }

    private void updatePreviousAndNextButtons() {
        prev.setDisabled(!super.hasPreviousPage());
        next.setDisabled(!super.hasNextPage());
    }
}