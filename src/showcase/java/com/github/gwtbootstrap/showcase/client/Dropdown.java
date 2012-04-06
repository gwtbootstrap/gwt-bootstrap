package com.github.gwtbootstrap.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Dropdown extends Composite {

    private static DropdownUiBinder uiBinder = GWT.create(DropdownUiBinder.class);

    interface DropdownUiBinder extends UiBinder<Widget, Dropdown> {
    }

    public Dropdown() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
