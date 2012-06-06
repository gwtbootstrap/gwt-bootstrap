package com.github.gwtbootstrap.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.text.client.DoubleParser;
import com.google.gwt.text.client.DoubleRenderer;


/**
 * A ValueBox that uses {@link DobuleParser} and {@link DoubleRenderer}. for Bootstrap
 * 
 * @since 2.0.3.0
 * @author ohashi keisuke
 */
public class DoubleBox extends ValueBox<Double> {
	
	/**
	 * Create Empty widgets
	 */
	public DoubleBox() {
		super(Document.get().createTextInputElement(), DoubleRenderer.instance(), DoubleParser.instance());
	}
}
