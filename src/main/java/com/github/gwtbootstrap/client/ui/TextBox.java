package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.constants.Constants;

/**
 * A TextBox with a placeholder attribute.
 * 
 * @since 2.0.2.0
 * 
 * @author Carlos Alexandro Becker
 * 
 */
public class TextBox extends com.github.gwtbootstrap.client.ui.base.TextBox {

	/**
	 * Set a placeholder attribute (HTML5).
	 * 
	 * @param placeholder
	 *            the String to show. Use a empty string or null to remove the attribute.
	 */
	public void setPlaceholder(String placeholder) {
		if (placeholder == null || placeholder.trim().isEmpty()) {
			getElement().removeAttribute(Constants.PLACEHOLDER);
			return;
		}
		getElement().setAttribute(Constants.PLACEHOLDER, placeholder);
	}

}
