package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author carlos
 */
public class ButtonGroup extends DivWidget {
    
    {
        setStyleName("btn-group");
    }
    
    public ButtonGroup() {
    	// Needed for UiBinder
    }
    
    public ButtonGroup(Button... buttons) {
        super();
        for (Button btn : buttons) {
            add(btn);
        }
    }

    @Override
    public void add(Widget w) {
    	if (!(w instanceof Button))
    		throw new IllegalArgumentException("A ButtonGroup can only contain Buttons.");
    	
        super.add(w);
    }
}
