package com.github.gwtbootstrap.showcase.client.layout;

import com.github.gwtbootstrap.showcase.client.framework.HasMenuPlace;
import com.github.gwtbootstrap.showcase.client.framework.Menus;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;


public class LayoutPlace extends HasMenuPlace {
	
	public LayoutPlace(String token) {
		super(Menus.LAYOUT);
		setToken(token);
	}
	
	@Prefix("layout")
	public static class Tokenizer extends HasMenuPlace.Tokenizer<LayoutPlace> implements PlaceTokenizer<LayoutPlace> {

		@Override
		public LayoutPlace getPlace(String token) {
			return new LayoutPlace(token);
		}
	}
}
