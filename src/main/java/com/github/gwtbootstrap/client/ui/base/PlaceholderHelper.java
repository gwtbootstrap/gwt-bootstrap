package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.user.client.Element;


/**
 * The helper class for {@link HasPlaceholder} interface.
 * 
 * @author ohashi keisuke
 *
 */
public class PlaceholderHelper {

	//TODO 2012/05/04 ohashi keisuke. Support for non HTML5 Browser.
	//I designed this class as non static class.
	//Maybe we can use deffered binding for non HTML5 Browser support.
	
	/**
	 * Set a placeholder attribute (HTML5) to the element.
	 * 
	 * @param element the element be set 
	 * @param placeholder
	 *            the String to show. Use a empty string or null to remove the attribute.
	 */
	public void setPlaceholer(Element element , String placeholder) {
		if (placeholder == null || placeholder.trim().isEmpty()) {
			element.removeAttribute(Constants.PLACEHOLDER);
			return;
		}
		element.setAttribute(Constants.PLACEHOLDER, placeholder);
	}
	
	/**
	 * Get a placeholder attribute (HTML5) from the element.
	 * <p>
	 * If the element don't have placeholder attribute,This return empty string.
	 * </p>
	 * @param element the element
	 * @return placeholder attribute.
	 */
	public String getPlaceholder(Element element) {
		return element.hasAttribute(Constants.PLACEHOLDER) 
				? element.getAttribute(Constants.PLACEHOLDER)
				: "";
	}
}
