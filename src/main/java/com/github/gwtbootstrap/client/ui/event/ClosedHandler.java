package com.github.gwtbootstrap.client.ui.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler interface for {@link ClosedEvent} events.
 * 
 * @since 2.0.2.1
 * 
 * @author Dominik Mayer
 *
 */
public interface ClosedHandler extends EventHandler {

	/**
	 * This method is called when the has been closed.
	 */
	void onClosed();
}
