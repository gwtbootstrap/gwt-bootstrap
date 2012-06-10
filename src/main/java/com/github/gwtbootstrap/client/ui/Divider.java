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
 * Horizontal divider for navigation menus.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:NavList>
 *     <b:NavLink>Link before divider</b:NavLink>
 *     <b:Divider />
 *     <b:NavLink>Link after divider</b:NavLink>
 * </b:NavList>
 * }
 * </pre>
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#navs">Bootstrap documentation</a>
 * @see NavList
 * @see WellNavList
 * @see Dropdown
 * @see VerticalDivider
 */
//@formatter:on
public class Divider extends ListItem {

	/**
	 * Creates a new Divider.
	 */
	public Divider() {
		setStyleName(Constants.DIVIDER);
	}
}
