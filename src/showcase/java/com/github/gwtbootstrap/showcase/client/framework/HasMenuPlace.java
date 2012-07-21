package com.github.gwtbootstrap.showcase.client.framework;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;


public abstract class HasMenuPlace extends Place {
	
	private final Menus menu;
	private String token;

	public HasMenuPlace(Menus menu) {
		this.menu = menu;
	}

	public static interface Menu{

		String getName();
		String getDisplay();
	}

	public Menus getMenu(){
		return menu;
	}
	
	public void setToken(String token) {
		this.token = token;
		
	}
	
	public String getToken(){
		return token;
	}
	
	public abstract static class Tokenizer<T extends HasMenuPlace> implements PlaceTokenizer<T> {
		
		
		public String getToken(T place) {
			return place.getToken();
		}
	}
}
