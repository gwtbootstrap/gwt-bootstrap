/*
 *  Copyright 2012 GWT Bootstrap
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

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;

/**
 * A Text in the Navbar.
 * 
 * @author Dominik Mayer
 */
public class NavText extends Paragraph {

	private Paragraph paragraph = new Paragraph();
	
	public NavText() {
		addStyleName(Bootstrap.navbar_text);
		addStyleName(Bootstrap.pull_left);
	}
	
	public NavText(String text) {
		this();
		paragraph.setText(text);
	}
	
	public void setAlignment(String alignment) {
		if (alignment.equalsIgnoreCase("left")) {
			removeStyleName(Bootstrap.pull_right);
			addStyleName(Bootstrap.pull_left);
		} else if (alignment.equalsIgnoreCase("right")) {
			removeStyleName(Bootstrap.pull_left);
			addStyleName(Bootstrap.pull_right);
		}
	}
}
