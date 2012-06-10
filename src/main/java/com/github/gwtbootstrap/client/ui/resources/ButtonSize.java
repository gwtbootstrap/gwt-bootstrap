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

import com.github.gwtbootstrap.client.ui.base.Style;
import com.github.gwtbootstrap.client.ui.constants.Constants;

//@formatter:off
/**
* Size of a {@link com.github.gwtbootstrap.client.ui.Button Button.}
* 
* @since 2.0.4.0
* 
* @author Dominik Mayer
* 
* @see <a href="http://twitter.github.com/bootstrap/base-css.html#buttons">Bootstrap documentation</a>
* 
*/
//@formatter:on
public enum ButtonSize implements Style {

	DEFAULT(""), LARGE("large"), SMALL("small"), MINI("mini");

	private String className;

	private ButtonSize(String className) {
		this.className = className;
	}

	public String get() {
		if (className.isEmpty())
			return className;
		else
			return Constants.BTN + "-" + className;
	}

	public String getWithoutPrefix() {
		return className;
	}
}