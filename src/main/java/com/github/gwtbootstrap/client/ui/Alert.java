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

import com.github.gwtbootstrap.client.ui.base.AlertBase;
import com.github.gwtbootstrap.client.ui.constants.AlertType;

/**
 * Simple Alert widget that uses bold text as a heading.
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <code>{@code <b:Alert heading="Warning." type="ERROR">Something went wrong...</b:Alert>}</code>
 * </p>
 * <p>
 * All parameters are optional and map to the class's setters.
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see AlertBlock
 * @see <a
 *      href="http://twitter.github.com/bootstrap/components.html#alerts">Bootstrap
 *      documentation</a>
 */
public class Alert extends AlertBase {

	
	public Alert() {
		super("");
	}
	
	public Alert(String html) {
		super(html);
	}

	/**
	 * @param html
	 * @param type
	 */
	public Alert(String html, AlertType type) {
		super(html);
		setType(type);
	}

	/**
	 * @param html
	 * @param hasClose
	 */
	public Alert(String html, AlertType type, boolean hasClose) {
		super(html, hasClose);
		setType(type);
	}
	
	/**
	 * Sets the text of an optional heading. It is wrapped in {@code <strong>}
	 * tags and placed before the text.
	 */
	@Override
	public void setHeading(String text) {
		if (text == null || text.isEmpty())
			super.setHeading("");
		else
			super.setHeading("<strong>" + text + "</strong> ");
	}
}
