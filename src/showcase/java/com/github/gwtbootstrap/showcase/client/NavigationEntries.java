package com.github.gwtbootstrap.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class NavigationEntries extends Composite {

    private static NavigationEntriesUiBinder uiBinder = GWT.create(NavigationEntriesUiBinder.class);

    interface NavigationEntriesUiBinder extends UiBinder<Widget, NavigationEntries> {
    }

    public NavigationEntries() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
