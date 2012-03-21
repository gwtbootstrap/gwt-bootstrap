package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.UnorderedList;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
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
		setStyleName(BootstrapCssResources.pager);
		leftLink.setText(left);
		rightLink.setText(right);
		add(leftLink);
		add(rightLink);
	}
	
	public void setAligned(boolean aligned) {
		leftLink.setStyleName(BootstrapCssResources.previous);
		rightLink.setStyleName(BootstrapCssResources.next);
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
