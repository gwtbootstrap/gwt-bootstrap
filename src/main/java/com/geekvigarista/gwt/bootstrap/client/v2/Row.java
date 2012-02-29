/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekvigarista.gwt.bootstrap.client.v2;

import com.geekvigarista.gwt.bootstrap.client.v2.base.DivWidget;

/**
 * This is the twBootstrap Grid System, enjoy.
 *
 * @see RowItem
 * @author Carlos A Becker
 */
public class Row extends DivWidget {

    public Row() {
        super();
        setStyleName("row");
    }

    public Row(boolean fluid) {
        super();
        if (fluid) {
            setStyleName("row-fluid");
        }
    }
}
