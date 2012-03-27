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

import com.github.gwtbootstrap.client.ui.event.HiddenHandler;
import com.github.gwtbootstrap.client.ui.event.HideEvent;
import com.github.gwtbootstrap.client.ui.event.HideHandler;
import com.github.gwtbootstrap.client.ui.event.ShowHandler;
import com.github.gwtbootstrap.client.ui.event.ShownHandler;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Interface for components that can be shown or hidden.
 * 
 * @since 2.0.2.0
 * 
 * @author Carlos Alexandro Becker
 * @author Dominik Mayer
 *
 */
public interface HasVisibleHandlers {
	
	/**
	 * Shows the widget if it was previously hidden.
	 */
	void show();

	/**
	 * Hides the widget if it was previously shown.
	 */
	void hide();

	/**
	 * Toggles the view state of the widget.
	 * 
	 * <p>
	 * It will be hidden if it was previously shown and shown if it was 
	 * previously hidden.
	 */
	void toggle();
	
	/**
	 * Adds a {@link HideEvent} handler.
	 * 
	 * @param handler the hide handler
	 * 
	 * @returns {@link HandlerRegistration} used to remove this handler
	 */
	HandlerRegistration addHideHandler(HideHandler handler);
	
	/**
	 * Adds a {@link HiddenEvent} handler.
	 * 
	 * @param handler the hidden handler
	 * 
	 * @returns {@link HandlerRegistration} used to remove this handler
	 */
	HandlerRegistration addHiddenHandler(HiddenHandler handler);
	
	/**
	 * Adds a {@link ShowEvent} handler.
	 * 
	 * @param handler the show handler
	 * 
	 * @returns {@link HandlerRegistration} used to remove this handler
	 */
	HandlerRegistration addShowHandler(ShowHandler handler);
	
	/**
	 * Adds a {@link ShownEvent} handler.
	 * 
	 * @param handler the shown handler
	 * 
	 * @returns {@link HandlerRegistration} used to remove this handler
	 */
	HandlerRegistration addShownHandler(ShownHandler handler);
}
