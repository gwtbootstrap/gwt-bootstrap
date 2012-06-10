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
package com.github.gwtbootstrap.client.ui.constants;

import com.github.gwtbootstrap.client.ui.Close;
import com.github.gwtbootstrap.client.ui.base.Style;

//@formatter:off
/**
* Default dismiss types of a {@link Close}.
* <p>
* Bootstraps provides a default functionality to close the widgets listed here. 
* 
* @since 2.0.4.0
* 
* @author Dominik Mayer
* 
* @see <a href="http://twitter.github.com/bootstrap/components.html#misc">Bootstrap documentation</a>
* 
*/
//@formatter:on
public enum DismissType implements Style {

	ALERT("alert"), MODAL("modal");

	private String className;

	private DismissType(String className) {
		this.className = className;
	}

	/**
	 * {@inheritDoc}
	 */
	public String get() {
		return className;
	}
}
