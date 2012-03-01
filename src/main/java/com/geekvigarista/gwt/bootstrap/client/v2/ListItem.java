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
public class ListItem extends ComplexWidget {

    public ListItem(IsWidget... childs) {
        super("li");
        for (IsWidget w : childs) {
            add(w);
        }
    }
}
