package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.DivWidget;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Bootstrap;

/**
 * A Fluid row for the Grid System.
 * 
 * @author Dominik Mayer
 */
public class FluidRow extends DivWidget {

    public FluidRow() {
        super();
        setStyleName(Bootstrap.row_fluid);
    }
}
