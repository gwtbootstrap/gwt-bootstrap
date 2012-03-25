package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;

/**
 * A container for things hidden when the window width is too small. Has to be
 * placed inside a {@link ResponsiveNavbar}.
 * (Works only in combination with bootstrap-responsive.css.)
 * 
 * @author Dominik Mayer
 * @since 2012-03-25
 *
 */
public class NavCollapse extends DivWidget {

	public NavCollapse() {
		super(Bootstrap.nav_collapse);
	}
	
}
