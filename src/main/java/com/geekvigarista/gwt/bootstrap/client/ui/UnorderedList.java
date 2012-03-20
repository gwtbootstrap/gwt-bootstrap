package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.ComplexWidget;

/**
 *
 * @author carlos
 */
public class UnorderedList extends ComplexWidget {

    public UnorderedList() {
        super("ul");
    }

    public UnorderedList(ListItem... childs) {
        this();
        for (ListItem li : childs) {
            add(li);
        }
    }

    public void add(ListItem child) {
        super.add(child);
    }
}
