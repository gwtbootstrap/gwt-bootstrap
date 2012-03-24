package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.IconAnchor;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

/**
 * A Container for Widgets in a Nav context (Navbar, NavList, ...). Example:<br><br>
 * 
 * {@code <b:NavWidget text="Inbox"><b:Badge /></b:NavWidget>}
 * 
 * @author Dominik Mayer
 */
public class NavWidget extends ListItem implements HasClickHandlers {

	private final IconAnchor anchor = new IconAnchor();
	
	public NavWidget() {
//		this("");
		super.add(anchor);
	}
	
	public NavWidget(Widget w) {
		this();
		add(w);
	}
    
	public void setHref(String href) {
		anchor.setHref(href);
	}
	
	public void setTargetHistoryToken(String targetHistoryToken) {
		anchor.setTargetHistoryToken(targetHistoryToken);
	}
	
	public void setText(String text) {
		anchor.setText(text);
	}

	public String getText() {
		return anchor.getText();
	}
	
    public void setIcon(String iconname) {
    	anchor.setIcon(iconname);
    }
    
    public void setIconColor(String color) {
    	anchor.setIconColor(color);
    }
    
    public void setActive(boolean active) {
    	if (active)
    		addStyleName(Bootstrap.active);
    	else
    		removeStyleName(Bootstrap.active);
    }
    
    public void setDisabled(boolean disabled) {
    	if (disabled)
    		addStyleName(Bootstrap.disabled);
    	else
    		removeStyleName(Bootstrap.disabled);
    }
    
    protected IconAnchor getAnchor() {
    	return anchor;
    }

	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}
	
	@Override
	public void add(Widget w) {
		anchor.add(w);
	}
}
