package com.github.gwtbootstrap.showcase.client.gwt;

import com.github.gwtbootstrap.showcase.client.framework.HasMenuPlace;
import com.github.gwtbootstrap.showcase.client.framework.Menus;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;


public class GWTPlace extends HasMenuPlace {
	
	public GWTPlace(String token) {
		super(Menus.GWT);
		setToken(token);
	}
	
	@Prefix("gwt")
	public static class Tokenizer extends HasMenuPlace.Tokenizer<GWTPlace> implements PlaceTokenizer<GWTPlace> {

		@Override
		public GWTPlace getPlace(String token) {
			return new GWTPlace(token);
		}
	}
}
