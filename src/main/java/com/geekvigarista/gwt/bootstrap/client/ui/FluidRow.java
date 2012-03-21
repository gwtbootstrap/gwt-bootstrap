package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.DivWidget;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;

/**
 * A Fluid row for the Grid System.
 * 
 * @author Dominik Mayer
 */
public class FluidRow extends DivWidget {

    public FluidRow() {
        super();
        setStyleName(BootstrapCssResources.row_fluid);
    }
}
