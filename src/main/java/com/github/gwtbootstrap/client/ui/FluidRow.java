package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;

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
