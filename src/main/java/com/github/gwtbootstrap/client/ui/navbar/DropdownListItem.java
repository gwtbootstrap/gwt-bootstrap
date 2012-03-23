package com.github.gwtbootstrap.client.ui.navbar;

import com.github.gwtbootstrap.client.ui.ListItem;
import com.github.gwtbootstrap.client.ui.Navbar;
import com.github.gwtbootstrap.client.ui.UnordenedList;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Anchor;

/**
 * Dropdown ListItem for {@link Navbar} and TabBar (FIXME: link).
 * 
 * @author Carlos Alexandro Becker
 * @since 25/01/2012
 */
public class DropdownListItem extends ListItem {

//	static {
//		ResourceInjector.injectJs(Resources.RESOURCES.dropdown());
//	}

	{
		setStyleName(Bootstrap.menu);
	}

	private final UnordenedList ul;
	private final Anchor a;

	public DropdownListItem(String text) {
		a = new Anchor(text);
		a.setHref("#");
		a.setStyleName(Bootstrap.menu);

		add(a);

		ul = new UnordenedList();
		ul.setStyleName(Bootstrap.menu_dropdown);

		add(ul);
	}

	public void addItem(ListItem li) {
		ul.add(li);
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
