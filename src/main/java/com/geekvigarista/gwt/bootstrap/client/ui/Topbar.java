package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.google.gwt.user.client.ui.Anchor;

/**
 * 
 * 
 * @author Carlos Alexandro Becker
 * @since 25/01/2012
 */
public class Topbar extends ContainerBase {

	private final Brand brand;
	private final FillDiv fill;
	private final ContainerDiv container;
	private final UnordenedList primaryNav;
	private final UnordenedList secondaryNav;

	public Topbar(String projectName) {

		setStyleName(BootstrapCssResources.topbar);

		fill = new FillDiv();
		container = new ContainerDiv();

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
	
	class Brand extends Anchor {
		public Brand(String projectName) {
			getElement().setClassName(BootstrapCssResources.brand);
			getElement().addClassName(BootstrapCssResources.active);
			getElement().setAttribute("href", "#");
			getElement().setInnerText(projectName);
		}
	}

	class FillDiv extends ContainerBase {
		{
			setStyleName(BootstrapCssResources.fill);
		}
	}

	class ContainerDiv extends ContainerBase {
		{
			setStyleName(BootstrapCssResources.container);
		}
	}

}
