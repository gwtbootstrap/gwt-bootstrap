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
public class Row extends ComplexWidget {

    public Row() {
        super("div");
        setStyleName("row");
    }

    public Row(boolean fluid) {
        super("div");
        setStyleName("row-fluid");
    }
}   
