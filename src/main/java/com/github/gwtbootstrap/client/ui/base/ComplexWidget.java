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

    private WidgetCollection childs;
    private Element element;

    public ComplexWidget(String tag) {
        element = DOM.createElement(tag);
        setElement(element);
        childs = new WidgetCollection(this);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
    }

    @Override
    public void add(Widget w) {
        // logical add
        childs.add(w);

        // physical add
        getElement().appendChild(w.getElement());
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
        return childs.iterator();
    }

    @Override
    public boolean remove(Widget w) {
        try {
            childs.remove(w);
            getElement().removeChild(w.getElement());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void setStyle(Style style) {
    	setStyleName(style.get());
    }
    
    public void addStyle(Style style) {
    	addStyleName(style.get());
    }
}
