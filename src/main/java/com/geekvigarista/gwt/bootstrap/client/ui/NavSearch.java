package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.navbar.NavFormBase;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Bootstrap;

/**
 * Search form in the Navbar.
 * 
 * @author Dominik Mayer
 */
public class NavSearch extends NavFormBase {

	public NavSearch() {
		super();
		addStyleName(Bootstrap.navbar_search);
		getTextBox().addStyleName(Bootstrap.search_query);
	}
	
	public NavSearch(int size) {
		super(size);
		addStyleName(Bootstrap.navbar_search);
	}
}
