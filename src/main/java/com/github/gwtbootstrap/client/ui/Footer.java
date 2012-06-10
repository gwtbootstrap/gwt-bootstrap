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
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;

//@formatter:off
/**
 * Simple wrapper for an HTML {@code <footer>} tag.
 * <p>
 * Doesn't have any special formatting.
 * </p>
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code 
 * <b:Footer>
 *     <g:Label>Some text</g:Label>
 * </b:Footer>}
 * </pre>
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * @author ohashi keisuke
 */
//@formatter:on
public class Footer extends HtmlWidget {

	// TODO: No nice style in bootstrap. Delete?
	/**
	 * Creates an empty Footer.
	 */
	public Footer() {
		this("");
	}
	
	/**
	 * Creates a widget with the html.
	 * @param html content html
	 */
	public Footer(String html) {
		super("footer" , html);
		setStyleName(Bootstrap.footer);
	}

}
