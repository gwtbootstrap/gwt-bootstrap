/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekvigarista.gwt.bootstrap.client.v2;

import com.geekvigarista.gwt.bootstrap.client.v2.base.ComplexWidget;

/**
 * This is part of TwBootstrap Grid System. enjoy it.
 * 
 * @see Row
 * @author 
 */
public class RowItem extends ComplexWidget {

    public RowItem(int size) {
        super("div");
        size = size < 1 ? 1 : size > 12 ? 12 : size;
        setStyleName("span" + size);
    }

    public RowItem(int size, int offset) {
        this(size);
        offset = offset > 0 ? offset : 1;
        addStyleName("offset" + offset);
    }
}
