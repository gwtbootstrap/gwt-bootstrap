package com.geekvigarista.gwt.bootstrap.client.old;

import com.geekvigarista.gwt.bootstrap.client.old.base.SizeHelper;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Span;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * A action panel, commonly used to put action buttons, like save/delete/cancel etc...
 * 
 * @author Carlos Alexandro Becker
 * @since 23/01/2012
 */
public class ActionPanel extends SimplePanel {

	{
		setStyleName(BootstrapCssResources.actions);
		setSize(Span._5);
	}

	public void setSize(Span spanSize) {
		SizeHelper.setSize(spanSize, this);
	}
	
}
