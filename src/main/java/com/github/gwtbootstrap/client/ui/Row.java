package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;

/**
 * This is the twBootstrap Grid System, enjoy.
 *
 * @see Column
 * @author Carlos A Becker
 */
public class Row extends DivWidget {

    public Row() {
        super();
        setStyleName(Bootstrap.row);
    }
}
