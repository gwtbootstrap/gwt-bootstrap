package com.geekvigarista.gwt.bootstrap.client.v2;

import com.geekvigarista.gwt.bootstrap.client.v2.base.DivWidget;
import com.google.gwt.user.client.ui.IsWidget;

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
    public void add(IsWidget child) {
        assert child instanceof ButtonGroup : "ButtonToolbar only accepts ButtonGroups.";
        super.add(child);
    }
    
    
}
