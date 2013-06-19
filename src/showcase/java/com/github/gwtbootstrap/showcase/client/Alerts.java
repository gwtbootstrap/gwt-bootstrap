/*
 *  Copyright 2012 GWT-Bootstrap
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.gwtbootstrap.showcase.client;

import java.util.Arrays;

import com.github.gwtbootstrap.client.ui.Alert;
import com.github.gwtbootstrap.client.ui.AlertBlock;
import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.CheckBox;
import com.github.gwtbootstrap.client.ui.Column;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.ValueListBox;
import com.github.gwtbootstrap.client.ui.base.AlertBase;
import com.github.gwtbootstrap.client.ui.constants.AlertType;
import com.github.gwtbootstrap.client.ui.event.ClosedEvent;
import com.github.gwtbootstrap.client.ui.event.ClosedHandler;
import com.github.gwtbootstrap.showcase.client.util.EnumRenderer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Alerts extends Composite {

    @UiField
    Alert alert;

    @UiField
    AlertBlock alertBlock;

    @UiField
    AlertBase setupAlert, setupAlertBlock;

    @UiField(provided = true)
    ValueListBox<AlertType> type = new ValueListBox<AlertType>(
            new EnumRenderer<AlertType>(""));
    
    @UiField
    Column alertColumn;
    
    @UiField
    Button showButton;
    
    @UiField
    TextBox heading;
    
    @UiField
    CheckBox animation;
    
    private static AlertsUiBinder uiBinder = GWT.create(AlertsUiBinder.class);

    interface AlertsUiBinder extends UiBinder<Widget, Alerts> {
    }

    public Alerts() {
        type.setAcceptableValues(Arrays.asList(AlertType.values()));
        
        initWidget(uiBinder.createAndBindUi(this));
        
	}

    @UiHandler("alertClose")
    public void onClickClose(ClickEvent e) {
        alert.close();
    }

    @UiHandler("alertBlockClose")
    public void onClickBlockClose(ClickEvent e) {
        alertBlock.close();
    }
    
    @UiHandler("animation")
    public void onChangeAnimation(ValueChangeEvent<Boolean> e) {
        setupAlert.setAnimation(e.getValue());
        setupAlertBlock.setAnimation(e.getValue());
    }
    
    @UiHandler("heading")
    public void onChangeHeading(ValueChangeEvent<String> e) {
        setupAlert.setHeading(e.getValue());
        setupAlertBlock.setHeading(e.getValue());
    }
    
    @UiHandler("close")
    public void onChangeClose(ValueChangeEvent<Boolean> e) {
        setupAlert.setClose(e.getValue());
        setupAlertBlock.setClose(e.getValue());
    }
    
    @UiHandler("type")
    public void onChangeType(ValueChangeEvent<AlertType> e) {
        setupAlert.setType(e.getValue());
        setupAlertBlock.setType(e.getValue());
    }
    
    @UiHandler({"setupAlert","setupAlertBlock"})
    public void onHiddenAlert(ClosedEvent<AlertBase> e) {
        showButton.setEnabled(true);
    }
    
    @UiHandler("showButton")
    public void onClickShowButton(ClickEvent e) {
        
        ClosedHandler handler = new ClosedHandler() {
            
            @Override
            public void onClosed(ClosedEvent closedEvent) {
                onHiddenAlert(closedEvent);
            }
        };
        
        if(setupAlert.getElement().hasParentElement())
            setupAlert.removeFromParent();
        
        if(setupAlertBlock.getElement().hasParentElement())
            setupAlertBlock.removeFromParent();
        
        AlertBase backup = setupAlert;
        
        setupAlert = new Alert();
        
        setupAlert.setText(backup.getText());
        setupAlert.setClose(backup.hasClose());
        setupAlert.setHeading(heading.getText());
        setupAlert.setAnimation(animation.getValue());
        setupAlert.addClosedHandler(handler);
        if(type.getValue() != null) setupAlert.setType(type.getValue());
        alertColumn.add(setupAlert);
        
        backup = setupAlertBlock;
        
        setupAlertBlock = new AlertBlock();
        
        setupAlertBlock.setText(backup.getText());
        setupAlertBlock.setClose(backup.hasClose());
        setupAlertBlock.setHeading(heading.getText());
        setupAlertBlock.setAnimation(animation.getValue());
        setupAlertBlock.addClosedHandler(handler);
        if(type.getValue() != null) setupAlertBlock.setType(type.getValue());
        alertColumn.add(setupAlertBlock);
        
        showButton.setEnabled(false);
    }
    
}
