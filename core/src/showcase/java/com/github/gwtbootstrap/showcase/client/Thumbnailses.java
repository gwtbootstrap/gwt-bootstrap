package com.github.gwtbootstrap.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Thumbnailses extends Composite {

    private static ThumbnailsesUiBinder uiBinder = GWT
            .create(ThumbnailsesUiBinder.class);

    interface ThumbnailsesUiBinder extends UiBinder<Widget, Thumbnailses> {
    }

    public Thumbnailses() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
