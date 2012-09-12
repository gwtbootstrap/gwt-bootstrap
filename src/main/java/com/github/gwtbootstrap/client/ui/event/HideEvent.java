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

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Represents an event that is fired immediately when a widget's
 * <code>hide()</code> method is called.
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see HiddenEvent
 * @see ShowEvent
 * @see ShownEvent
 * 
 */
public class HideEvent extends GwtEvent<HideHandler> {

    private static final Type<HideHandler> TYPE = new Type<HideHandler>();
    private final NativeEvent nativeEvent;

    public static Type<HideHandler> getType() {
        return TYPE;
    }
    
    public HideEvent() {
        this(null);
    }

    public HideEvent(NativeEvent nativeEvent) {
        this.nativeEvent = nativeEvent;
    }

    @Override
    public final Type<HideHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(HideHandler handler) {
        handler.onHide(this);
    }

    /**
     * Prevents the browser from taking its default action for the given event.
     */
    public final void preventDefault() {

        if(nativeEvent == null) return;

        nativeEvent.preventDefault();
    }

    /**
     * Stops the event from being propagated to parent elements.
     */
    public final void stopPropagation() {

        if(nativeEvent == null) return;

        nativeEvent.stopPropagation();
    }

}
