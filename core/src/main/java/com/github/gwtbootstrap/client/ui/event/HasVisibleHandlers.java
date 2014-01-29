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
package com.github.gwtbootstrap.client.ui.event;

import com.github.gwtbootstrap.client.ui.event.HiddenEvent;
import com.github.gwtbootstrap.client.ui.event.HiddenHandler;
import com.github.gwtbootstrap.client.ui.event.HideEvent;
import com.github.gwtbootstrap.client.ui.event.HideHandler;
import com.github.gwtbootstrap.client.ui.event.ShowEvent;
import com.github.gwtbootstrap.client.ui.event.ShowHandler;
import com.github.gwtbootstrap.client.ui.event.ShownEvent;
import com.github.gwtbootstrap.client.ui.event.ShownHandler;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Interface for components that can trigger actions when they are shown or
 * hidden.
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 */
public interface HasVisibleHandlers {

	/**
	 * Adds a {@link HideEvent} handler.
	 * 
	 * @param handler
	 *            the hide handler
	 * 
	 * @return {@link HandlerRegistration} used to remove this handler
	 */
	HandlerRegistration addHideHandler(HideHandler handler);

	/**
	 * Adds a {@link HiddenEvent} handler.
	 * 
	 * @param handler
	 *            the hidden handler
	 * 
	 * @return {@link HandlerRegistration} used to remove this handler
	 */
	HandlerRegistration addHiddenHandler(HiddenHandler handler);

	/**
	 * Adds a {@link ShowEvent} handler.
	 * 
	 * @param handler
	 *            the show handler
	 * 
	 * @return {@link HandlerRegistration} used to remove this handler
	 */
	HandlerRegistration addShowHandler(ShowHandler handler);

	/**
	 * Adds a {@link ShownEvent} handler.
	 * 
	 * @param handler
	 *            the shown handler
	 * 
	 * @return {@link HandlerRegistration} used to remove this handler
	 */
	HandlerRegistration addShownHandler(ShownHandler handler);
}
