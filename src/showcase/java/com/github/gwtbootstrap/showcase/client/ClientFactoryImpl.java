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

import com.github.gwtbootstrap.showcase.client.basewidget.BaseActivity;
import com.github.gwtbootstrap.showcase.client.components.ComponentActivity;
import com.github.gwtbootstrap.showcase.client.framework.AppPlaceHistoryMapper;
import com.github.gwtbootstrap.showcase.client.framework.IShowcaseActivity;
import com.github.gwtbootstrap.showcase.client.layout.LayoutActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactoryImpl implements ClientFactory {

    private final EventBus eventBus = new SimpleEventBus();
    
    private final PlaceController placeController = new PlaceController(eventBus);
    
    private final PlaceHistoryMapper placeHistoryMapper = GWT.create(AppPlaceHistoryMapper.class);
    
    private final Subnav subnav = new Subnav();
    
    private IShowcaseActivity baseActivity;
    private IShowcaseActivity layoutActivity;
    private IShowcaseActivity componentActivity;
    
    @Override
    public EventBus getEventBus() {
        return eventBus;
    }
    
    @Override
    public PlaceController getPlaceController() {
        return placeController;
    }

    @Override
    public Subnav getSubnav() {
        return subnav;
    }

    @Override
    public PlaceHistoryMapper getPlaceHistoryMapper() {
        return placeHistoryMapper;
    }

    @Override
    public IShowcaseActivity getLayoutActivity() {
        
        if(layoutActivity == null) {
            layoutActivity = GWT.create(LayoutActivity.Proxy.class);
        }
        
        return layoutActivity;
    }

    @Override
    public IShowcaseActivity getBaseActivity() {
        
        if(baseActivity == null) {
            baseActivity = GWT.create(BaseActivity.Proxy.class);
        }
        
        return baseActivity;
    }

    @Override
    public IShowcaseActivity getComponentActivity() {
        
        if(componentActivity == null) {
            componentActivity = GWT.create(ComponentActivity.Proxy.class);
        }
        
        return componentActivity;
    }
}
