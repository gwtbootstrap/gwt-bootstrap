package com.github.gwtbootstrap.showcase.client;


import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Datepicker extends Composite {
    interface DatepickerUiBinder extends UiBinder<Widget,Datepicker>{}

    private static DatepickerUiBinder uiBinder = GWT.create(DatepickerUiBinder.class);

    public Datepicker() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
