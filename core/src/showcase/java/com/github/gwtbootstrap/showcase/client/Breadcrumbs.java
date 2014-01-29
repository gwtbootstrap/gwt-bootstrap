package com.github.gwtbootstrap.showcase.client;

import com.github.gwtbootstrap.client.ui.ControlGroup;
import com.github.gwtbootstrap.client.ui.HelpInline;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.constants.ControlGroupType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Breadcrumbs extends Composite {
    
    @UiField
    com.github.gwtbootstrap.client.ui.Breadcrumbs bread1,bread2;
    
    @UiField
    TextBox text;
    
    @UiField
    ControlGroup addWidgetCG;
    
    @UiField
    HelpInline addText;

    private static BreadcrumbsUiBinder uiBinder = GWT
            .create(BreadcrumbsUiBinder.class);

    interface BreadcrumbsUiBinder extends UiBinder<Widget, Breadcrumbs> {
    }

    public Breadcrumbs() {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @UiHandler("divider")
    public void onChangeDivider(ValueChangeEvent<String> e) {
        bread2.setDivider(e.getValue());
        bread1.setDivider(e.getValue());
    }
    
    @UiHandler("add")
    public void onClickAdd(ClickEvent e) {
        
        addWidgetCG.setType(ControlGroupType.NONE);
        addText.setText("");
        
        if(text.getValue() == null || text.getValue().isEmpty()) {
            addWidgetCG.setType(ControlGroupType.ERROR);
            addText.setText("Should set text");
            return;
        }
        
        bread1.add(new NavLink(text.getValue()));
        bread2.add(new NavLink(text.getValue()));
    }
    
    @UiHandler("remove")
    public void onClickRemove(ClickEvent e) {
        bread1.remove(bread1.getWidgetCount() -1);
        bread2.remove(bread2.getWidgetCount() -1);
    }
    
    

}
