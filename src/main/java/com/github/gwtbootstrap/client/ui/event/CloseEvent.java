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

import com.google.gwt.event.shared.GwtEvent;

/**
 * Represents an event that is fired right before a widget is closed.
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see ClosedEvent
 * 
 */
public class CloseEvent extends GwtEvent<CloseHandler> {

	private static final Type<CloseHandler> TYPE = new Type<CloseHandler>();

	public static Type<CloseHandler> getType() {
		return TYPE;
	}

	public CloseEvent() {
	}

	@Override
	public final Type<CloseHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(CloseHandler handler) {
		handler.onClose(this);
	}

}
