package com.github.gwtbootstrap.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class PageHeader extends Composite {

    private static PageHeaderUiBinder uiBinder = GWT.create(PageHeaderUiBinder.class);

    interface PageHeaderUiBinder extends UiBinder<Widget, PageHeader> {
    }

    public PageHeader() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
