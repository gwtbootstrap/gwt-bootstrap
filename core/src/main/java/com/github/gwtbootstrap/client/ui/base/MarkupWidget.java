package com.github.gwtbootstrap.client.ui.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public abstract class MarkupWidget implements IsWidget, HasWidgets,
        HasOneWidget , HasId{

    protected Widget widget;
    private String id;

    /**
     * {@inheritDoc}
     */
    public void setWidget(IsWidget w) {
        setWidget(w == null ? null : w.asWidget());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Widget asWidget() {
        return widget;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Widget getWidget() {
        return widget;
    }

    @Override
    public void setWidget(Widget w) {
        // Validate
        if (w == widget) {
            return;
        }

        widget = w;
        
        if(widget == null ) {
            return;
        }
        
        if(widget.getElement().getId() != null && !widget.getElement().getId().isEmpty()) {
            this.id = widget.getElement().getId();
            return;
        }
        
        if(this.id != null) {
            setId(id);
            return;
        }
        
        setId(DOM.createUniqueId());
    }
    
    public void add(IsWidget w) {
        add(w.asWidget());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Widget w) {
        // Can't add() more than one widget to a SimplePanel.
        if (getWidget() != null) {
            throw new IllegalStateException("can only contain one child widget");
        }
        setWidget(w);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        widget = null;
    }

    @Override
    public Iterator<Widget> iterator() {
        // Return a simple iterator that enumerates the 0 or 1 elements in this
        // panel.
        return new Iterator<Widget>() {

            boolean hasElement = widget != null;

            Widget returned = null;

            public boolean hasNext() {
                return hasElement;
            }

            public Widget next() {
                if (!hasElement || (widget == null)) {
                    throw new NoSuchElementException();
                }
                hasElement = false;
                return (returned = widget);
            }

            public void remove() {
                if (returned != null) {
                    MarkupWidget.this.remove(returned);
                }
            }
        };
    }

    @Override
    public boolean remove(Widget w) {
        // Validate.
        if (widget != w) {
            return false;
        }

        // Logical detach.
        widget = null;
        return true;
    }
    
    @Override
    public void setId(String id) {

        this.id = id;
        
        if(widget != null) {
            widget.getElement().setId(id);
        } 
    }
    
    @Override
    public String getId() {
        
        return widget != null? widget.getElement().getId() : this.id;
    }

}
