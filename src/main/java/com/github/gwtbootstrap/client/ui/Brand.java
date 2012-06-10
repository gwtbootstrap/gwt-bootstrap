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

import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.user.client.ui.Anchor;

//@formatter:off
/**
 * Navbar widget that shows text in a large font.
 * 
 * <p>
 * Usually used for the name of the website or brand.
 * </p>
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code <b:Brand>GWT-Bootstrap</b:Brand>}
 * </pre>
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#navbar">Bootstrap documentation</a> 
 * @see Navbar
 */
//@formatter.on
public class Brand extends Anchor {
	
	/**
	 * Creates an empty widget.
	 */
	public Brand() {
		setStyleName(Constants.BRAND);
		addStyleName(Constants.ACTIVE);
//		setHref(Constants.EMPTY_HREF);
	}
	
	/**
	 * Creates a widget with the text set.
	 * 
	 * @param text name of the brand or project
	 */
	public Brand(String text) {
		this();
		setText(text);
	}
}
