/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekvigarista.gwt.bootstrap.client.v2;

import com.geekvigarista.gwt.bootstrap.client.v2.base.DivWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * This is part of TwBootstrap Grid System. enjoy it.
 *
 * @see Row
 * @author
 */
public class RowItem extends DivWidget {

    public RowItem(int size) {
        super();
        size = size < 1 ? 1 : size > 12 ? 12 : size;
        setStyleName("span" + size);
    }

    public RowItem(int size, int offset) {
        this(size);
        offset = offset > 0 ? offset : 1;
        addStyleName("offset" + offset);
    }

    public RowItem(int size, int offset, Widget... childs) {
        this(size, offset);
        add(childs);
    }

    public RowItem(int size, Widget... childs) {
        this(size);
        add(childs);
    }

    public void add(Widget... childs) {
        for (Widget child : childs) {
            add(child);
        }
    }
}
