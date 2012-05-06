package com.github.gwtbootstrap.client.ui.base;


/**
 * The interface of can change serach query form.
 * @since 2.0.3.0
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
