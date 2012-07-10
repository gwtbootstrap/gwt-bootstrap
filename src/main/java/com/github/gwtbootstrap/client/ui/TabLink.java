package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.IconAnchor;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * The TabLink for {@link TabPanel}
 * @author ohashi keisuke
 *
 */
public class TabLink extends NavWidget {

    private TabPane pane;
    private boolean createTabPane = true;

    /**
     * Create widget with set Effective TabPane 
     * @param pane effective tabPane
     */
    public TabLink(TabPane pane) {
        this();
        setText(pane.getHeading());
        setTablePane(pane);
    }

    /**
     * Create empty widget
     */
    public TabLink() {
        super();
        IconAnchor anchor = getAnchor();
        anchor.getElement().setAttribute(Constants.DATA_TOGGLE, "tab");
    }
    
    public void setCreateTabPane(boolean createTabPane) {
        this.createTabPane = createTabPane;
    }
    
    public boolean isCreateTabPane() {
        return this.createTabPane;
    }

    /**
     * Set Effective TabPane
     * @param pane
     */
    public void setTablePane(TabPane pane) {
        this.pane = pane;
        
        if(pane.getId() == null || pane.getId().isEmpty()) {
            pane.setHref(DOM.createUniqueId());
        }

        setDataTarget(pane.getId());
        
        this.setActive(pane.isActive());
    }
    
    public void setDataTarget(String id) {
        getAnchor().getElement().setAttribute(Constants.DATA_TARGET,"#" + id);
    }
    
    /**
     * Get Effective TabPane
     * @return effective TabPane
     */
    public TabPane getTabPane() {
        return pane;
    }
    
    @Override
    protected void onAttach() {
        super.onAttach();
        
        if(isActive()) {
            show();
        }
    }
    
    @Override
    public void setActive(boolean active) {
        super.setActive(active);
        
        if(pane != null) {
            pane.setActive(active);
        }
        
    }
    
    /**
     * show tab pane
     */
    public void show() {
        setActive(true);
        show(getAnchor().getElement());
    }

    //@formatter:off
    private native void show(Element e)/*-{
        $wnd.jQuery(e).tab('show');
    }-*/;
    //@formatter:on

}