package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.IconAnchor;
import com.github.gwtbootstrap.client.ui.constants.Constants;

/**
 * Dropdown's Submenu
 * 
 * @since 2.1.1.0
 * @author ohashi keisuke
 *
 */
public class DropdownSubmenu extends Dropdown {

    /**
     * Create a Empty widget.
     */
    public DropdownSubmenu() {
        this("");
    }

    /**
     * Creates an empty DropdownSubmenu with the given caption.
     * 
     * @param caption
     *            the dropdown's caption
     */
    public DropdownSubmenu(String caption) {
        super(caption);
        setStyleName(Constants.DROPDOWN_SUBMENU);
    }
    
    /**
     * {@inheritDoc}
     * Create Trigger without caret
     */
    @Override
    protected IconAnchor createTrigger() {
        final IconAnchor trigger = new IconAnchor();
        return trigger;
    }
    
}
