package com.geekvigarista.gwt.bootstrap.client.ui.resources;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class BootstrapElementHelper {
	public Element createCloseLinkElement() {
		Element a = Document.get().createElement("a");
		a.setAttribute("href", "#");
		a.setClassName("close"); // FIXME import to cssresources.
		a.setInnerText("x");
		return a;
	}

	public Element createDivWithCloseLink() {
		Element e = Document.get().createDivElement();
		e.appendChild(createCloseLinkElement());
		return e;
	}
}
