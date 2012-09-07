package com.github.gwtbootstrap.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Accordions extends Composite {

    private static AccordionsUiBinder uiBinder = GWT
            .create(AccordionsUiBinder.class);

    interface AccordionsUiBinder extends UiBinder<Widget, Accordions> {
    }

    public Accordions() {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    

}
