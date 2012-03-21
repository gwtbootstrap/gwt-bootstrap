package com.geekvigarista.gwt.bootstrap.client.ui.base;

import com.geekvigarista.gwt.bootstrap.client.ui.UnorderedList;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Bootstrap;

/**
 * Base class for stacked navs
 * 
 * @author Dominik Mayer
 */
public abstract class StackedNav extends UnorderedList {

	public StackedNav() {
		addStyleName(Bootstrap.nav);
	}
	
	public void setStacked(boolean stacked) {
		if (stacked)
			addStyleName(Bootstrap.nav_stacked);
		else
			removeStyleName(Bootstrap.nav_stacked);
	}
}