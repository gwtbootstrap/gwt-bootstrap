package com.github.gwtbootstrap.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Support extends Composite {

    private static GetStartedUiBinder uiBinder = GWT.create(GetStartedUiBinder.class);

    interface GetStartedUiBinder extends UiBinder<Widget, Support> {
    }

    public Support() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
