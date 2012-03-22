package com.github.gwtbootstrap.client.ui.base;

/**
 * A Simple Div Widget with support for child widgets.
 *
 * @author Carlos A Becker
 */
public class DivWidget extends ComplexWidget {

    public DivWidget() {
        super("div");
    }
    
    public DivWidget(String styleName) {
    	this();
    	setStyleName(styleName);
    }
}
