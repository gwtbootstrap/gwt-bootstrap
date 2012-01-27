package com.geekvigarista.gwt.bootstrap.client.ui.topbar;

import com.geekvigarista.gwt.bootstrap.client.ui.ListItem;
import com.geekvigarista.gwt.bootstrap.client.ui.UnordenedList;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.ResourceInjector;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Resources;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Dropdown ListItem for {@link Topbar} and TabBar (FIXME: link).
 * 
 * @author Carlos Alexandro Becker
 * @since 25/01/2012
 */
public class DropdownListItem extends ListItem {

	static {
		ResourceInjector.injectJs(Resources.RESOURCES.dropdown());
	}

	{
		setStyleName(BootstrapCssResources.menu);
	}

	private final UnordenedList ul;
	private final Anchor a;

	public DropdownListItem(String text) {
		a = new Anchor(text);
		a.setHref("#");
		a.setStyleName(BootstrapCssResources.menu);

		add(a);

		ul = new UnordenedList();
		ul.setStyleName(BootstrapCssResources.menu_dropdown);

		add(ul);
	}

	public void addItem(ListItem li) {
		ul.add(li);
	}

	@Override
	public void add(IsWidget child) {
		super.add(child);
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		configure(getElement());
	}

	private native void configure(Element e) /*-{
		$wnd.jQuery(e).dropdown();
	}-*/;
}
