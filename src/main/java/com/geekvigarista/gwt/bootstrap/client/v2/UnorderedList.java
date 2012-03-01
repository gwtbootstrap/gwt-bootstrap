package com.geekvigarista.gwt.bootstrap.client.v2;

import com.geekvigarista.gwt.bootstrap.client.v2.base.ComplexWidget;

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
