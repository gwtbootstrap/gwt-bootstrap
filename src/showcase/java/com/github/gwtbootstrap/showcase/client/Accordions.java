package com.github.gwtbootstrap.showcase.client;

import java.util.Date;

import com.github.gwtbootstrap.client.ui.Collapse;
import com.github.gwtbootstrap.client.ui.event.HiddenEvent;
import com.github.gwtbootstrap.client.ui.event.HideEvent;
import com.github.gwtbootstrap.client.ui.event.ShowEvent;
import com.github.gwtbootstrap.client.ui.event.ShownEvent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class Accordions extends Composite {

    private static AccordionsUiBinder uiBinder = GWT
            .create(AccordionsUiBinder.class);

    /* default */ interface AccordionsUiBinder extends UiBinder<Widget, Accordions> {
    }
    
    @UiField
    /* default */Collapse toggle1;
    
    @UiField
    /* default */FlowPanel logPanel;

    public Accordions() {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @UiHandler("toggleButton")
    /* default */ void onClickToggleButton(ClickEvent e) {
        toggle1.toggle();
    }
    
    @UiHandler("toggle1")
    /* default */ void onHide(HideEvent e) {
        addLog("hide");
    }
    @UiHandler("toggle1")
    /* default */ void onHidden(HiddenEvent e) {
        addLog("hidden");
    }
    
    @UiHandler("toggle1")
    /* default */ void onShow(ShowEvent e) {
        addLog("show");
    }
    @UiHandler("toggle1")
    /* default */ void onShown(ShownEvent e) {
        addLog("shown");
    }
    
    
    /* default */ void addLog(String msg) { 
        logPanel.insert(new Label(new Date() + ":" + msg), 0); 
    }
    

}
