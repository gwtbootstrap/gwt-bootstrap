package com.geekvigarista.gwt.bootstrap.client.ui.resources;

/**
 * Constants interface with all CSS class names from twitter bootstrap.
 * 
 * @author Carlos Alexandro Becker
 * @since 20/01/2012
 */
public interface Bootstrap {
	
	public interface Style {
		public String get();
	}

	public static final String btn = "btn";

	public static final String tabs = "tabs";

	public static final String pills = "pills";

	public static final String breadcrumb = "breadcrumb";

	public static final String divider = "divider";
	
	public static final String divider_vertical = "divider-vertical";

	public static final String prev = "prev";

	public static final String next = "next";

	public static final String disabled = "disabled";

	public static final String active = "active";

	public static final String block_message = "block-message";

	public static final String large = "large";

	public static final String small = "small";

	public static final String container = "container";

	public static final String container_fluid = "container-fluid";

	public static final String sidebar = "sidebar";

	public static final String content = "content";

	public static final String row = "row";

	public static final String fade = "fade";

	public static final String in = "in";

	public static final String out = "out";

	public static final String notice = "notice";

	public static final String important = "important";

	public static final String actions = "actions";

	public static final String twipsy = "twipsy";
	
	public static final String navbar = "navbar";
	
	public static final String navbar_fixed_top = "navbar-fixed-top";
	
	public static final String navbar_fixed_bottom = "navbar-fixed-bottom";
	
	public static final String navbar_form = "navbar-form";
	
	public static final String navbar_search = "navbar-search";
	
	public static final String navbar_text = "navbar-text";
	
	public static final String fill = "fill";

	public static final String brand = "brand";

	public static final String nav = "nav";
	
	public static final String nav_list = "nav-list";
	
	public static final String nav_header = "nav-header";
	
	public static final String navbar_inner = "navbar-inner";

	public static final String menu = "menu";

	public static final String menu_dropdown = "menu-dropdown";

	public static final String pull_left = "pull-left";
	
	public static final String pull_right = "pull-right";

	public static final String clearfix = "clearfix";

	public static final String input = "input";

	public static final String uneditable_input = "uneditable-input";

	public static final String search_query = "search-query";

	public static final String well = "well";

	public static final String close = "close";

	public static final String inverse = "inverse";

	public static final String page_header = "page-header";

	public static final String hero_unit = "hero-unit";

	public static final String progress = "progress";

	public static final String progress_striped = "progress-striped";
	
	public static final String progress_animated = "progress-striped " + active;

	public static final String bar = "bar";

	public static final String data_dismiss = "data-dismiss";

	public static final String row_fluid = "row-fluid";

	public static final String pager = "pager";

	public static final String previous = "previous";

	public static final String pre_scrollable = "pre-scrollable";

	public static final String linenums = "linenums";

	public static final String prettyprint = "prettyprint";

	public static final String nav_tabs = "nav-tabs";
	
	public static final String nav_pills = "nav-pills";

	public static final String nav_stacked = "nav-stacked";
	
	
	public enum Badge implements Style {

		DEFAULT(""),
		SUCCESS("badge-success"),
		WARNING("badge-warning"),
		ERROR("badge-error"),
		INFO("badge-info"),
		INVERSE("badge-inverse");
		
		private static final String badge = "badge ";
	
		private String className;
		
		private Badge(String className) {
			this.className = badge + className;
		}
		
		public String get() {
			return className;
		}
	}
	
	// TODO
	public enum Alert implements Style {

		DEFAULT(""),
		ERROR("alert-error"),
		SUCCESS("alert-success"),
		INFO("alert-info"),
		ALERT("alert"),
		BLOCK("alert-block"),
		HEADING("alert-heading");
		
		private String className;
		
		private Alert(String className) {
			this.className = className;
		}
		
		public String get() {
			return className;
		}
	}
	
	public enum Label implements Style {

		DEFAULT(""),
		SUCCESS("label-success"),
		WARNING("label-warning"),
		IMPORTANT("label-important"),
		INFO("label-info"),
		INVERSE("label-inverse");
		
		private static final String label = "label ";
	
		private String className;
		
		private Label(String className) {
			this.className = label + className;
		}
		
		public String get() {
			return className;
		}
	}
	
	public enum Pagination implements Style {

		LEFT(""),
		CENTERED("pagination-centered"),
		RIGHT("pagination-right");
		
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
