package com.github.gwtbootstrap.showcase.client;

import java.util.Arrays;

import com.github.gwtbootstrap.client.ui.Typeahead;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.Widget;

public class Typeaheads extends Composite {

    @UiField
    Typeahead typeahead;

    private static TypeaheadsUiBinder uiBinder = GWT
            .create(TypeaheadsUiBinder.class);

    interface TypeaheadsUiBinder extends UiBinder<Widget, Typeaheads> {
    }

    public Typeaheads() {
        initWidget(uiBinder.createAndBindUi(this));
        MultiWordSuggestOracle oracle = (MultiWordSuggestOracle) typeahead
                .getSuggestOracle();
        oracle.addAll(Arrays.asList(
                "Alabama", "Alaska", "Arizona", "Arkansas",
                "California", "Colorado", "Connecticut", "Delaware", "Florida",
                "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
                "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
                "Massachusetts", "Michigan", "Minnesota", "Mississippi",
                "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
                "New Jersey", "New Mexico", "New York", "North Dakota",
                "North Carolina", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
                "Rhode Island", "South Carolina", "South Dakota", "Tennessee",
                "Texas", "Utah", "Vermont", "Virginia", "Washington",
                "West Virginia", "Wisconsin", "Wyoming"));
    }

}
