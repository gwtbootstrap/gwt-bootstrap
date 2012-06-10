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
import com.google.gwt.dom.client.ScriptElement;

/**
 * Methods to inject JavaScript code into the document header.
 * 
 * @since 2.0.4.0
 * 
 * @author Carlos Alexandro Becker
 */
public class JavaScriptInjector extends AbstractInjector {

	/**
	 * Injects the JavaScript code into a
	 * {@code <script type="text/javascript">...</script>} element in the
	 * document header.
	 * 
	 * @param javascript
	 *            the JavaScript code
	 */
	public static void inject(String javascript) {
		HeadElement head = getHead();
		ScriptElement element = createScriptElement();
		element.setText(javascript);
		head.appendChild(element);
	}

	private static ScriptElement createScriptElement() {
		ScriptElement script = Document.get().createScriptElement();
		script.setAttribute("type", "text/javascript");
        script.setAttribute("charset", "UTF-8");
		return script;
	}

}
