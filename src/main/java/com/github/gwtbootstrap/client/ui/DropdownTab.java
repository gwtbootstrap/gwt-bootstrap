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
