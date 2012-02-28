/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekvigarista.gwt.bootstrap.client.v2;

import com.geekvigarista.gwt.bootstrap.client.v2.base.ComplexWidget;

/**
 *
 * @author carlos
 */
public class GridItem extends ComplexWidget {

    public GridItem(int size) {
        super("div");
        size = size < 1 ? 1 : size > 12 ? 12 : size;
        setStyleName("span" + size);
    }
}
