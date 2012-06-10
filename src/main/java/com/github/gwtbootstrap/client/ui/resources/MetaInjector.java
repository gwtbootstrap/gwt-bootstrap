/*
 *  Copyright 2012 GWT-Bootstrap
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.gwtbootstrap.client.ui.resources;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.MetaElement;

/**
 * Methods to put a meta tag into the document header.
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 */
public class MetaInjector extends AbstractInjector {

	/**
	 * Puts a meta tag with the given name and content into the document header.
	 * 
	 * @param name
	 *            the value of the {@code name} attribute.
	 * @param content
	 *            the value of the {@code content} attribute.
	 */
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
