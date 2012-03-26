package com.github.gwtbootstrap.client.ui.base;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

/**
 * Helper class for widgets that have text.
 * 
 * @since 2.0.2.1
 *
 * @author Carlos Alexandro Becker
 * 
 */
public abstract class AbstractTypography extends Widget implements HasText {
	
	/**
	 * {@inheritDoc}
	 */
    public void setText(String text) {
        getElement().setInnerText(text);
    }

    /**
     * {@inheritDoc}
     */
	public String getText() {
		return getElement().getInnerText();
	}
}
