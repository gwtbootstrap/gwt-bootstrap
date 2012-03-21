package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.old.Container;
import com.geekvigarista.gwt.bootstrap.client.old.DivPanel;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
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
			setStyleName(BootstrapCssResources.navbar_inner);
		}
	}
	
	private final Container container = new Container();
	private final NavbarInner navbarInner = new NavbarInner();

	public Navbar() {
		setStyleName(BootstrapCssResources.navbar);
		navbarInner.add(container);
		super.add(navbarInner);
	}
	
	// TODO
	public void setFixed(String position) {
		if (position.equalsIgnoreCase("top")) {
			removeStyleName(BootstrapCssResources.navbar_fixed_bottom);
			addStyleName(BootstrapCssResources.navbar_fixed_top);
			Document.get().getBody().getStyle().setPaddingTop(40, Unit.PX);
		} if (position.equalsIgnoreCase("bottom")) {
			removeStyleName(BootstrapCssResources.navbar_fixed_top);
			addStyleName(BootstrapCssResources.navbar_fixed_bottom);
		}
	}
	
	@Override
	public void add(Widget child) {
		container.add(child);
	}
}
