package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.DivWidget;
import com.google.gwt.user.client.ui.IsWidget;

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

    @Override
    public void add(IsWidget child) {
        assert child instanceof RowItem : "Child must be a RowItem";
        super.add(child);
    }
}
