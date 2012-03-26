package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.resources.Style;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * A simple <code>div</code> widget with support for child widgets.
 *
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>{@code
 * <b:DivWidget>
 *     <b:SomeChildWidget />
 *     <b:AnotherChildWidget />
 * </b:DivWidget>}
 * </pre>
 * </p>
 * 
 * @since 2.0.2.1
 *
 * @author Carlos A Becker
 * @author Dominik Mayer
 */
public class DivWidget extends FlowPanel {

	/**
	 * Creates an empty widget.
	 */
    public DivWidget() {
    	super();
    }
    
    /**
     * Creates a widget and sets the provided style name. Technically it 
     * replaces the <code>div<code>s <code>class</code> property with the
     * provided String.
     * 
     * @param styleName the class to be added to the <code>div</code>
     */
    public DivWidget(String styleName) {
    	super();
    	setStyleName(styleName);
    }
    
    /**
     * Replaces the widet's style with the provided one.
     * 
     * @param style the style to be applied to the Widget.
     */
    public void setStyle(Style style) {
    	setStyleName(style.get());
    }
    
    /**
     * Adds the provided style to the widet.
     * 
     * @param style the style to be added to the Widget.
     */
    public void addStyle(Style style) {
    	addStyleName(style.get());
    }
    
    /**
     * Removes the provided style from the widget.
     * 
     * @param style the style to be removed from the Widget.
     */
    public void removeStyle(Style style) {
    	String styleString = style.get(); 
    	if (!styleString.isEmpty())
    		removeStyleName(styleString);
    }

}
