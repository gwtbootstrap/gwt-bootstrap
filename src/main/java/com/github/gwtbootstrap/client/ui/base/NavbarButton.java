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
package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.Navbar;
import com.github.gwtbootstrap.client.ui.ResponsiveNavbar;
import com.github.gwtbootstrap.client.ui.constants.NavbarConstants;

//@formatter:off
/**
 * {@link Button} that can be used in a {@link Navbar}.
 * <p>
 * It is not visible by default and only used as the toggle Button of a 
 * {@link ResponsiveNavbar}.
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 */
//@formatter:on
public class NavbarButton extends Button {

	/**
	 * Creates an empty widget.
	 */
	public NavbarButton() {
		addStyleName(NavbarConstants.NAVBAR_BUTTON);
//		getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
//		addStyleName(ButtonType.PRIMARY.get());
	}

	/**
	 * Creates a Button with the given caption.
	 * 
	 * @param caption
	 *            the caption of the Button
	 */
	public NavbarButton(String caption) {
		super(caption);
		addStyleName(NavbarConstants.NAVBAR_BUTTON);
//		getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
	}
}
