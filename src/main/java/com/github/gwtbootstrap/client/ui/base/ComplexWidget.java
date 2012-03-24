package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.resources.Bootstrap.Style;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetCollection;
import java.util.Iterator;

/**
 * A widget with a collection of widgets, base of a lot of other components :)
 * 
 * @author Carlos A Becker
 */
public class ComplexWidget extends ComplexPanel implements HasWidgets {

    private WidgetCollection children;
    private Element element;

    public ComplexWidget(String tag) {
        element = DOM.createElement(tag);
        setElement(element);
        children = new WidgetCollection(this);
    }

    @Override
    public void add(Widget w) {
        // logical add
        children.add(w);

        // physical add
        getElement().appendChild(w.getElement());
    }
    
    public void insert(Widget w, int beforeIndex) {
    	checkIndexBoundsForInsertion(beforeIndex);
    	
    	children.add(w);
    	insert(w, getElement(), beforeIndex, true);
    }

    @Override
    public void clear() {
        Iterator<Widget> it = iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override
    public Iterator<Widget> iterator() {
        return children.iterator();
    }

    @Override
    public boolean remove(Widget w) {
        try {
            children.remove(w);
            getElement().removeChild(w.getElement());
            return true;
        } catch (Exception e) {
        	System.out.println("Widget was not in element.");
//            e.printStackTrace();
        }
        return false;
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
