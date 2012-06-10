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

import com.github.gwtbootstrap.client.ui.Form;
import com.github.gwtbootstrap.client.ui.base.Style;

//@formatter:off
/**
* Type of a {@link Form}.
* 
* @since 2.0.4.0
* 
* @author Dominik Mayer
* 
* @see <a href="http://twitter.github.com/bootstrap/base-css.html#forms">Bootstrap documentation</a>
* 
*/
//@formatter:on
public enum FormType implements Style {

	VERTICAL("vertical"),

	INLINE("inline"),

	SEARCH("search"),

	HORIZONTAL("horizontal");

	private static final String PREFIX = "form-";

	private String className;

	private FormType(String className) {
		this.className = PREFIX + className;
	}

	/**
	 * {@inheritDoc}
	 */
	public String get() {
		return className;
	}

}
