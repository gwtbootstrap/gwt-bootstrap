package com.github.gwtbootstrap.showcase.client.overview;

import com.github.gwtbootstrap.showcase.client.Subnav;
import com.github.gwtbootstrap.showcase.client.framework.AbstractShowcaseActivity;
import com.github.gwtbootstrap.showcase.client.framework.IShowcaseActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.AsyncProxy;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HTMLPanel;

public class OverviewActivity extends AbstractShowcaseActivity {

    @AsyncProxy.ConcreteType(OverviewActivity.class)
    @AsyncProxy.AllowNonVoid
    public interface Proxy extends AsyncProxy<IShowcaseActivity> , IShowcaseActivity {};

    
    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {

        Subnav subnav = clientFactory.getSubnav();
        subnav.clear();
        subnav.setVisible(false);
        panel.setWidget(new HTMLPanel(""));
        
    }
    
    

}
