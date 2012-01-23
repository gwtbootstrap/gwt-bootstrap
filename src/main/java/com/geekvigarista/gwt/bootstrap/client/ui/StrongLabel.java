package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.StrongLabelDirectionalTextHelper;
import com.google.gwt.user.client.ui.Label;

/**
 * A Label with a <code>strong</code> around the text.
 * 
 * @author Carlos Alexandro Becker
 * @since 22/01/2012
 */
public class StrongLabel extends Label {

	private final StrongLabelDirectionalTextHelper helper;

	{
		helper = new StrongLabelDirectionalTextHelper(getElement());
	}

	public StrongLabel() {

	}

	public StrongLabel(String text) {
		setText(text);
	}

	@Override
	public void setText(String text) {
		assert text != null : "text should not be null";
		helper.setTextOrHtml(text);
	}

}
