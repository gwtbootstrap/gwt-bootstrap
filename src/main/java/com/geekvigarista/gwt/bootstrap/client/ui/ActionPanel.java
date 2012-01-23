package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.SizeHelper;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Span;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * A action panel.
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
