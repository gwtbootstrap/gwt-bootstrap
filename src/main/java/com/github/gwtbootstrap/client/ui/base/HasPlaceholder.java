package com.github.gwtbootstrap.client.ui.base;



/**
 * Interface for has Placeholder attribute element.
 * @author ohashi keisuke
 * @see PlaceholderHelper
 */
public interface HasPlaceholder {

	/**
	 * Set a placeholder attribute (HTML5).
	 * 
	 * @param placeholder
	 *            the String to show. Use a empty string or null to remove the attribute.
	 */
	public void setPlaceholder(String placeholder);
	
	/**
	 * Get a placeholder attribute (HTML5).
	 * 
	 * @return placeholder attribute.
	 */
	public String getPlaceholder();
	
	
}
