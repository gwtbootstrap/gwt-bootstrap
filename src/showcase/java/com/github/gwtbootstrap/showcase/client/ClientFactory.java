package com.github.gwtbootstrap.showcase.client;

import com.github.gwtbootstrap.showcase.client.framework.IShowcaseActivity;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory {

    EventBus getEventBus();

    PlaceController getPlaceController();
    
    Subnav getSubnav();
    
    PlaceHistoryMapper getPlaceHistoryMapper();
    
    IShowcaseActivity getLayoutActivity();
    IShowcaseActivity getBaseActivity();
    IShowcaseActivity getComponentActivity();

}
