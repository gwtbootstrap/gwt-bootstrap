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

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.base.Style;
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.base.UnorderedList;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off
/**
 * Multi-Page Pagination
 * 
 * @since 2.0.4.0
 * @author Dominik Mayer
 */
//@formatter:on
public class Pagination extends DivWidget {

	private UnorderedList list = new UnorderedList();

	public Pagination() {
		setStyle(Bootstrap.Pagination.LEFT);
		super.add(list);
		setSize(PaginationSize.NORMAL);
	}
	
	public static enum PaginationSize implements Style {
	    MINI,
	    SMALL,
	    NORMAL,
	    LARGE;

        @Override
        public String get() {
            if(this != NORMAL) {
                return "pagination-" + this.name().toLowerCase();
            }
            return "";
        }
	}

	public void setAlignment(String alignment) {
		if (alignment.equalsIgnoreCase("right"))
			setStyle(Bootstrap.Pagination.RIGHT);
		else if (alignment.equalsIgnoreCase("centered"))
			setStyle(Bootstrap.Pagination.CENTERED);
		else
			setStyle(Bootstrap.Pagination.LEFT);
	}
	
	public void setSize(PaginationSize size) {
	    StyleHelper.changeStyle(this, size, PaginationSize.class);
	}

	@Override
	public void add(Widget child) {
		list.add(child);
	}
	
	@Override
	public void clear() {
		list.clear();
	}
}
