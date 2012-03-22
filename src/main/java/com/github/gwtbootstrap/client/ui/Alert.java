package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.AlertBase;

/**
 * Alert widget.
 * 
 * @author Dominik Mayer
 */
public class Alert extends AlertBase {
	
	@Override
	public void setHeading(String text) {
		if (text == null || text.isEmpty())
			super.setHeading("");
		else
			super.setHeading("<b>" + text + "</b> ");
	}
}
