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


import com.github.gwtbootstrap.client.ui.CheckBox;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.ValueListBox;
import com.github.gwtbootstrap.client.ui.event.HideEvent;
import com.github.gwtbootstrap.client.ui.event.ShowEvent;
import com.github.gwtbootstrap.datetimepicker.client.ui.base.HasViewMode.ViewMode;
import com.github.gwtbootstrap.datetimepicker.client.ui.DateTimeBox;
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

import java.util.Arrays;
import java.util.Date;


public class Datetimepicker extends Composite {


    @UiField
    DateTimeBox dateTimePicker;

    @UiField
    CheckBox autoClose;

    @UiField
    TextBox format;

    @UiField
    FlowPanel logViewer;

    @UiField
    ListBox weekStart;

    @UiField
    DateTimeBox valueDate;

    @UiField(provided=true)
    ValueListBox<ViewMode> startViewMode = new ValueListBox<ViewMode>(new EnumRenderer<ViewMode>("Choose it"));

    @UiField(provided=true)
    ValueListBox<ViewMode> minViewMode = new ValueListBox<ViewMode>(new EnumRenderer<ViewMode>("Choose it"));

    @UiField(provided=true)
    ValueListBox<ViewMode> maxViewMode = new ValueListBox<ViewMode>(new EnumRenderer<ViewMode>("Choose it"));

    @UiField
    CheckBox showTodayButton;

    @UiField
    CheckBox highlightToday;


    interface DatetimepickerUiBinder extends UiBinder<Widget,Datetimepicker>{}

    private static DatetimepickerUiBinder uiBinder = GWT.create(DatetimepickerUiBinder.class);

    public Datetimepicker() {
        initWidget(uiBinder.createAndBindUi(this));
        
        startViewMode.setValue(ViewMode.MONTH);
        startViewMode.setAcceptableValues(Arrays.asList(ViewMode.values()));

        minViewMode.setValue(ViewMode.HOUR);
        minViewMode.setAcceptableValues(Arrays.asList(ViewMode.values()));

        maxViewMode.setValue(ViewMode.DECADE);
        maxViewMode.setAcceptableValues(Arrays.asList(ViewMode.values()));
    }
    
    @UiHandler("showButton")
    public void onClickShowButton(ClickEvent e) {
        dateTimePicker.show();
    }
    
    @UiHandler("hideButton")
    public void onClickHideButton(ClickEvent e) {
        dateTimePicker.hide();
    }
    
    @UiHandler("autoClose")
    public void onClickAutoClose(ValueChangeEvent<Boolean> e) {
        dateTimePicker.setAutoClose(e.getValue());
        dateTimePicker.reconfigure();
    }
    
    @UiHandler("enabled")
    public void onClickEnabled(ValueChangeEvent<Boolean> e) {
        dateTimePicker.setEnabled(e.getValue());
    }
    
    @UiHandler("showTodayButton")
    public void onClickShowTodayButton(ValueChangeEvent<Boolean> e) {
        dateTimePicker.setShowTodayButton(e.getValue());
        dateTimePicker.reconfigure();
    }

    @UiHandler("highlightToday")
    public void onClickhighlightToday(ValueChangeEvent<Boolean> e) {
        dateTimePicker.setHighlightToday(e.getValue());
        dateTimePicker.reconfigure();
    }

    @UiHandler("format")
    public void onChangeFormat(ValueChangeEvent<String> e) {
        dateTimePicker.setFormat(e.getValue());
        dateTimePicker.reconfigure();
    }
    
    @UiHandler("language")
    public void onCHangeLanguage(ValueChangeEvent<String> e) {
        dateTimePicker.setLanguage(e.getValue());
        dateTimePicker.reconfigure();
    }
    
    @UiHandler("weekStart")
    public void onChangeWeekStart(ChangeEvent e) {
        dateTimePicker.setWeekStart(Integer.parseInt(weekStart.getValue()));
        dateTimePicker.reconfigure();
    }
    
    @UiHandler("startDate")
    public void onChangeStartDate(ValueChangeEvent<Date> e) {
        if(e.getValue() == null) {
            return;
        }
        
        dateTimePicker.setStartDate_(e.getValue());
        dateTimePicker.reconfigure();
    }
    
    @UiHandler("endDate")
    public void onChangeEndDate(ValueChangeEvent<Date> e) {
        if(e.getValue() == null) {
            return;
        }
        
        dateTimePicker.setEndDate_(e.getValue());
        dateTimePicker.reconfigure();
    }
    
    @UiHandler("startViewMode")
    public void onChangeStartViewMode(ValueChangeEvent<ViewMode> e) {
        if(e.getValue() == null) {
            return;
        }
        
        dateTimePicker.setStartView(e.getValue());
        dateTimePicker.reconfigure();
    }
    
    @UiHandler("minViewMode")
    public void onChangeMinViewMode(ValueChangeEvent<ViewMode> e) {
        if(e.getValue() == null) {
            return;
        }

        dateTimePicker.setMinView(e.getValue());
        dateTimePicker.reconfigure();
    }

    @UiHandler("maxViewMode")
    public void onChangeMaxViewMode(ValueChangeEvent<ViewMode> e) {
        if(e.getValue() == null) {
            return;
        }

        dateTimePicker.setMaxView(e.getValue());
        dateTimePicker.reconfigure();
    }

    @UiHandler("valueDate")
    public void onChangeValueDate(ValueChangeEvent<Date> e) {
        dateTimePicker.setValue(e.getValue());
    }
    
    @UiHandler("dateTimePicker")
    public void onShow(ShowEvent e) {
        addLog("fire show event");
    }
    
    @UiHandler("dateTimePicker")
    public void onHide(HideEvent e) {
        addLog("fire hide event");
    }
    
    @UiHandler("dateTimePicker")
    public void onValueChange(ValueChangeEvent<Date> e) {
        addLog("fire value change event   [value:" + e.getValue() + "]");
    }
    
    public void addLog(String log) {
        logViewer.insert(new Label(new Date() + " : " + log), 0);
    }
    
}
