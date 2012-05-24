package com.github.gwtbootstrap.showcase.client;

import com.github.gwtbootstrap.client.ui.Tooltip;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author: Carlos A Becker
 */
public class Tooltips extends Composite {

    interface TooltipsUiBinder extends UiBinder<Widget, Tooltips> {
    }

    private static TooltipsUiBinder ourUiBinder = GWT.create(TooltipsUiBinder.class);

    public Tooltips() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}