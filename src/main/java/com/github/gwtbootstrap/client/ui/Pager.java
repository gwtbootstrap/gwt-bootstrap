package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.UnorderedList;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.uibinder.client.UiConstructor;

/**
 * Pager that can be aligned
 * 
 * @author Dominik Mayer
 */
public class Pager extends UnorderedList {

	private NavLink leftLink = new NavLink();
	
	private NavLink rightLink = new NavLink();
	
//	private boolean arrows;
	
	public @UiConstructor Pager(String left, String right) {
		setStyleName(Bootstrap.pager);
		leftLink.setText(left);
		rightLink.setText(right);
		add(leftLink);
		add(rightLink);
	}
	
	public void setAligned(boolean aligned) {
		leftLink.setStyleName(Bootstrap.previous);
		rightLink.setStyleName(Bootstrap.next);
	}
	
	public NavLink getLeft() {
		return leftLink;
	}

	public NavLink getRight() {
		return rightLink;
	}
	
	public void setArrows(boolean hasArrows) {
		// TODO
	}
}
