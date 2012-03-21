package com.geekvigarista.gwt.bootstrap.client.ui.base;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author carlos
 */
public abstract class AbstractTypography extends Widget implements HasText {
	
    public void setText(String text) {
        getElement().setInnerText(text);
    }

	public String getText() {
		return getElement().getInnerText();
	}
}
