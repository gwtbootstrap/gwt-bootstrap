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

import com.github.gwtbootstrap.client.ui.base.ListItem;
import com.github.gwtbootstrap.client.ui.constants.Constants;

//@formatter:off
/**
 * Vertical divider for the Navbar.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:Navbar>
 *     <b:Nav>
 *         <b:NavLink>Link before the divider</b:NavLink>
 *         <b:VerticalDivider />
 *         <b:NavLink>Link after the divider</b:NavLink>
 *     </b:Nav>
 * </b:Navbar>
 * }
 * </pre>
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#navbar">Bootstrap documentation</a>
 * @see Navbar
 * @see Divider
 */
//@formatter:on
public class VerticalDivider extends ListItem {

	/**
	 * Creates a new vertical divider.
	 */
	public VerticalDivider() {
		setStyleName(Constants.DIVIDER_VERTICAL);
	}
}
