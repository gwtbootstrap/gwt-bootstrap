package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.Bootstrap;

/**
 * The Nav List
 * 
 * @author Dominik Mayer
 */
public class NavList extends UnorderedList {

	public NavList() {
		addStyleName(Bootstrap.nav);
		addStyleName(Bootstrap.nav_list);
	}
}