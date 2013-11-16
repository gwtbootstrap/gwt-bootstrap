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
 * Constants interface with all CSS class names from Twitter Bootstrap. Will be
 * removed once the migration to {@link Constants} is finished.
 * 
 * @since 2.0.4.0
 * 
 * @author Carlos Alexandro Becker
 * 
 * @author Dominik Mayer
 */
public interface Bootstrap {


	public static final String prev = "prev";

	public static final String next = "next";

	public static final String block_message = "block-message";

	public static final String large = "large";

	public static final String small = "small";

	public static final String container = "container";

	public static final String sidebar = "sidebar";

	public static final String nav = "nav";

	public static final String nav_list = "nav-list";

	public static final String nav_header = "nav-header";

	public static final String menu = "menu";

	public static final String menu_dropdown = "menu-dropdown";

	public static final String clearfix = "clearfix";

	public static final String input = "input";

	public static final String uneditable_input = "uneditable-input";

	public static final String search_query = "search-query";

	public static final String inverse = "inverse";

	public static final String page_header = "page-header";

	public static final String hero_unit = "hero-unit";

	public static final String progress_striped = "progress-striped";

	public static final String progress_animated = "progress-striped "
			+ Constants.ACTIVE;

	public static final String pager = "pager";

	public static final String linenums = "linenums";

	public static final String prettyprint = "prettyprint";

	public static final String nav_tabs = "nav-tabs";

	public static final String nav_pills = "nav-pills";

	public static final String nav_stacked = "nav-stacked";

	public static final String tabbable = "tabbable";

	public static final String tab_pane = "tab-pane";

	public static final String tab_content = "tab-content";

	public static final String footer = "footer";

	public static final String nav_collapse = "nav-collapse";

	public static final String nav_collapse_target = "." + nav_collapse;

	public static final String collapse = "collapse";

	public static final String data_target = "data-target";

	public enum Tabs implements Style {

		ABOVE(""),
		BELOW("tabs-below"),
		LEFT("tabs-left"),
		RIGHT("tabs-right");
		
		private static final String tabbable = "tabbable ";

		private String className;

		private Tabs(String className) {
			this.className = tabbable + className;
		}

		public String get() {
			return className;
		}
	}

	public enum Pagination implements Style {

		LEFT(""), CENTERED("pagination-centered"), RIGHT("pagination-right");

		private static final String pagination = "pagination ";

		private String className;

		private Pagination(String className) {
			this.className = pagination + className;
		}

		public String get() {
			return className;
		}
	}

}
