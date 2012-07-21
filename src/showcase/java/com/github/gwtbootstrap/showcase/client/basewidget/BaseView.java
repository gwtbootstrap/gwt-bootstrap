package com.github.gwtbootstrap.showcase.client.basewidget;

import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.Section;
import com.github.gwtbootstrap.showcase.client.Buttons;
import com.github.gwtbootstrap.showcase.client.ClientFactory;
import com.github.gwtbootstrap.showcase.client.Forms;
import com.github.gwtbootstrap.showcase.client.HeroUnit;
import com.github.gwtbootstrap.showcase.client.Icons;
import com.github.gwtbootstrap.showcase.client.PageHeader;
import com.github.gwtbootstrap.showcase.client.ProgressBar;
import com.github.gwtbootstrap.showcase.client.Subnav;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
class BaseView extends Composite {

    private static BaseViewUiBinder uiBinder = GWT
            .create(BaseViewUiBinder.class);
    private final ClientFactory clientFactory;

    @UiField
    HTMLPanel container;
    
    interface BaseViewUiBinder extends UiBinder<Widget, BaseView> {
    }

    public BaseView(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        initWidget(uiBinder.createAndBindUi(this));
        
        Subnav subnav = clientFactory.getSubnav();
        
        subnav.clear();
        
        addWidget("Buttons" , "buttons" , new Buttons());
        addWidget("Hero Unit" , "heroUnit", new HeroUnit());
        addWidget("Progress Bar" , "progressBar",new ProgressBar());
        addWidget("Page Header" , "pageHeader", new PageHeader());
        addWidget("Forms" , "forms", new Forms());
        addWidget("Icons" , "icons", new Icons());
        
        subnav.getSpy().configure();

    }

    protected void addWidget(String header , String target, Widget widget) {
        Subnav subnav = clientFactory.getSubnav();

        PlaceHistoryMapper mapper = clientFactory.getPlaceHistoryMapper();
        
        String newTarget = mapper.getToken(clientFactory.getPlaceController().getWhere()).split(":")[0] + ":"  + target;
        
        Section section = new Section(newTarget);
        
        section.add(widget);
        
        container.add(section);
        
        subnav.add(new NavLink(header , "#" + newTarget));
        
    }

}
