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
package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.constants.Alignment;
import com.github.gwtbootstrap.client.ui.constants.Device;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * A simple <code>div</code> widget with support for child widgets.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:DivWidget>
 *     <b:SomeChildWidget />
 *     <b:AnotherChildWidget />
 * </b:DivWidget>}
 * </pre>
 * 
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Carlos Alexandro Becker
 * @author Dominik Mayer
 */
public class DivWidget extends FlowPanel implements HasStyle, IsResponsive, HasId {

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
	 * @param styleName
	 *            the class to be added to the <code>div</code>
	 */
	public DivWidget(String styleName) {
		super();
		setStyleName(styleName);
	}

	/**
	 * Pulls the widget to the right side.
	 * 
	 * @param pullRight
	 *            <code>true</code> if the widget should be aligned right.
	 */
	public void pullRight(boolean pullRight) {
		if (pullRight)
			addStyle(Alignment.RIGHT);
		else
			removeStyle(Alignment.RIGHT);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setStyle(Style style) {
		StyleHelper.setStyle(this, style);
	}

	/**
	 * {@inheritDoc}
	 */
	public void addStyle(Style style) {
		StyleHelper.addStyle(this, style);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeStyle(Style style) {
		StyleHelper.removeStyle(this, style);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setShowOn(Device device) {
		ResponsiveHelper.setShowOn(this, device);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setHideOn(Device device) {
		ResponsiveHelper.setHideOn(this, device);
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return getElement().getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(String id) {
        getElement().setId(id);
    }
}
