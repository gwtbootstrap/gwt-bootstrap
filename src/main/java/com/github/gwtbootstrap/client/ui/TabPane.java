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
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.DOM;

//@formatter:off
/**
 * Tab Pane for tabbable nav.
 * 
 * @since 2.0.4.0
 * @author Dominik Mayer
 */
//@formatter:on
public class TabPane extends DivWidget {

	private String heading;

	private String href;

    private boolean createTabLink = true;
	
	public TabPane() {
	    this("");
	}
	
	public TabPane(String heading) {
		setStyleName(Bootstrap.tab_pane);
		this.heading = heading;
		createHref();
	}
	
	public void setCreateTabLink(boolean createTabLink) {
        this.createTabLink = createTabLink;
	}
	
	public boolean isCreateTabLink() {
	    return this.createTabLink;
	}

	private void createHref() {
		setHref(DOM.createUniqueId());
	}

	public void setHref(String href) {
		this.href = href;
		getElement().setId(href);
	}

	public void setActive(boolean active) {
		
		if (active) {
			addStyleName(Constants.ACTIVE);
		} else {
			removeStyleName(Constants.ACTIVE);
		}
	}
	

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getId() {
		return href;
	}

	public boolean isActive() {
		return getStyleName().contains(Constants.ACTIVE);
	}
}
