package com.geekvigarista.gwt.bootstrap.client.ui;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Widget;

/**
 * A Nav List in a well.
 * 
 * @author Dominik Mayer
 */
public class WellNavList extends Well {

	private NavList navList = new NavList();
	
	public WellNavList() {
		super.add(navList);
		setStyle();
	}
	
	@Override
	public void add(Widget child) {
		navList.add(child);
	}
	
	public void setStyle() {
		Style style = getElement().getStyle(); 
		style.setPaddingTop(8, Unit.PX);
		style.setPaddingBottom(8, Unit.PX);
		style.setPaddingLeft(0, Unit.PX);
		style.setPaddingRight(0, Unit.PX);
	}
}