package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.UnorderedList;
import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.ui.Widget;

/**
 * Multi-Page Pagination
 * 
 * @author Dominik Mayer
 */
public class Pagination extends DivWidget {

	private UnorderedList list = new UnorderedList();
	
	public Pagination() {
		setStyle(Bootstrap.Pagination.LEFT);
		super.add(list);
	}
	
	public void setAlignment(String alignment) {
		if (alignment.equalsIgnoreCase("right"))
			setStyle(Bootstrap.Pagination.RIGHT);
		else if (alignment.equalsIgnoreCase("centered"))
			setStyle(Bootstrap.Pagination.CENTERED);
		else
			setStyle(Bootstrap.Pagination.LEFT);
	}
	
	@Override
	public void add(Widget child) {
		list.add(child);
	}
}
