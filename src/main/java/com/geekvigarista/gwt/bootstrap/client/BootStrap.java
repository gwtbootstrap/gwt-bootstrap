package com.geekvigarista.gwt.bootstrap.client;

import com.geekvigarista.gwt.bootstrap.client.v2.Button;
import com.geekvigarista.gwt.bootstrap.client.v2.Grid;
import com.geekvigarista.gwt.bootstrap.client.v2.GridItem;
import com.geekvigarista.gwt.bootstrap.client.v2.resources.ResourceInjector;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 *
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class BootStrap implements EntryPoint {

    public void onModuleLoad() {
        ResourceInjector.configure();
        HorizontalPanel vpbtns = new HorizontalPanel();
        vpbtns.add(new Button("Default"));
        vpbtns.add(new Button("Danger", new Button.OPTION[]{Button.OPTION.DANGER}));
        vpbtns.add(new Button("Large Info", new Button.OPTION[]{Button.OPTION.LARGE, Button.OPTION.INFO}));
        vpbtns.add(new Button("Small success", new Button.OPTION[]{Button.OPTION.SMALL, Button.OPTION.SUCCESS}));
        vpbtns.add(new Button("Large Primary", new Button.OPTION[]{Button.OPTION.LARGE, Button.OPTION.PRIMARY}));

        RootPanel.get().add(vpbtns);

        Grid grid = new Grid();
        GridItem gi1 = new GridItem(10);
        gi1.add(new Label("Grid 10"));
        grid.add(gi1);
        Grid grid1 = new Grid();
        GridItem gi21 = new GridItem(12);
        gi21.add(new Button("Button inside a grid inside a grid"));
        grid1.add(gi21);
        grid.add(grid1);
        RootPanel.get().add(grid);
    }
}
