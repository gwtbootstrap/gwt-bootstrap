package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.navbar.NavFormBase;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;

/**
 * Search form in the Navbar.
 * 
 * @author Dominik Mayer
 */
public class NavSearch extends NavFormBase {

	public NavSearch() {
		super();
		addStyleName(BootstrapCssResources.navbar_search);
		getTextBox().addStyleName(BootstrapCssResources.search_query);
	}
	
	public NavSearch(int size) {
		super(size);
		addStyleName(BootstrapCssResources.navbar_search);
	}
}
