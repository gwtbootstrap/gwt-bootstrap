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

import java.util.Iterator;

import com.github.gwtbootstrap.client.ui.base.HasIcon;
import com.github.gwtbootstrap.client.ui.base.HasStyle;
import com.github.gwtbootstrap.client.ui.base.IsResponsive;
import com.github.gwtbootstrap.client.ui.base.Style;
import com.github.gwtbootstrap.client.ui.constants.*;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * The tab widget for {@link TabPanel}.
 * 
 * <p>
 * It's for UiBinder.
 * Tab class provide easy syntax on UiBinder.
 * </p>
 * Example:
 * <pre>
 * {@code
 * <b:TabPanel>
 *  <b:Tab heading="Typically">
 *    <b:Heading size="3">Typically Tab</b:Heading>
 *    <b:Paragraph>
 *        huhuhu hahha
 *    </b:Paragraph>
 *  </b:Tab>
 *  <b:Tab heading="Custom">
 *    <b:customTab>
 *      <b:Image resources="{res.logo}"/>
 *    </b:customTab>
 *    <b:Heading size="3">CustomTab Tab</b:Heading>
 *  </b:Tab>
 * </b:TabPanel>
 * }
 * </pre>
 * }
 * 
 * </pre>
 * @since 2.0.4.0
 * @author ohashi keisuke
 */
public class Tab implements IsWidget, HasWidgets, HasClickHandlers, HasStyle, IsResponsive,HasIcon {
    
    TabLink link = new TabLink();

    /**
     * Create tmpy tab
     */
    public Tab() {
        TabPane tabPane = new TabPane();
        
        tabPane.setHref(DOM.createUniqueId());
        
        link.setTablePane(tabPane);
    }
    
    /**
     * Tab as a TabLink
     */
    @Override
    public Widget asWidget() {
        return link;
    }
    
    /**
     * Get Container TabPane
     * @return TabPane
     */
    protected TabPane getTabPane() {
        return link.getTabPane();
    }
    
    /**
     * Return TabLink
     * @return tabLink
     */
    public TabLink asTabLink() {
        return link;
    }
    
    /**
     * Set tab active
     * @param active
     */
    public void setActive(boolean active) {
        link.setActive(active);
    }
    
    /**
     * has active style name
     * @return true:active false:deactive
     */
    public boolean isActive() {
        return link.isActive();
    }
    
    /**
     * Set tab text
     * @param text tab text
     */
    public void setHeading(String text) {
        link.setText(text);
    }
    
    /**
     * Get Tab text
     * @return tab text
     */
    public String getHeading() {
        return link.getText();
    }
    
    /**
     * Add widget to tab pane.
     */
    @Override
    public void add(Widget w) {
        link.getTabPane().add(w);
    }

    /**
     * Clear tab pane children
     */
    @Override
    public void clear() {
        link.getTabPane().clear();
    }

    /**
     * call {@link TabPane#iterator()}
     */
    @Override
    public Iterator<Widget> iterator() {
        return link.getTabPane().iterator();
    }

    /**
     * call {@link TabPane#remove(Widget)}
     * 
     * @return {@link TabPane#remove(Widget)} result
     */
    @Override
    public boolean remove(Widget w) {
        return link.getTabPane().remove(w);
    }

    /**
     * add ClickEventHandler to TabLink
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addClickHandler(ClickHandler handler) {
        return link.addClickHandler(handler);
    }

    /**
     * set TabLink icon type.
     * {@inheritDoc}
     */
    @Override
    public void setIcon(IconType type) {
        setBaseIcon(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBaseIcon(BaseIconType type) {
        this.link.setBaseIcon(type);
    }

    /**
     * Set TabLink icon size
     * {@inheritDoc}
     */
    @Override
    public void setIconSize(IconSize size) {
        link.setIconSize(size);
    }

    /**
     * Set TabLink and TabPane show on device.
     * {@inheritDoc}
     */
    @Override
    public void setShowOn(Device device) {
        link.setShowOn(device);
        link.getTabPane().setShowOn(device);
    }

    /**
     * Set TabLink and TabPane show on device.
     * {@inheritDoc}
     */
    @Override
    public void setHideOn(Device device) {
        link.setHideOn(device);
        link.getTabPane().setHideOn(device);
    }

    /**
     * set TabLink style
     * {@inheritDoc}
     */
    @Override
    public void setStyle(Style style) {
        link.setStyle(style);
    }

    /**
     * add TabLink style
     * {@inheritDoc}
     */
    @Override
    public void addStyle(Style style) {
        link.addStyle(style);
    }

    /**
     * remove TabLink style
     * {@inheritDoc}
     */
    @Override
    public void removeStyle(Style style) {
        link.removeStyle(style);
    }

    /**
     * fire TabLink event
     * {@inheritDoc}
     */
    @Override
    public void fireEvent(GwtEvent<?> event) {
        link.fireEvent(event);
    }
    
    @UiChild(limit=1,tagname="customTab")
    public void addDecorate(Widget w) {
        link.add(w);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCustomIconStyle(String customIconStyle) {
        link.setCustomIconStyle(customIconStyle);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconPosition(IconPosition position) {
        link.setIconPosition(position);
    }
}
