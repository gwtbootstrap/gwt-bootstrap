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
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.DOM;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.HasEnabled;

/**
 * The TabLink for {@link TabPanel}
 * @author ohashi keisuke
 *
 */
public class TabLink extends NavWidget implements HasEnabled {

    private TabPane pane;
    private boolean createTabPane = true;
    private boolean enabled;

    /**
     * Create widget with set Effective TabPane 
     * @param pane effective tabPane
     */
    public TabLink(TabPane pane) {
        this();
        setText(pane.getHeading());
        setTabPane(pane);
    }

    /**
     * Create empty widget
     */
    public TabLink() {
        super();
        enabled = true;
        getAnchor().getElement().setAttribute(Constants.DATA_TOGGLE, "tab");
    }

    /**
     * Returns true if the widget is enabled, false if not.
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets whether this widget is enabled.
     *
     * @param enabled <code>true</code> to enable the widget, <code>false</code>
     *                to disable it
     */
    @Override
    public void setEnabled(boolean enabled) {
        if (enabled && !this.enabled) {
            this.enabled = true;
            getAnchor().getElement().setAttribute(Constants.DATA_TOGGLE, "tab");
            removeStyleName(Constants.DISABLED);
        } else if (!enabled && this.enabled) {
            this.enabled = false;
            getAnchor().getElement().removeAttribute(Constants.DATA_TOGGLE);
            addStyleName(Constants.DISABLED);
        }
    }

    public void setCreateTabPane(boolean createTabPane) {
        this.createTabPane = createTabPane;
    }
    
    public boolean isCreateTabPane() {
        return this.createTabPane;
    }

    /**
     * Set Effective TabPane
     * @param pane
     */
    public void setTabPane(TabPane pane) {
        this.pane = pane;
        
        if(pane.getId() == null || pane.getId().isEmpty()) {
            pane.setHref(DOM.createUniqueId());
        }

        setDataTarget(pane.getId());
        
        this.setActive(pane.isActive());
    }
    
    public void setDataTarget(String id) {
        getAnchor().getElement().setAttribute(Constants.DATA_TARGET,"#" + id);
    }
    
    /**
     * Get Effective TabPane
     * @return effective TabPane
     */
    public TabPane getTabPane() {
        return pane;
    }
    
    @Override
    protected void onAttach() {
        super.onAttach();
        
        if(isActive()) {
            show();
        }
    }
    
    @Override
    public void setActive(boolean active) {
        super.setActive(active);
        
        if(pane != null) {
            pane.setActive(active);
        }
        
    }
    
    /**
     * show tab pane
     */
    public void show() {
        if(isOrWasAttached()) {
            show(getAnchor().getElement());
            return;
        }
        
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
            
            @Override
            public void execute() {
                show(getAnchor().getElement());
            }
        });
    }

    //@formatter:off
    private native void show(Element e)/*-{
        $wnd.jQuery(e).tab('show');
    }-*/;
    //@formatter:on

}