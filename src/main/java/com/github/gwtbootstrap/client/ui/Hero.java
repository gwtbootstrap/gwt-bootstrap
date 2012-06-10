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

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;

//@formatter:off
/**
 * Special widget to promote something on a website.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:Hero>
 *     <b:Heading size="2">Hero Unit</b:Heading>
 *     <b:Paragraph>Some Text for the Hero Unit.</b:Paragraph>
 *     <b:Paragraph>More text.</b:Paragraph>
 * </b:Hero>
 * }
 * </pre>
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 *
 * @see <a href="http://twitter.github.com/bootstrap/components.html#typography">Bootstrap documentation</a>
 * @see Heading
 * @see Paragraph
 */
//@formatter:on
public class Hero extends DivWidget {

	/**
	 * Creates an empty widget.
	 */
	public Hero() {
		addStyleName(Bootstrap.hero_unit);
	}

}
