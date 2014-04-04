package com.github.gwtbootstrap.showcase.client;

import com.github.gwtbootstrap.client.ui.incubator.NameValuePairImpl;
import com.github.gwtbootstrap.client.ui.incubator.PickList;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * User: Halil Karakose
 * Date: 10/30/13
 * Time: 7:16 PM
 */
public class PickLists extends Composite {
    @UiField
    PickList pickList;

    interface PickListsUiBinder extends UiBinder<HTMLPanel, PickLists> {
    }

    private static PickListsUiBinder ourUiBinder = GWT.create(PickListsUiBinder.class);

    public PickLists() {
        initWidget(ourUiBinder.createAndBindUi(this));

        pickList.addElementToLeftList(new NameValuePairImpl("hkarakose", "hkarakose"));
        pickList.addElementToRightList(new NameValuePairImpl("caarlos0", "caarlos0"));
        pickList.addElementToRightList(new NameValuePairImpl("reinert", "reinert"));
    }
}