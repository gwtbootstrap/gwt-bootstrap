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

import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.ProgressBar;
import com.github.gwtbootstrap.client.ui.TabLink;
import com.github.gwtbootstrap.client.ui.TabPane;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class Navigation extends Composite {

    @UiField
    NavLink navlink1;

    @UiField
    NavLink navlink2;
    
    @UiField
    TabLink lazyLoadTab;

    private static NavigationEntriesUiBinder uiBinder = GWT.create(NavigationEntriesUiBinder.class);

    interface NavigationEntriesUiBinder extends UiBinder<Widget, Navigation> {
    }

    public Navigation() {
        initWidget(uiBinder.createAndBindUi(this));
        ClickHandler handler = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.alert("ClickHandler navlink example.");
            }
        };
        navlink1.addClickHandler(handler);
        navlink2.addClickHandler(handler);
    }
    
    @UiHandler("lazyLoadTab")
    public void onClickLazyLoadTab(ClickEvent e) {
        final TabPane tabPane = lazyLoadTab.getTabPane();
        tabPane.clear();
        final ProgressBar progressBar = new ProgressBar();
        progressBar.setPercent(0);
        progressBar.setType(ProgressBar.Style.ANIMATED);
        tabPane.add(progressBar);
        
        Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
            
            @Override
            public boolean execute() {
                
                if(progressBar.getPercent() != 100) {
                    progressBar.setPercent(progressBar.getPercent() + 1);
                    return true;
                }
                tabPane.clear();
                tabPane.add(new Label("loaded"));
                return false;
            }
        }, 50);
        
    }
    

}
