package com.github.gwtbootstrap.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HeroUnit extends Composite {

    private static HeroUnitUiBinder uiBinder = GWT.create(HeroUnitUiBinder.class);

    interface HeroUnitUiBinder extends UiBinder<Widget, HeroUnit> {
    }

    public HeroUnit() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
