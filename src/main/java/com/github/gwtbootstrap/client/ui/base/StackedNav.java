package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.UnorderedList;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;

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