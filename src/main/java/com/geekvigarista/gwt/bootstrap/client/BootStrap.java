package com.geekvigarista.gwt.bootstrap.client;

import com.geekvigarista.gwt.bootstrap.client.v2.*;
import com.geekvigarista.gwt.bootstrap.client.v2.resources.ResourceInjector;
import com.google.gwt.core.client.EntryPoint;
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

        FluidContainer container = new FluidContainer();

        RowItem sidebar = new RowItem(2);
        sidebar.add(new Button("Default"));
        sidebar.add(new Button("Danger", new Button.OPTION[]{Button.OPTION.DANGER}));
        sidebar.add(new Button("Large Info", new Button.OPTION[]{Button.OPTION.LARGE, Button.OPTION.INFO}));
        sidebar.add(new Button("Small success", new Button.OPTION[]{Button.OPTION.SMALL, Button.OPTION.SUCCESS}));
        sidebar.add(new Button("Large Primary", new Button.OPTION[]{Button.OPTION.LARGE, Button.OPTION.PRIMARY}, new Icon(Icon.Type.OK_SIGN, Icon.COLOR.WHITE)));

        container.add(sidebar);

        RowItem content = new RowItem(10);

        Row grid = new Row(true);
        RowItem gi1 = new RowItem(10);
        gi1.add(new Heading("Welcome to GWT-Bootstrap", 1));
        gi1.add(new Heading("2.0.0-SNAPSHOT", 6));
        gi1.add(new Label("Grid 10"));
        grid.add(gi1);
        Row grid1 = new Row();
        RowItem gi21 = new RowItem(12, 3);
        Button disabledBtn = new Button("Button inside a grid inside a grid and disabled", new Icon(Icon.Type.CHECK));
        disabledBtn.setEnabled(false);
        gi21.add(disabledBtn);
        grid1.add(gi21);
        gi1.add(grid1);
        content.add(grid);

        container.add(content);

        RootPanel.get().add(container);
    }
}
