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
package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;


/**
 * The hepper class for {@link IsSearchQuery}.
 * 
 * @since 2.0.4.0
 * @author ohashi keisuke
 */
public class SearchQueryStyleHelper {

	/**
	 * Set search-query style to the element.
	 * @param widget applied style widget
	 * @param searchQuery true:add search-query css-class/false:remove search-query css-class
	 */
	public static void setSearchQuery(Widget widget , boolean searchQuery) {
		setSearchQuery(widget.getElement(), searchQuery);
	}
	
	/**
	 * is the element search-query style?
	 * @param widget target widget
	 * @return true:has search-query css-class/false:has no search-query cass-class.
	 */
	public static boolean isSearchQuery(Widget widget) {
		return isSearchQuery(widget.getElement());
	}

	/**
	 * Set search-query style to the element.
	 * @param elem the applied style element
	 * @param searchQuery true:add search-query css-class/false:remove search-query css-class
	 */
	public static void setSearchQuery(Element elem, boolean searchQuery) {
		if(isSearchQuery(elem)) {
			elem.removeClassName(Constants.SEARCH_QUERY);
		}
		
		if(searchQuery) {
			elem.addClassName(Constants.SEARCH_QUERY);
		}
	}
	
	/**
	 * is the element search-query style?
	 * @param elem target element.
	 * @return true:has search-query css-class/false:has no search-query cass-class.
	 */
	public static boolean isSearchQuery(Element elem) {
		return elem.getClassName().contains(Constants.SEARCH_QUERY);
	}

}
