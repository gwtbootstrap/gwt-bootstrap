package com.github.gwtbootstrap.client.old;

import com.github.gwtbootstrap.client.old.base.SizeHelper;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.github.gwtbootstrap.client.ui.resources.Span;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * A action panel, commonly used to put action buttons, like save/delete/cancel etc...
 * 
 * @author Carlos Alexandro Becker
 * @since 23/01/2012
 */
public class ActionPanel extends SimplePanel {

	{
		setStyleName(Bootstrap.actions);
		setSize(Span._5);
	}

	public void setSize(Span spanSize) {
		SizeHelper.setSize(spanSize, this);
	}
	
}
