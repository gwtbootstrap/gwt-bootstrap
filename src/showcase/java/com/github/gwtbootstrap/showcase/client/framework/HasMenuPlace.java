/*
 *  Copyright 2012 GWT-Bootstrap
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
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
