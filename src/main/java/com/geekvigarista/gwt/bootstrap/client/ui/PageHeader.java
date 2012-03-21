package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.DivWidget;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.ui.HasText;

/**
 * Header sections of the website.
 * 
 * @author Dominik Mayer
 */
public class PageHeader extends DivWidget implements HasText {
	
	private final Heading heading = new Heading(1);
	
	public PageHeader() {
		setStyleName(Bootstrap.page_header);
		add(heading);
	}

	public String getText() {
		return heading.getText();
	}

	public void setText(String text) {
		heading.setText(text);
	}
	
	public void setSubtext(String text) {
		heading.setSubtext(text);
	}
	
}
