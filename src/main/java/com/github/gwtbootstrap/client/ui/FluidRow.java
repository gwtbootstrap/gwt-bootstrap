package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;

/**
 * A Fluid row for the Grid System. It extends Row so it can be used in any
 * place that Row can be used.
 * 
 * @author Dominik Mayer
 */
public class FluidRow extends Row {

    public FluidRow() {
    	this("");
    }

	public FluidRow(String html) {
//		super(html);
		setStyleName(Bootstrap.row_fluid);
	}
}
