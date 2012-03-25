package com.github.gwtbootstrap.client.ui.resources;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadElement;

/**
 * 
 * @author Carlos Alexandro Becker
 * @author Dominik Mayer
 */
public abstract class AbstractInjector {

	private static HeadElement head;

	protected static HeadElement getHead() {
		if (head == null) {
			Element element = Document.get().getElementsByTagName("head")
					.getItem(0);
			assert element != null : "HTML Head element required";
			HeadElement head = HeadElement.as(element);
			AbstractInjector.head = head;
		}
		return AbstractInjector.head;
	}
}
