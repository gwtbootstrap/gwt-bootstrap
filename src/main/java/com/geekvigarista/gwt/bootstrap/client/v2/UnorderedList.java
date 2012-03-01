/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekvigarista.gwt.bootstrap.client.v2;

import com.geekvigarista.gwt.bootstrap.client.v2.base.ComplexWidget;
import com.google.gwt.user.client.ui.IsWidget;

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
