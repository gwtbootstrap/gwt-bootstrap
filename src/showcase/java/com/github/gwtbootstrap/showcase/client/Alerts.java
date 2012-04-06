package com.github.gwtbootstrap.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Alerts extends Composite {

    private static AlertsUiBinder uiBinder = GWT.create(AlertsUiBinder.class);

    interface AlertsUiBinder extends UiBinder<Widget, Alerts> {
    }

    public Alerts() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
