/*
 *  Copyright 2012 GWT Bootstrap
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
package com.github.gwtbootstrap.client.ui.base;

import com.google.gwt.user.client.ui.FlowPanel;

/**
 * A simple <code>div</code> widget with support for child widgets.
 *
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>{@code
 * <b:DivWidget>
 *     <b:SomeChildWidget />
 *     <b:AnotherChildWidget />
 * </b:DivWidget>}
 * </pre>
 * </p>
 * 
 * @since 2.0.2.0
 *
 * @author Carlos A Becker
 * @author Dominik Mayer
 */
public class DivWidget extends FlowPanel implements HasStyle, IsResponsive {

	/**
	 * Creates an empty widget.
	 */
    public DivWidget() {
    	super();
    }
    
    /**
     * Creates a widget and sets the provided style name. Technically it 
     * replaces the <code>div<code>s <code>class</code> property with the
     * provided String.
     * 
     * @param styleName the class to be added to the <code>div</code>
     */
    public DivWidget(String styleName) {
    	super();
    	setStyleName(styleName);
    }
    
    /**
     * {@inheritDoc}
     */
    public void setStyle(Style style) {
    	setStyleName(style.get());
    }
    
    /**
     * {@inheritDoc}
     */
    public void addStyle(Style style) {
    	addStyleName(style.get());
    }
    
    /**
     * {@inheritDoc} 
     */
    public void removeStyle(Style style) {
    	String styleString = style.get(); 
    	if (!styleString.isEmpty())
    		removeStyleName(styleString);
    }

    /**
     * {@inheritDoc}
     */
	public void setShowOnPhone(boolean show) {
		if (show)
			addStyle(IsResponsive.ResponsiveStyle.VISIBLE_PHONE);
		else
			removeStyle(IsResponsive.ResponsiveStyle.VISIBLE_PHONE);
	}

    /**
     * {@inheritDoc}
     */
	public boolean isShownOnPhone() {
		return getStyleName().contains(
				IsResponsive.ResponsiveStyle.VISIBLE_PHONE.get());
	}
    
    /**
     * {@inheritDoc}
     */
	public void setHideOnPhone(boolean hide) {
		if (hide)
			addStyle(IsResponsive.ResponsiveStyle.HIDDEN_PHONE);
		else
			removeStyle(IsResponsive.ResponsiveStyle.HIDDEN_PHONE);
	}

    /**
     * {@inheritDoc}
     */
	public boolean isHiddenOnPhone() {
		return getStyleName().contains(
				IsResponsive.ResponsiveStyle.HIDDEN_PHONE.get());
	}
	
    /**
     * {@inheritDoc}
     */
	public void setShowOnTablet(boolean show) {
		if (show)
			addStyle(IsResponsive.ResponsiveStyle.VISIBLE_TABLET);
		else
			removeStyle(IsResponsive.ResponsiveStyle.VISIBLE_TABLET);
	}

    /**
     * {@inheritDoc}
     */
	public boolean isShownOnTablet() {
		return getStyleName().contains(
				IsResponsive.ResponsiveStyle.VISIBLE_TABLET.get());
	}
	
    /**
     * {@inheritDoc}
     */
	public void setHideOnTablet(boolean hide) {
		if (hide)
			addStyle(IsResponsive.ResponsiveStyle.HIDDEN_TABLET);
		else
			removeStyle(IsResponsive.ResponsiveStyle.HIDDEN_TABLET);
	}

    /**
     * {@inheritDoc}
     * 
     */
	public boolean isHiddenOnTablet() {
		return getStyleName().contains(
				IsResponsive.ResponsiveStyle.HIDDEN_TABLET.get());
	}
	
    /**
     * {@inheritDoc}
     */
	public void setShowOnDesktop(boolean show) {
		if (show)
			addStyle(IsResponsive.ResponsiveStyle.VISIBLE_DESKTOP);
		else
			removeStyle(IsResponsive.ResponsiveStyle.VISIBLE_DESKTOP);
	}

    /**
     * {@inheritDoc}
     */
	public boolean isShownOnDesktop() {
		return getStyleName().contains(
				IsResponsive.ResponsiveStyle.VISIBLE_DESKTOP.get());
	}
	
    /**
     * {@inheritDoc}
     */
	public void setHideOnDesktop(boolean hide) {
		if (hide)
			addStyle(IsResponsive.ResponsiveStyle.HIDDEN_DESKTOP);
		else
			removeStyle(IsResponsive.ResponsiveStyle.HIDDEN_DESKTOP);
	}

    /**
     * {@inheritDoc}
     */
	public boolean isHiddenOnDesktop() {
		return getStyleName().contains(
				IsResponsive.ResponsiveStyle.HIDDEN_DESKTOP.get());
	}

}
