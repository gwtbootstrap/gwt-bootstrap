package com.github.gwtbootstrap.showcase.client.layout;

import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.Section;
import com.github.gwtbootstrap.showcase.client.ClientFactory;
import com.github.gwtbootstrap.showcase.client.GridSystem;
import com.github.gwtbootstrap.showcase.client.ResponsiveUtilityView;
import com.github.gwtbootstrap.showcase.client.Subnav;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;


public class LayoutView extends Composite {

	private static LayoutViewUiBinder uiBinder = GWT.create(LayoutViewUiBinder.class);
    private final ClientFactory clientFactory;
    
    @UiField
    HTMLPanel container;
    

	interface LayoutViewUiBinder extends UiBinder<Widget, LayoutView> {
	}

	public LayoutView(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
        initWidget(uiBinder.createAndBindUi(this));
        clientFactory.getSubnav().clear();
        addWidget("Grid System", "gridSystem", new GridSystem());
        addWidget("Responsicve Utilities", "responsiveUtilities", new ResponsiveUtilityView());
        clientFactory.getSubnav().getSpy().configure();
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
