package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.resources.Bootstrap.Style;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * A Simple Div Widget with support for child widgets.
 *
 * @author Carlos A Becker
 * @author Dominik Mayer
 */
public class DivWidget extends FlowPanel {

    public DivWidget() {
    	super();
    }
    
    public DivWidget(String styleName) {
    	super();
    	setStyleName(styleName);
    }
    
    public void setStyle(Style style) {
    	setStyleName(style.get());
    }
    
    public void addStyle(Style style) {
    	addStyleName(style.get());
    }
    
    public void removeStyle(Style style) {
    	String styleString = style.get(); 
    	if (!styleString.isEmpty())
    		removeStyleName(styleString);
    }

}
