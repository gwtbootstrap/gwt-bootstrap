package com.github.gwtbootstrap.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * @author: Carlos A Becker
 */
public class Icons extends Composite {
    interface IconsUiBinder extends UiBinder<HTMLPanel, Icons> {
    }

    private static IconsUiBinder ourUiBinder = GWT.create(IconsUiBinder.class);

    public Icons() {
        HTMLPanel rootElement = ourUiBinder.createAndBindUi(this);
        initWidget(rootElement);
    }
}