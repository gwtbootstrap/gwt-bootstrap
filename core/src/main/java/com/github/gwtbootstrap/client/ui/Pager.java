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

import com.github.gwtbootstrap.client.ui.base.UnorderedList;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.uibinder.client.UiConstructor;

//@formatter:off
/**
 * Pager that can be aligned
 * 
 * @since 2.0.4.0
 * @author Dominik Mayer
 */
//@formatter:on
public class Pager extends UnorderedList {

	private NavLink leftLink = new NavLink();

	private NavLink rightLink = new NavLink();

//	private boolean arrows;

	public @UiConstructor
	Pager(String left, String right) {
		setStyleName(Bootstrap.pager);
		leftLink.setText(left);
		rightLink.setText(right);
		add(leftLink);
		add(rightLink);
	}

	public void setAligned(boolean aligned) {
        leftLink.setStyleName(Constants.PREVIOUS);
		rightLink.setStyleName(Bootstrap.next);
	}

	public NavLink getLeft() {
		return leftLink;
	}

	public NavLink getRight() {
		return rightLink;
	}

	public void setArrows(boolean hasArrows) {
		// TODO
	}
}
