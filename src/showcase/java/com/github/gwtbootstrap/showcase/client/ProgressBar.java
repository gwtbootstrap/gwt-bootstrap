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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.gwtbootstrap.client.ui.CodeBlock;
import com.github.gwtbootstrap.client.ui.ControlGroup;
import com.github.gwtbootstrap.client.ui.HelpInline;
import com.github.gwtbootstrap.client.ui.DoubleBox;
import com.github.gwtbootstrap.client.ui.ValueListBox;
import com.github.gwtbootstrap.client.ui.base.ProgressBarBase.Color;
import com.github.gwtbootstrap.client.ui.base.ProgressBarBase.Style;
import com.github.gwtbootstrap.client.ui.constants.ControlGroupType;
import com.github.gwtbootstrap.showcase.client.util.EnumRenderer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ProgressBar extends Composite {

    @UiField
    com.github.gwtbootstrap.client.ui.ProgressBar progressBar;
    
    @UiField(provided=true)
    ValueListBox<Style> type = new ValueListBox<Style>(new EnumRenderer<Style>("Choose Type"));
    
    @UiField(provided=true)
    ValueListBox<Color> color = new ValueListBox<Color>(new EnumRenderer<Color>("Choose Color"));
    
    @UiField
    DoubleBox percent;
    
    @UiField
    ControlGroup percentCG;
    
    @UiField
    HelpInline percentInline;
    
    @UiField
    CodeBlock code;
    
    
    
    
    
    private static ProgressBarUiBinder uiBinder = GWT.create(ProgressBarUiBinder.class);

    interface ProgressBarUiBinder extends UiBinder<Widget, ProgressBar> {
    }

    public ProgressBar() {
        initWidget(uiBinder.createAndBindUi(this));
        List<Color> colorList = new ArrayList<Color>();
        colorList.add(null);
        colorList.addAll(Arrays.asList(Color.values()));
        type.setValue(Style.DEFAULT);
        type.setAcceptableValues(Arrays.asList(Style.values()));
        color.setAcceptableValues(colorList);
        color.setValue(null);
        code.setText("<b:ProgressBar percent=\"100\"/>");
    }
    
    @UiHandler("type")
    void onChangeType(ValueChangeEvent<Style> e) {
        changeStyle();
    }
    
    @UiHandler("color")
    void onChangeColor(ValueChangeEvent<Color> e) {
        changeStyle();
    }
    
    @UiHandler("percent")
    public void onAgeUpdate(KeyPressEvent event) {

        if (event.getCharCode() < '0' || event.getCharCode() > '9') {
            percentCG.setType(ControlGroupType.ERROR);
            percentInline.setText("Percent should be numeric.");

            event.preventDefault();
        } else {
            percentCG.setType(ControlGroupType.NONE);
            percentInline.setText("");
        }
    }

    
    @UiHandler("percent")
    void onChangePercent(ValueChangeEvent<Double> e) {
        Double p = e.getValue();
        
        if(p == null) {
            percentCG.setType(ControlGroupType.ERROR);
            percentInline.setText("Percent should be numeric.");
            return;
        }
        
        if(e.getValue() < 0.0 || e.getValue() > 100.0) {
            percentCG.setType(ControlGroupType.ERROR);
            percentInline.setText("Percent should be between 0 - 100.");
            return;
        }
        
        changeStyle();
    }

    @UiHandler("action")
    void onClickAction(ClickEvent e) {
        percent.setEnabled(false);
        percent.setValue(0.0);
        progressBar.setPercent(0.0);
        Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {
            
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean execute() {
                
                if(progressBar.getPercent() >= 100.0) {
                    percent.setEnabled(true);
                    return false;
                }
                progressBar.setPercent(progressBar.getPercent() + 10.0);
                percent.setValue(progressBar.getPercent());
                changeStyle();
                
                return true;
            }
        }, 1000);
    }
    
    
    private void changeStyle() {
        StringBuilder builder = new StringBuilder("<b:ProgressBar ");
        if(type.getValue() != null) {
            progressBar.setType(type.getValue());
            builder.append("type=\"" + type.getValue().name() + "\" ");
        }
        
        if(color.getValue() != null) {
            progressBar.setColor(color.getValue());
            builder.append("color=\"" + color.getValue().name() + "\" ");
        }
        
        if(percent.getValue() != null && percent.getValue() >= 0 && percent.getValue() <= 100) {
            progressBar.setPercent(percent.getValue());
            builder.append("percent=\"" + percent.getValue() + "\" ");
        }
        
        builder.append("/>");
        
        code.setText(builder.toString());
    }
    
    


}
