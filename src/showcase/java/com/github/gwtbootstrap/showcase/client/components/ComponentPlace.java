package com.github.gwtbootstrap.showcase.client.components;

import com.github.gwtbootstrap.showcase.client.framework.HasMenuPlace;
import com.github.gwtbootstrap.showcase.client.framework.Menus;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;


public class ComponentPlace extends HasMenuPlace {
	
	public ComponentPlace(String token) {
		super(Menus.COMPONENT);
		setToken(token);
	}
	
	@Prefix("component")
	public static class Tokenizer extends HasMenuPlace.Tokenizer<ComponentPlace> implements PlaceTokenizer<ComponentPlace> {

		@Override
		public ComponentPlace getPlace(String token) {
			return new ComponentPlace(token);
		}
	}
}
