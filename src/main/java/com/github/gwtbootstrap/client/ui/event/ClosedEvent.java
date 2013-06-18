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
 * Represents an event that is fired when a widget has been closed.
 *
 * @author Dominik Mayer
 * @author Danilo Reinert
 *
 * @see com.google.gwt.event.logical.shared.CloseEvent
 *
 * @since 2.0.4.0
 */
public class ClosedEvent<T> extends GwtEvent<ClosedHandler<T>> {

    private static final Type<ClosedHandler<?>> TYPE = new Type<ClosedHandler<?>>();

    public static Type<ClosedHandler<?>> getType() {
        return TYPE;
    }

    /**
     * Fires a closed event on all registered handlers in the handler manager. If
     * no such handlers exist, this method will do nothing.
     *
     * @param <T>    the target type
     * @param source the source of the handlers
     * @param target the target
     */
    public static <T> void fire(HasCloseHandlers<T> source, T target) {
        fire(source, target, false);
    }

    /**
     * Fires a closed event on all registered handlers in the handler manager.
     *
     * @param <T>        the target type
     * @param source     the source of the handlers
     * @param target     the target
     * @param autoClosed was the target closed automatically
     */
    public static <T> void fire(HasCloseHandlers<T> source, T target,
                                boolean autoClosed) {
        if (TYPE != null) {
            ClosedEvent<T> event = new ClosedEvent<T>(target, autoClosed);
            source.fireEvent(event);
        }
    }

    private final T target;
    private final boolean autoClosed;

    public ClosedEvent(T target, boolean autoClosed) {
        this.target = target;
        this.autoClosed = autoClosed;
    }

    // The instance knows its of type T, but the TYPE
    // field itself does not, so we have to do an unsafe cast here.
    @SuppressWarnings("unchecked")
    @Override
    public final Type<ClosedHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    public T getTarget() {
        return target;
    }

    public boolean isAutoClosed() {
        return autoClosed;
    }

    @Override
    protected void dispatch(ClosedHandler handler) {
        handler.onClosed(this);
    }

}
