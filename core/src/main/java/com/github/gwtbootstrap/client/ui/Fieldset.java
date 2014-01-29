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

import com.github.gwtbootstrap.client.ui.base.ComplexWidget;

//@formatter:off
/**
 * Simple wrapper for an HTML {@code <fieldset>} tag.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:Fieldset>
 * 	<b:ControlGroup/>
 * </b:Fieldset>
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
//@formatter:on
public class Fieldset extends ComplexWidget {

	/**
	 * Creates an empty widget.
	 */
	public Fieldset() {
		super("fieldset");
	}
}
