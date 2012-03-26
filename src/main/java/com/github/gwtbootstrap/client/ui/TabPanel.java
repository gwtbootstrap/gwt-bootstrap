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

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.base.IconAnchor;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.ui.Widget;

/**
 * The container for a tabbable nav.
 * 
 * @author Dominik Mayer
 */
public class TabPanel extends DivWidget {
	
	private static class TabContent extends DivWidget {
		
		public TabContent() {
			setStyleName(Bootstrap.tab_content);
		}
	}
	
	private static class TabLink extends NavLink {
		
		public TabLink(TabPane pane) {
			super(pane.getHeading(), "#" + pane.getId());
			
			IconAnchor anchor = getAnchor(); 
			anchor.getElement().setAttribute(Bootstrap.data_toggle, "tab");
			
			if (pane.isActive())
				addStyleName(Bootstrap.active);
		}
	}
	
	private NavTabs tabs = new NavTabs();
	
	private TabContent tabContent = new TabContent();
	
	public TabPanel() {
		this(Bootstrap.Tabs.ABOVE);
	}
	
	public TabPanel(Bootstrap.Tabs position) {		
		setStyle(position);
		super.add(tabs);
		super.add(tabContent);
	}
	
	public void setTabPosition(String position) {
		if (position.equalsIgnoreCase("below"))
			setStyle(Bootstrap.Tabs.BELOW);
		else if (position.equalsIgnoreCase("left"))
			setStyle(Bootstrap.Tabs.LEFT);
		else if (position.equalsIgnoreCase("right"))
			setStyle(Bootstrap.Tabs.RIGHT);
		else
			setStyle(Bootstrap.Tabs.ABOVE);
	}
	
	@Override
	public void add(Widget child) {
		
		if (!(child instanceof TabPane))
			throw new IllegalArgumentException("Only Tab Panes can be added" +
					"to a TabPanel");
		
		add((TabPane) child);
	}
	
	private void add(TabPane child) {
		
		TabLink tabLink = new TabLink(child);
		tabs.add(tabLink);
		tabContent.add(child);
	}
}
