/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekvigarista.gwt.bootstrap.client.v2;

import com.geekvigarista.gwt.bootstrap.client.v2.base.DivWidget;
import com.google.gwt.user.client.ui.Widget;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author carlos
 */
public class FluidContainer extends DivWidget {

    private Row row;

    public FluidContainer() {
        setStylePrimaryName("container-fluid");
        this.row = new Row(true);
        add(row);
    }

    public void add(RowItem item) {
        row.add(item);
    }

    public void remove(RowItem item) {
        row.remove(item);
    }
}
