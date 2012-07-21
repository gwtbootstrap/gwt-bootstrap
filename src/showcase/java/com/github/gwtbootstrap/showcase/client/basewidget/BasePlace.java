package com.github.gwtbootstrap.showcase.client.basewidget;

import com.github.gwtbootstrap.showcase.client.framework.HasMenuPlace;
import com.github.gwtbootstrap.showcase.client.framework.Menus;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class BasePlace extends HasMenuPlace {

    public BasePlace(String token) {
        super(Menus.BASE);
        setToken(token);
    }
    
    @Prefix("base")
    public static class Tokenizer extends HasMenuPlace.Tokenizer<BasePlace> implements PlaceTokenizer<BasePlace> {

        @Override
        public BasePlace getPlace(String token) {
            return new BasePlace(token);
        }
    }


}
