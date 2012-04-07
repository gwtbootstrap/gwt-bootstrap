package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.constants.Constants;


public class HelpBlock extends Paragraph {

	public HelpBlock() {
		this("");
	}
	
	public HelpBlock(String html) {
		super(html);
		setStyleName(Constants.HELP_BLOCK);
	}
}
