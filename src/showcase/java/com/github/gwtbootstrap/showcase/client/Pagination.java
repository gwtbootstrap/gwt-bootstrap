package com.github.gwtbootstrap.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Pagination extends Composite {

    private static PaginationUiBinder uiBinder = GWT.create(PaginationUiBinder.class);

    interface PaginationUiBinder extends UiBinder<Widget, Pagination> {
    }

    public Pagination() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
