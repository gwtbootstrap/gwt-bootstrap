package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author carlos
 */
public class ButtonToolbar extends DivWidget {
    {
        setStyleName("btn-toolbar");
    }

    public ButtonToolbar() {
    }

    @Override
    public void add(Widget child) {
    	
    	Widget widget = child;
    	
    	if (!(child instanceof ButtonGroup) && !(child instanceof Button))
    		throw new IllegalArgumentException("A ButtonToolbar can only contain ButtonGroups and Buttons.");

    	if (child instanceof Button)
    		widget = new ButtonGroup((Button) child);
    	
        super.add(widget);
    }
    
    
}
