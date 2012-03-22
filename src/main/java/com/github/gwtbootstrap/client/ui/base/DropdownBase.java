package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.UnorderedList;
import com.github.gwtbootstrap.client.ui.base.ComplexWidget;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author Carlos A Becker
 * @author Dominik Mayer
 */
public abstract class DropdownBase extends ComplexWidget {

	private UnorderedList menu = new UnorderedList();
	private IconAnchor trigger;
	
	private NavLink link;

	public DropdownBase(String type) {
		super(type);

		trigger = createTrigger();
		trigger.addStyleName("dropdown-toggle");
		trigger.getElement().setAttribute("data-toggle", "dropdown");
		super.add(trigger);
		
		menu.setStyleName("dropdown-menu");
		super.add(menu);
	}

	public void setText(String text) {
		trigger.setText(text);
	}
	
	protected abstract IconAnchor createTrigger();
	
	public void setDropup(boolean dropup) {
		if (dropup)
			addStyleName(Bootstrap.dropup);
		else
			removeStyleName(Bootstrap.dropup);
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		if (trigger != null) {
			configure(trigger.getElement());
		}
	}

	@Override
	public void add(Widget w) {
		assert w instanceof NavLink : "You can only add NavLink items";
		menu.add(w);
	}
	
	protected void addWidget(Widget w) {
		super.add(w);
	}

	private native void configure(Element e) /*-{
		$wnd.jQuery(e).dropdown();
	}-*/;
}
