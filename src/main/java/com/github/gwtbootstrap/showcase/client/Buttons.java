package com.github.gwtbootstrap.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Buttons extends Composite {

    private static ButtonsUiBinder uiBinder = GWT.create(ButtonsUiBinder.class);

    interface ButtonsUiBinder extends UiBinder<Widget, Buttons> {
    }

    public Buttons() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
