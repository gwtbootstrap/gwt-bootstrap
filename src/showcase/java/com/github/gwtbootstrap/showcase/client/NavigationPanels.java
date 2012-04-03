package com.github.gwtbootstrap.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class NavigationPanels extends Composite {

    private static NavigationPanelsUiBinder uiBinder = GWT.create(NavigationPanelsUiBinder.class);

    interface NavigationPanelsUiBinder extends UiBinder<Widget, NavigationPanels> {
    }

    public NavigationPanels() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
