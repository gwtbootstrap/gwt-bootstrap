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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off
/**
 * The container for a tabbable nav.
 * 
 * @since 2.0.4.0
 * @author Dominik Mayer
 * @author ohashi keisuke
 */
//@formatter:on
public class TabPanel extends DivWidget {

    private static class TabContent extends DivWidget {

        public TabContent() {
            setStyleName(Bootstrap.tab_content);
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

        if (child instanceof TabPane) {
            add((TabPane) child);
            return;
        }

        if (child instanceof TabLink) {
            add((TabLink) child);
            return;
        }
        throw new IllegalArgumentException("TabPanel can add"
                + "only TabPane or TabLink");
    }

    private void add(TabPane child) {

        TabLink tabLink = new TabLink(child);
        tabs.add(tabLink);
        tabContent.add(child);
    }
    
    private void add(TabLink child) {
        
        TabPane pane = new TabPane(child.getText());
        
        pane.setHref(DOM.createUniqueId());
        
        child.setTablePane(pane);
        
        tabs.add(child);
        tabContent.add(pane);
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        for (int i = 0; i < tabs.getWidgetCount(); i++) {

            Widget widget = tabs.getWidget(i);

            if (widget instanceof TabLink) {
                TabLink tabLink = (TabLink) widget;

                if (tabLink.isActive()) {
                    tabLink.show();
                    break;
                }
            }
        }
    }
}
