package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.AlertBase;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;

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
		super.addStyle(Bootstrap.Alert.BLOCK);
		heading.setStyle(Bootstrap.Alert.HEADING);
		add(heading);
	}
	
	public AlertBlock(boolean hasClose) {
		super(hasClose);
		setUp();
	}
	
	public AlertBlock(Bootstrap.Alert style) {
		super(style);
		setUp();
	}
	
	@Override
	public void setStyle(String stylename) {
		super.setStyle(stylename);
		addStyle(Bootstrap.Alert.BLOCK);
	}
	
	@Override
	public void setHeading(String text) {
		heading.setText(text);
		super.setHeading(heading.toString());
	}
}
