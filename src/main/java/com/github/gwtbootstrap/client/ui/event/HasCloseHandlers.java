package com.github.gwtbootstrap.client.ui.event;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Interface for widgets that handle {@link CloseEvent}s and 
 * {@link ClosedEvent}s.
 * 
 * @since 2.0.2.1
 * 
 * @author Dominik Mayer
 *
 */
public interface HasCloseHandlers {

	/**
	 * Adds a {@link CloseHandler} to the widget.
	 * 
	 * @param handler the handler
	 * @return {@link HandlerRegistration} used to remove this handler
	 */
	HandlerRegistration addCloseHandler(CloseHandler handler);
	
	/**
	 * Adds a {@link ClosedHandler} to the widget.
	 * 
	 * @param handler the handler
	 * @return {@link HandlerRegistration} used to remove this handler
	 */
	HandlerRegistration addClosedHandler(ClosedHandler handler);
	
}
