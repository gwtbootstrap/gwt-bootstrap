package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.old.Container;
import com.github.gwtbootstrap.client.old.DivPanel;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Widget;

/**
 * The Navbar.
 * 
 * @author Dominik Mayer
 */
public class Navbar extends DivPanel {

	private class NavbarInner extends DivPanel {

		public NavbarInner() {
			setStyleName(Bootstrap.navbar_inner);
		}
	}
	
	private final Container container = new Container();
	private final NavbarInner navbarInner = new NavbarInner();

	public Navbar() {
		setStyleName(Bootstrap.navbar);
		navbarInner.add(container);
		super.add(navbarInner);
	}
	
	// TODO
	public void setFixed(String position) {
		if (position.equalsIgnoreCase("top")) {
			removeStyleName(Bootstrap.navbar_fixed_bottom);
			addStyleName(Bootstrap.navbar_fixed_top);
			Document.get().getBody().getStyle().setPaddingTop(40, Unit.PX);
		} if (position.equalsIgnoreCase("bottom")) {
			removeStyleName(Bootstrap.navbar_fixed_top);
			addStyleName(Bootstrap.navbar_fixed_bottom);
		}
	}
	
	@Override
	public void add(Widget child) {
		container.add(child);
	}
}
