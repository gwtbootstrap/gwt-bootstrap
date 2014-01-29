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

import java.util.ArrayList;
import java.util.List;

import com.github.gwtbootstrap.client.ui.base.ComplexWidget;
import com.github.gwtbootstrap.client.ui.base.ListItem;
import com.github.gwtbootstrap.client.ui.base.UnorderedList;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetCollection;

/**
 * The Breadcrumbs container
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <p/>
 * <pre>
 * {@code
 * <b:Breadcrumbs>
 *  <b:NavLink>Home</b:NavLink>
 *  <b:NavLink>Accoount</b:NavLink>
 * </b:Breadcrumbs>
 * <b:Breadcrumbs divider=">">
 *  <b:NavLink>Home</b:NavLink>
 *  <b:NavLink>Accoount</b:NavLink>
 * </b:Breadcrumbs>
 * }
 * 
 * @since 2.0.4.0
 * @author Dominik Mayer
 * @author ohashi keisuke
 */
public class Breadcrumbs extends UnorderedList {

    private WidgetCollection children = new WidgetCollection(this);
    
    private List<Divider> dividerList = new ArrayList<Divider>();
    
    private String divider = "/";
    
    private static class Divider extends ComplexWidget {

        public Divider(String divider) {
            super("span");
            setStyleName(Constants.DIVIDER);
            setDivider(divider);
        }
        
        public void setDivider(String divider) {
            getElement().setInnerText(divider);
        }
    }
    
    
    /**
     * Create a empty Breadcrumbs
     */
    public Breadcrumbs() {
        setStyleName(Constants.BREADCRUMB);
    }
    
    /**
     * Create Breadcrumbs with widgets
     * @param widgets widgets
     */
    public Breadcrumbs(Widget ... widgets) {
        this();
        
        for (Widget widget : widgets) {
            this.add(widget);
        }
    }
    
    /**
     * Create Breadcrumbs with setting divider character
     * @param divider separate char (ex : ">")
     */
    public Breadcrumbs(String divider) {
        this();
        this.setDivider(divider);
    }
    
    /**
     * Set separater character
     * @param divider separater character
     */
    public void setDivider(String divider) {
        if(divider == null || divider.isEmpty()) {
            this.divider = "/";
        } else {
            this.divider = divider;
        }
        
        for (Divider dividerWidget : dividerList) {
            dividerWidget.setDivider(this.divider);
        }
        
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void onAttach() {
        
        if(!isOrWasAttached() && children.size() > 0) {
            
            Widget lastWidget = children.get(children.size() -1);
            
            for (Widget w : children) {
                ListItem item = lastWidget.equals(w)
                                ? change2TextListItem(w)
                                : getOrCreateListItem(w);
                super.add(item);
            }
        }
        
        super.onAttach();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Widget w) {
        
        w.removeStyleName(Constants.ACTIVE);
        
        if(!isOrWasAttached()) {
            
            children.add(w);
            
            return;
        }
        
        if(children.size() > 0) {
            //Change last widget 2 Link
            
            //pygical remove
            super.remove(getWidget(getWidgetCount() -1));
            
            ListItem item = getOrCreateListItem(children.get(children.size() -1));
            
            super.add(item);
        }
        
        ListItem newest = change2TextListItem(w);
        
        super.add(newest);
        
        children.add(w);
    }

    private ListItem getOrCreateListItem(Widget lastWidget) {
        ListItem item = null;

        Divider dividerWidget = new Divider(divider);
        if(lastWidget instanceof NavWidget) {
            NavWidget w = (NavWidget)lastWidget;
            
            if(hasDivier(w)) {
                
                return w;
            } else {
                dividerList.add(dividerWidget);
                w.addWidget(dividerWidget);
                return w;
            }
        } else if(lastWidget instanceof ListItem) {
            item = (ListItem)lastWidget;
        } else {
            item = new ListItem(lastWidget);
        }
        
        if(hasDivier(item)) {
            return item;
        }
        
        item.add(dividerWidget);
        dividerList.add(dividerWidget);
        
        return item;
    }

    private boolean hasDivier(ListItem item) {
        
        for(Widget w : item) {
            if(w instanceof Divider) {
                return true;
            }
        }
        return false;
    }

    private ListItem change2TextListItem(Widget w) {
        String text = null;
        
        if (w instanceof HasText) {
            text = ((HasText) w).getText();
        } else {
            text = w.getElement().getInnerText();
        }

        ListItem newest = new ListItem();
        newest.setStyleName(Constants.ACTIVE);
        newest.getElement().appendChild(Document.get().createTextNode(text));
        return newest;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Widget w) {
        
        if(!isOrWasAttached() && children.contains(w)) {
            children.remove(w);
            return true;
        }

        if(getWidgetIndex(w) < 0 && !children.contains(w)) {
            return false;
        }
        
        boolean isLastWidget = (children.indexOf(w) == children.size() -1) || (getWidgetIndex(w) == getWidgetCount() -1);
        
        if(getWidgetIndex(w) >= 0 && children.contains(w)) {
            children.remove(w);
            super.remove(w);
        } else if(getWidgetIndex(w) >= 0 && !children.contains(w)) {
            children.remove(getWidgetIndex(w));
            super.remove(w);
        } else if(getWidgetIndex(w) < 0 && children.contains(w)) {
            return remove(getWidget(children.indexOf(w)));
        } else {
            return false;
        }
        
        if(isLastWidget && getWidgetCount() > 0) {
            Widget l = getWidget(getWidgetCount() -1);
            super.remove(l);
            super.add(change2TextListItem(l));
        }
        
        return true;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        super.clear();
        children = new WidgetCollection(this);
        dividerList.clear();
    }
}