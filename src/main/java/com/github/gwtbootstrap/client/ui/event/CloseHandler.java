package com.github.gwtbootstrap.client.ui.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler interface for {@link CloseEvent} events.
 * 
 * @since 2.0.2.1
 * 
 * @author Dominik Mayer
 *
 */
public interface CloseHandler extends EventHandler {

	/**
	 * This method is called immediately before the widget will be closed.
	 */
	void onClose();
}
