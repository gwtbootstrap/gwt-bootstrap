package com.github.gwtbootstrap.showcase.client.framework;

import com.github.gwtbootstrap.showcase.client.basewidget.BasePlace;
import com.github.gwtbootstrap.showcase.client.components.ComponentPlace;
import com.github.gwtbootstrap.showcase.client.gwt.GWTPlace;
import com.github.gwtbootstrap.showcase.client.layout.LayoutPlace;
import com.github.gwtbootstrap.showcase.client.overview.OverviewPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({
        OverviewPlace.Tokenizer.class,
        LayoutPlace.Tokenizer.class,
        BasePlace.Tokenizer.class,
        ComponentPlace.Tokenizer.class,
        GWTPlace.Tokenizer.class

        })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
