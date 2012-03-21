package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.AlertBase;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;

/**
 * Alert block widget.
 * 
 * @author Dominik Mayer
 */
public class AlertBlock extends AlertBase {

	private Heading heading = new Heading(4);
	
	public AlertBlock() {
		setUp();
	}
	
	private void setUp() {
		addStyleName(BootstrapCssResources.alert_block);
		heading.setStyleName(BootstrapCssResources.alert_heading);
		add(heading);
	}
	
	public AlertBlock(boolean hasClose) {
		super(hasClose);
		setUp();
	}
	
	public AlertBlock(Style style) {
		super(style);
		setUp();
	}
	
	@Override
	public void setStyle(String stylename) {
		super.setStyle(stylename);
		addStyleName(BootstrapCssResources.alert_block);
	}
	
	@Override
	public void setHeading(String text) {
		heading.setText(text);
		super.setHeading(heading.toString());
	}
}
