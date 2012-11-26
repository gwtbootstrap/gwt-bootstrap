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
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HasIcon;
import com.github.gwtbootstrap.client.ui.base.IconAnchor;
import com.github.gwtbootstrap.client.ui.base.ListItem;
import com.github.gwtbootstrap.client.ui.constants.*;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off
/**
 * A Container for Widgets in a Nav context (Navbar, NavList, ...). Example:<br>
 * <br>
 * 
 * {@code <b:NavWidget text="Inbox"><b:Badge /></b:NavWidget>}
 * 
 * @since 2.0.4.0
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#navbar">Bootstrap documentation (Navbar)</a>
 * @see <a href="http://twitter.github.com/bootstrap/components.html#navs">Bootstrap documentation (Navs)</a>
 * @see NavList
 * @see WellNavList
 * @see Dropdown
 * @see Navbar
 * @see ResponsiveNavbar
 */
//@formatter:on
public class NavWidget extends ListItem implements HasClickHandlers, HasIcon {

	private final IconAnchor anchor = new IconAnchor();

	public NavWidget() {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIcon(IconType type) {
        setBaseIcon(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBaseIcon(BaseIconType type) {
        anchor.setBaseIcon(type);
    }

    @Override
    public void setIconSize(IconSize size) {
        anchor.setIconSize(size);
    }

	public void setActive(boolean active) {

		if (active)
			addStyleName(Constants.ACTIVE);
		else
			removeStyleName(Constants.ACTIVE);
	}
	
	public boolean isActive() {
		return this.getStyleName().contains(Constants.ACTIVE);
	}

	public void setDisabled(boolean disabled) {
		
		if (disabled)
			addStyleName(Constants.DISABLED);
		else
			removeStyleName(Constants.DISABLED);
		
		anchor.setEnabled(!disabled);
	}
	
	public boolean isDisabled() {
		return !anchor.isEnabled();
	}

	public IconAnchor getAnchor() {
		return anchor;
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return anchor.addDomHandler(handler, ClickEvent.getType());
	}

	/**
	 * Add widget to inner anchor
	 * {@inheritDoc}
	 */
	@Override
	public void add(Widget w) {
		anchor.add(w);
	}
	
	/**
	 * Add widget to this widget
	 * @param w
	 */
	@UiChild(tagname="widget")
	public void addWidget(Widget w) {
	    super.add(w);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		anchor.clear();
	}
	
	/**
	 * Set anchor target attribute.
	 * @param target target name
	 */
	public void setTarget(String target) {
	    anchor.setTarget(target);
	}
	
	/**
	 * Get anchor target attribute.
	 * @return target name
	 */
	public String getTarget() {
	    return anchor.getTarget();
	}
	
	/**
	 * Set anchor name
	 * @param name anchor name
	 */
	public void setName(String name) {
	    anchor.setName(name);
	}
	
	/**
	 * Get anchor name
	 * @return anchor name
	 */
	public String getName() {
	    return anchor.getName();
	}

    @Override
    public void setCustomIconStyle(String customIconStyle) {
        anchor.setCustomIconStyle(customIconStyle);
    }

    @Override
    public void setIconPosition(IconPosition position) {
        anchor.setIconPosition(position);
    }
}
