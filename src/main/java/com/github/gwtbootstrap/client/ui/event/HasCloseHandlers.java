/*
 *  Copyright 2013 GWT-Bootstrap
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

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Interface for widgets that handle {@link com.google.gwt.event.logical.shared.CloseEvent}s and {@link ClosedEvent}s.
 *
 * @author Dominik Mayer
 * @author Danilo Reinert
 *
 * @since 2.0.4.0
 */
public interface HasCloseHandlers<T> extends com.google.gwt.event.logical.shared.HasCloseHandlers<T> {

    /**
     * Adds a {@link ClosedHandler} to the widget.
     *
     * @param handler the handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addClosedHandler(ClosedHandler<T> handler);

}
