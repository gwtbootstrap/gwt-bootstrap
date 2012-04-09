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

import com.github.gwtbootstrap.client.ui.base.HasType;
import com.github.gwtbootstrap.client.ui.base.HtmlWidget;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.ControlGroupType;

public class ControlGroup extends HtmlWidget implements HasType<ControlGroupType> {

	public ControlGroup(String html) {
		super("div", html);
		setStyleName(Constants.CONTROL_GROUP);
	}

	public ControlGroup() {
		this("");
	}
	
	public void setType(ControlGroupType type) {
		for (ControlGroupType t : ControlGroupType.values())
			removeStyle(t);
		addStyle(type);
	}
}
