package com.geekvigarista.gwt.bootstrap.client.ui.topbar;

import com.geekvigarista.gwt.bootstrap.client.ui.Container;
import com.geekvigarista.gwt.bootstrap.client.ui.DivPanel;
import com.geekvigarista.gwt.bootstrap.client.ui.ListItem;
import com.geekvigarista.gwt.bootstrap.client.ui.UnordenedList;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.google.gwt.user.client.ui.Widget;

/**
 * A twitter's like topbar component.
 * 
 * @author Carlos Alexandro Becker
 * @since 25/01/2012
 */
public class Topbar extends DivPanel {

	private final Brand brand;
	private final FillDiv fill;
	private final Container container;
	private final UnordenedList primaryNav;
	private final UnordenedList secondaryNav;

	public Topbar(String projectName) {

		setStyleName(BootstrapCssResources.topbar);

		fill = new FillDiv();
		container = new Container();

		brand = new Brand(projectName);

		primaryNav = new UnordenedList();
		primaryNav.setStyleName(BootstrapCssResources.nav);

		secondaryNav = new UnordenedList();
		secondaryNav.setStyleName(BootstrapCssResources.nav);
		secondaryNav.addStyleName(BootstrapCssResources.secondary_nav);

		container.add(brand);
		container.add(primaryNav);
		container.add(secondaryNav);
		fill.add(container);
		add(fill);
	}
	
	public void addPrimaryNavItem(ListItem li) {
		primaryNav.add(li);
	}
	
	public void addSecondaryNavItem(ListItem li) {
		secondaryNav.add(li);
	}
	
	public void addItem(Widget w) {
		container.add(w);
	}
}
