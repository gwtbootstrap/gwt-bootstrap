package com.github.gwtbootstrap.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.text.client.LongParser;
import com.google.gwt.text.client.LongRenderer;

/**
 * A ValueBox that uses {@link LongParser} and {@link LongRenderer}. for Bootstrap
 * 
 * @since 2.0.3.0
 * @author ohashi keisuke
 */
public class LongBox extends ValueBox<Long> {
	
	/**
	 * Create Empty widgets
	 */
	public LongBox() {
		super(Document.get().createTextInputElement(),LongRenderer.instance(), LongParser.instance());
	}
}
