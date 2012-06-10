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


/**
 * The interface of can change serach query form.
 * @since 2.0.4.0
 * @author ohashi keisuke
 */
public interface IsSearchQuery {

	/**
	 * Set search-query style to the element.
	 * @param searchQuery true:add search-query css-class/false:remove search-query css-class
	 */
	public void setSearchQuery(boolean searchQuery);
	
	/**
	 * is the element search-query style?
	 * @return true:has search-query css-class/false:has no search-query cass-class.
	 */
	public boolean isSearchQuery();
}
