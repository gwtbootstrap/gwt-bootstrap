package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HtmlWidget;


public class FormLabel extends HtmlWidget {

	public FormLabel(String html) {
		super("label" ,html);
	}
	
	public FormLabel() {
		this("");
	}
}
