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
package com.github.gwtbootstrap.client.ui.resources;

import com.github.gwtbootstrap.client.ui.base.Style;
import com.github.gwtbootstrap.client.ui.constants.Constants;

/**
 * Constants interface with all CSS class names from Bootstrap. Will be
 * removed once the migration to {@link Constants} is finished.
 * 
 * @since 2.0.4.0
 * 
 * @author Carlos Alexandro Becker
 * 
 * @author Dominik Mayer
 */
public interface Bootstrap {


	public static final String PREV = "prev";

	public static final String NEXT = "next";

	public static final String BLOCK_MESSAGE = "block-message";

	public static final String LARGE = "large";

	public static final String SMALL = "small";

	public static final String CONTAINER = "container";

	public static final String SIDEBAR = "sidebar";

	public static final String NAV = "nav";

	public static final String NAV_LIST = "nav-list";

	public static final String NAV_HEADER = "nav-header";

	public static final String MENU = "menu";

	public static final String MENU_DROPDOWN = "menu-dropdown";

	public static final String CLEARFIX = "clearfix";

	public static final String INPUT = "input";

	public static final String UNEDITABLE_INPUT = "uneditable-input";

	public static final String SEARCH_QUERY = "search-query";

	public static final String INVERSE = "inverse";

	public static final String PAGE_HEADER = "page-header";

	public static final String HERO_UNIT = "hero-unit";

	public static final String PROGRESS_STRIPED = "progress-striped";

	public static final String PROGRESS_ANIMATED = "progress-striped "
			+ Constants.ACTIVE;

	public static final String PAGER = "pager";

	public static final String LINENUMS = "linenums";

	public static final String PRETTYPRINT = "prettyprint";

	public static final String NAV_TABS = "nav-tabs";

	public static final String NAV_PILLS = "nav-pills";

	public static final String NAV_STACKED = "nav-stacked";

	public static final String TABBABLE = "tabbable";

	public static final String TAB_PANE = "tab-pane";

	public static final String TAB_CONTENT = "tab-content";

	public static final String FOOTER = "footer";

	public enum Tabs implements Style {

		ABOVE(""),
		BELOW("tabs-below"),
		LEFT("tabs-left"),
		RIGHT("tabs-right");
		
		private static final String TABBABLE = "tabbable ";

		private String className;

		private Tabs(String className) {
			this.className = TABBABLE + className;
		}

		public String get() {
			return className;
		}
	}

	public enum Pagination implements Style {

		LEFT(""), CENTERED("pagination-centered"), RIGHT("pagination-right");

		private static final String PAGINATION = "pagination ";

		private String className;

		private Pagination(String className) {
			this.className = PAGINATION + className;
		}

		public String get() {
			return className;
		}
	}

}
