/*
 *  Copyright 2012 GWT Bootstrap
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
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Widget;

/**
 * The Navbar.
 * 
 * @author Dominik Mayer
 */
public class Navbar extends DivWidget {

	protected static final int TOP_SPACE_IN_PIXEL = 50;
	
	private boolean fixedTop = false;
	
	private class NavbarInner extends DivWidget {

		public NavbarInner() {
			setStyleName(Bootstrap.navbar_inner);
		}
	}

	private final Container container = new Container();
	private final NavbarInner navbarInner = new NavbarInner();
	private Scrollspy spy;

	public Navbar() {
		setStyleName(Bootstrap.navbar);
		navbarInner.add(container);
		super.add(navbarInner);
	}
	
	/**
	 * @param scrollspy: if true, will configure the scrollspy in the navbar.
	 */
	public void setScrollspy(boolean scrollspy) {
		spy = spy == null ? new Scrollspy(this) : spy;
		if(scrollspy)
		{
			spy.configure();
		}
		// TODO make a unconfigure feature.
	}
	
	
	/**
	 * Fix the Navbar at the top or bottom of the screen.
	 * <p>
	 * For this to work properly, the Navbar must not be a child of a 
	 * {@link Container}.
	 * 
	 * @param position "top" or "bottom"
	 */
	// TODO: Allow unsetting
	public void setFixed(String position) {
		fixedTop = false;

		if (position.equalsIgnoreCase("top")) {
			fixedTop = true;
			removeStyleName(Bootstrap.navbar_fixed_bottom);
			addStyleName(Bootstrap.navbar_fixed_top);
			setPaddingTop(TOP_SPACE_IN_PIXEL);
		} else if (position.equalsIgnoreCase("bottom")) {
			removeStyleName(Bootstrap.navbar_fixed_top);
			addStyleName(Bootstrap.navbar_fixed_bottom);
		}
		
	}

	@Override
	public void add(Widget child) {
		container.add(child);
	}
	
	protected void addWidget(Widget child) {
		super.add(child);
	}
	
	protected void setPaddingTop(boolean padding) {
		if (padding && fixedTop)
			setPaddingTop(TOP_SPACE_IN_PIXEL);
		else
			setPaddingTop(0);
	}
	
	private void setPaddingTop(int pixels) {
		Document.get().getBody().getStyle().setPaddingTop(
				pixels, Unit.PX);
	}
}
