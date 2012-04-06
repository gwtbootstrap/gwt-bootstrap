package com.github.gwtbootstrap.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ProgressBar extends Composite {

    private static ProgressBarUiBinder uiBinder = GWT.create(ProgressBarUiBinder.class);

    interface ProgressBarUiBinder extends UiBinder<Widget, ProgressBar> {
    }

    public ProgressBar() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
