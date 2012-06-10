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

import com.github.gwtbootstrap.client.ui.Alert;
import com.github.gwtbootstrap.client.ui.AlertBlock;
import com.github.gwtbootstrap.client.ui.base.Style;

//@formatter:off
/**
* Type of an {@link Alert} or {@link AlertBlock}.
* 
* @since 2.0.4.0
* 
* @author Dominik Mayer
* @author Carlos A Becker
* 
* @see <a href="http://twitter.github.com/bootstrap/components.html#alerts">Bootstrap documentation</a>
* 
*/
//@formatter:on
public enum AlertType implements Style {

	DEFAULT(""), ERROR("error"), SUCCESS("success"), INFO("info"), WARNING("");

	private String className;

	private AlertType(String className) {
		this.className = className;
	}

	/**
	 * {@inheritDoc}
	 */
	public String get() {
		if (className.isEmpty())
			return className;
		else
			return Constants.ALERT + "-" + className;
	}

	/**
	 * Get style name without prefix.
	 * @return non-prefix style name
	 */
	public String getWithoutPrefix() {
		return className;
	}
}
