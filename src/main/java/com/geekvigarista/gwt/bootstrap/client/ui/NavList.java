package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;

/**
 * The Nav List
 * 
 * @author Dominik Mayer
 */
public class NavList extends UnorderedList {

	public NavList() {
		addStyleName(BootstrapCssResources.nav);
		addStyleName(BootstrapCssResources.nav_list);
	}
}