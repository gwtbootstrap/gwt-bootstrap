package com.github.gwtbootstrap.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Modal extends Composite {

    private static ModalUiBinder uiBinder = GWT.create(ModalUiBinder.class);

    interface ModalUiBinder extends UiBinder<Widget, Modal> {
    }

    @UiField
    com.github.gwtbootstrap.client.ui.Modal m;
    
    public Modal() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("onShow")
    void onAddClick(ClickEvent event) {
        m.show();
    }
}
