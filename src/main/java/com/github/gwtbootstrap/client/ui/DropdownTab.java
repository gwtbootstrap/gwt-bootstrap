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

import com.google.gwt.user.client.ui.IsWidget;

/**
 * DropdownTab for {@link TabPanel}
 * @author ohashi keisuke
 * @since 2.0.4.0
 *
 */
public class DropdownTab extends Dropdown {
    
    private List<Tab> tabList = new ArrayList<Tab>();
    
    /**
     * Create empty dropdownTab
     */
    public DropdownTab() {
        super();
    }
    
    /**
     * Create a dropdownTab with caption(tag text)
     * @param caption tag text
     */
    public DropdownTab(String caption) {
        super(caption);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void add(IsWidget child) {
        if (child instanceof Tab) {
            Tab tab = (Tab)child;
            getTabList().add(tab);
        }
        
        super.add(child);
    }

    /**
     * Get TabList
     * @return tabList tabList
     */
    public List<Tab> getTabList() {
        return tabList;
    }

}
