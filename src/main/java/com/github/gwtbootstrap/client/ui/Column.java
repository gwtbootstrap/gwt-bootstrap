package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * This is part of TwBootstrap Grid System. enjoy it.
 *
 * @see Row
 * @author
 */
public class Column extends DivWidget {

    public @UiConstructor Column(int size) {
        super();
        size = size < 1 ? 1 : size > 12 ? 12 : size;
        setStyleName("span" + size);
    }

    public Column(int size, int offset) {
        this(size);
        setOffset(offset);
    }

    public Column(int size, int offset, Widget... childs) {
        this(size, offset);
        add(childs);
    }

    public Column(int size, Widget... childs) {
        this(size);
        add(childs);
    }

    public void setOffset(int offset) {
    	offset = offset > 0 ? offset : 1;
    	addStyleName("offset" + offset);
    }
    
    public void add(Widget... childs) {
        for (Widget child : childs) {
            add(child);
        }
    }
}
