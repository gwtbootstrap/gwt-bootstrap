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

import com.github.gwtbootstrap.client.ui.base.HasType;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.DismissType;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.ui.Anchor;

//@formatter:off
/**
 * Icon ("&times;") that indicates that something can be closed.
 * 
 * @since 2.0.2.0
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#misc">Bootstrap documentation</a>
 * @see Alert
 * @see AlertBlock
 * @see Modal
 */
//@formatter:on
public class Close extends Anchor implements HasType<DismissType> {

	public Close() {
		setStyleName(Bootstrap.close);
		setHTML(Constants.CLOSE_ICON);
	}

	public Close(DismissType dismiss) {
		this();
		setType(dismiss);
	}

	public void setType(DismissType dismiss) {
		getElement().setAttribute(Constants.DATA_DISMISS, dismiss.get());
	}

	public void setType(String type) {
		if (type.equalsIgnoreCase(DismissType.ALERT.get()))
			setType(DismissType.ALERT);
		else if (type.equalsIgnoreCase(DismissType.MODAL.get()))
			setType(DismissType.MODAL);
		else
			throw new IllegalArgumentException("A Close cannot be of type +\""
					+ type + "\"");
	}

}
