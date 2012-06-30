package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.IconAnchor;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.user.client.Element;

public class TabLink extends NavLink {

    private TabPane pane;

    public TabLink(TabPane pane) {
        this();
        setText(pane.getHeading());
        setTablePane(pane);
    }

    public void setTablePane(TabPane pane) {
        this.pane = pane;

        IconAnchor anchor = getAnchor();
        anchor.getElement().setAttribute(Constants.DATA_TOGGLE, "tab");
        anchor.getElement().setAttribute(Constants.DATA_TARGET,
                "#" + pane.getId());
        if (pane.isActive() || this.isActive()) {
            show();
        }
    }
    
    public TabPane getTabPane() {
        return pane;
    }
    
    public TabLink() {
        super();
    }

    public void show() {
        setActive(true);
        show(getAnchor().getElement());
    }

    //@formatter:off
    public native void show(Element e)/*-{
        $wnd.jQuery(e).tab('show');
    }-*/;
    //@formatter:on

}