package com.github.gwtbootstrap.client.ui.resources;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.MetaElement;


public class MetaInjector extends AbstractInjector {

	public static void inject(String name, String content) {
		HeadElement head = getHead();
		MetaElement element = createMetaElement();
		element.setName(name);
		element.setContent(content);
		head.appendChild(element);
	}

	private static MetaElement createMetaElement() {
		return Document.get().createMetaElement();
	}
}
