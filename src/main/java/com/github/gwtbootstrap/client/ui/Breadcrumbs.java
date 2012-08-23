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

import com.github.gwtbootstrap.client.ui.base.ComplexWidget;
import com.github.gwtbootstrap.client.ui.base.ListItem;
import com.github.gwtbootstrap.client.ui.base.UnorderedList;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.dom.client.Document;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

/**
 * The Breadcrumbs container
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <p/>
 * <pre>
 * {@code
 * <!-- Breadcrumbs always needs divider attribute -->
 * <b:Breadcrumbs divider="">
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

    private Widget lastWidget = null;
    
    private String divider;
    
    private boolean change2Text;

    private static class Divider extends ComplexWidget {

        public Divider(String divider) {
            super("span");
            setStyleName(Constants.DIVIDER);
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
    public @UiConstructor Breadcrumbs(String divider) {
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
    }
    
    @Override
    protected void onAttach() {
        
        if(lastWidget != null && !change2Text) {
            remove(lastWidget);
            
            super.add(change2TextListItem(lastWidget));
            
            change2Text = true;
        }
        
        super.onAttach();
    }

    @Override
    public void add(Widget w) {
        
        w.removeStyleName(Constants.ACTIVE);
        
        if(!isAttached()) {
            if(w instanceof NavWidget) {
                ((NavWidget) w).addWidget(new Divider(divider));
                super.add(w);
            } else if(w instanceof ListItem) {
                ((ListItem) w).add(new Divider(divider));
                super.add(w);
            } else {
                super.add(new ListItem(w , new Divider(divider)));
            }
            
            lastWidget = w;
            
            return;
        }
        
        // remove last widget and re-add last widget
        if (lastWidget != null) {
            remove(getWidgetCount() - 1);
            
            ListItem item = null;
            if(lastWidget instanceof ListItem) {
                item = (ListItem)lastWidget;
            } else {
                item = new ListItem(lastWidget, new Divider(divider));
            }
            
            super.add(item);
        }
        
        ListItem newest = change2TextListItem(w);
        
        super.add(newest);
        
        lastWidget = newest;
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

}