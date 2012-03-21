package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.DivWidget;

/**
 * This is the twBootstrap Grid System, enjoy.
 *
 * @see Column
 * @author Carlos A Becker
 */
public class Row extends DivWidget {

    public Row() {
        super();
        setStyleName("row");
    }

    public Row(boolean fluid) {
        super();
        setFluid(fluid);
    }
    
    public void setFluid(boolean fluid) {
    	if (fluid) {
    		setStyleName("row-fluid");
    	}
    }
}
