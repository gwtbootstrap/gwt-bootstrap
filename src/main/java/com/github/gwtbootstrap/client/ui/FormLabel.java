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
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HtmlWidget;
import com.google.gwt.dom.client.LabelElement;


/**
 * Simple wrapper for an HTML {@code <label>} tag.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:FormLabel>
 * 	FormLabel can include html and widgets<br/>
 * 	<b:Code>code</b:Code>
 * 	<a href="#"></a>
 * </b:FormLabel>
 * }
 * </pre>
 * </p>
 *
 * @since 2.0.4.0
 * 
 * @author ohashi keisuke
 * 
 * @see <a href="http://twitter.github.com/bootstrap/base-css.html#forms">Bootstrap documentation</a>
 */
public class FormLabel extends HtmlWidget {

	/**
	 * Creates a widget with  the html set..
	 * @param html content html
	 */
	public FormLabel(String html) {
		super("label" ,html);
	}
	
	/**
	 * Creates an empty widget.
	 */
	public FormLabel() {
		this("");
	}
	
	/**
	 * Set <code>for</code> attribute.
	 * @param id set attribute value
	 */
	public void setFor(String id) {
		getLabelElement().setHtmlFor(id);
	}
	
	/**
	 * Get <code>for</code> attribute
	 * @return for attribute value
	 */
	public String getFor() {
		return getLabelElement().getHtmlFor();
	}
	
	protected LabelElement getLabelElement() {
		return getElement().cast();
	}

}
