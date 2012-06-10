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


/**
 * HelpBlock is a form help text widget.
 * <p>
 * HelpBlock can include html and widget
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:HelpBlock>
 * 	HelpBlock can include html and widgets<br/>
 * 	<b:Code>text</b:Code>
 * 	<a href="#">a</a>
 * </b:HelpBlock>
 * }
 * </pre>
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author ohashi keisuke 
 * 
 * @see Controls
 * @see HelpInline
 * @see <a href="http://twitter.github.com/bootstrap/base-css.html#forms">Bootstrap documentation</a>
 */
public class HelpBlock extends Paragraph {

	/**
	 * Creates an empty widget.
	 */
	public HelpBlock() {
		this("");
	}
	
	/**
	 * Creates a widget with  the html set..
	 * @param html content html
	 */
	public HelpBlock(String html) {
		super(html);
		setStyleName(Constants.HELP_BLOCK);
	}
}
