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

    private EventBus eventBus = new SimpleEventBus();
    
    private PlaceController placeController = new PlaceController(eventBus);
    
    private PlaceHistoryMapper placeHistoryMapper = GWT.create(AppPlaceHistoryMapper.class);
    
    private Subnav subnav = new Subnav();
    
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
