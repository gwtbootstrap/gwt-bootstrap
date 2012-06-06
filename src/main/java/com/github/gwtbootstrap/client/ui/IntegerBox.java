package com.github.gwtbootstrap.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.text.client.IntegerParser;
import com.google.gwt.text.client.IntegerRenderer;

/**
 * A ValueBox that uses {@link IntegerParser} and {@link IntegerRenderer}. for Bootstrap
 * 
 * @since 2.0.3.0
 * @author ohashi keisuke
 */
public class IntegerBox extends ValueBox<Integer> {

	/**
	 * Create Empty widgets
	 */
	public IntegerBox() {
		super(Document.get().createTextInputElement(), IntegerRenderer.instance(), IntegerParser.instance());
	}
}
