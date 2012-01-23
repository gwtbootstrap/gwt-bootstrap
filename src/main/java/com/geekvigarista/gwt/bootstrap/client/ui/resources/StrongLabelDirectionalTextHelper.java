package com.geekvigarista.gwt.bootstrap.client.ui.resources;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

/**
 * A DirectionalTextHelper to help us to set text in STRONG labels.
 * 
 * @author Carlos Alexandro Becker
 * @since 23/01/2012
 */
public class StrongLabelDirectionalTextHelper {

	private Element element;

	public StrongLabelDirectionalTextHelper(Element element) {
		this.element = element;
	}

	public void setTextOrHtml(String content) {
		Element el = Document.get().createElement("strong");
		el.setInnerHTML(content);
		element.setInnerHTML("");
		element.appendChild(el);
	}

}
