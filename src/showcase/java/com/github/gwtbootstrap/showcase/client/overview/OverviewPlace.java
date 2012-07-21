package com.github.gwtbootstrap.showcase.client.overview;

import com.github.gwtbootstrap.showcase.client.framework.HasMenuPlace;
import com.github.gwtbootstrap.showcase.client.framework.Menus;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class OverviewPlace extends HasMenuPlace {

    public OverviewPlace(String token) {
        super(Menus.OVERVIEW);
        setToken(token);
    }
    
    @Prefix("overview")
    public static class Tokenizer extends HasMenuPlace.Tokenizer<OverviewPlace> implements PlaceTokenizer<OverviewPlace> {

        @Override
        public OverviewPlace getPlace(String token) {
            return new OverviewPlace(token);
        }
    }

    
    

}
