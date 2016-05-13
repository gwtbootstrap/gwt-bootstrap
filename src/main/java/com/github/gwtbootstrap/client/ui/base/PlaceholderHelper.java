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


/**
 * The helper class for {@link HasPlaceholder} interface.
 * 
 * @since 2.0.4.0
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
