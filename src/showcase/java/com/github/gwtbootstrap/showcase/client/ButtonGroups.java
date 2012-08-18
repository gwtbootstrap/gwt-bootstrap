package com.github.gwtbootstrap.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ButtonGroups extends Composite {

    private static ButtonGroupsUiBinder uiBinder = GWT
            .create(ButtonGroupsUiBinder.class);

    interface ButtonGroupsUiBinder extends UiBinder<Widget, ButtonGroups> {
    }

    public ButtonGroups() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
