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

import com.github.gwtbootstrap.client.ui.base.InlineLabel;
import com.github.gwtbootstrap.client.ui.constants.Constants;

/**
 * HelpInline is a form help text widget.
 * <p>
 * HelpInline can include text only.
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:HelpInline>any text</b:HelpInline>
 * }
 * </pre>
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author ohashi keisuke 
 * 
 * @see Controls
 * @see HelpBlock
 * @see <a href="http://twitter.github.com/bootstrap/base-css.html#forms">Bootstrap documentation</a>
 */
public class HelpInline extends InlineLabel {

	/**
	 * Creates an empty widget.
	 */
	public HelpInline() {
		super();
		setStyleName(Constants.HELP_INLINE);
	}
}
