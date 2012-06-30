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
import java.util.Date;

import com.github.gwtbootstrap.client.ui.CheckBox;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.ValueListBox;
import com.github.gwtbootstrap.client.ui.event.HideEvent;
import com.github.gwtbootstrap.client.ui.event.ShowEvent;
import com.github.gwtbootstrap.datepicker.client.ui.DateBox;
import com.github.gwtbootstrap.datepicker.client.ui.base.HasStartView;
import com.github.gwtbootstrap.datepicker.client.ui.base.HasStartView.ViewMode;
import com.github.gwtbootstrap.showcase.client.util.EnumRenderer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class Datepicker extends Composite {
    
    @UiField
    DateBox datePicker;
    
    @UiField
    CheckBox autoClose;
    
    @UiField
    TextBox format;
    
    @UiField
    FlowPanel logViewer;
    
    @UiField
    ListBox weekStart;
    
    @UiField
    DateBox valueDate;
    
    @UiField(provided=true)
    ValueListBox<ViewMode> viewMode = new ValueListBox<HasStartView.ViewMode>(new EnumRenderer<ViewMode>("Choose it")); 
    
    interface DatepickerUiBinder extends UiBinder<Widget,Datepicker>{}

    private static DatepickerUiBinder uiBinder = GWT.create(DatepickerUiBinder.class);

    public Datepicker() {
        initWidget(uiBinder.createAndBindUi(this));
        
        viewMode.setValue(null);
        viewMode.setAcceptableValues(Arrays.asList(ViewMode.values()));
    }
    
    @UiHandler("showButton")
    public void onClickShowButton(ClickEvent e) {
        datePicker.show();
    }
    
    @UiHandler("hideButton")
    public void onClickHideButton(ClickEvent e) {
        datePicker.hide();
    }
    
    @UiHandler("autoClose")
    public void onClickAutoClose(ValueChangeEvent<Boolean> e) {
        datePicker.setAutoClose(e.getValue());
        datePicker.reconfigure();
    }
    
    @UiHandler("format")
    public void onChangeFormat(ValueChangeEvent<String> e) {
        datePicker.setFormat(e.getValue());
        datePicker.reconfigure();
    }
    
    @UiHandler("language")
    public void onCHangeLanguage(ValueChangeEvent<String> e) {
        datePicker.setLanguage(e.getValue());
        datePicker.reconfigure();
    }
    
    @UiHandler("weekStart")
    public void onChangeWeekStart(ChangeEvent e) {
        datePicker.setWeekStart(Integer.parseInt(weekStart.getValue()));
        datePicker.reconfigure();
    }
    
    @UiHandler("startDate")
    public void onChangeStartDate(ValueChangeEvent<Date> e) {
        if(e.getValue() == null) {
            return;
        }
        
        datePicker.setStartDate_(e.getValue());
        datePicker.reconfigure();
    }
    
    @UiHandler("endDate")
    public void onChangeEndDate(ValueChangeEvent<Date> e) {
        if(e.getValue() == null) {
            return;
        }
        
        datePicker.setEndDate_(e.getValue());
        datePicker.reconfigure();
    }
    
    @UiHandler("viewMode")
    public void onChangeViewMode(ValueChangeEvent<ViewMode> e) {
        if(e.getValue() == null) {
            return;
        }
        
        datePicker.setStartView(e.getValue());
        datePicker.reconfigure();
    }
    
    @UiHandler("valueDate")
    public void onChangeValueDate(ValueChangeEvent<Date> e) {
        datePicker.setValue(e.getValue());
    }
    
    @UiHandler("datePicker")
    public void onShow(ShowEvent e) {
        addLog("fire show event");
    }
    
    @UiHandler("datePicker")
    public void onHide(HideEvent e) {
        addLog("fire hide event");
    }
    
    @UiHandler("datePicker")
    public void onValueChange(ValueChangeEvent<Date> e) {
        addLog("fire value change event   [value:" + e.getValue() + "]");
    }
    
    public void addLog(String log) {
        logViewer.insert(new Label(new Date() + " : " + log), 0);
    }
    
}
