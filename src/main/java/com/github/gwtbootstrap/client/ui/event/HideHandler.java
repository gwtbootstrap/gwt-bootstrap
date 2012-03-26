package com.github.gwtbootstrap.client.ui.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler interface for {@link HideEvent} events.
 * 
 * @since 2.0.2.1
 * 
 * @author Dominik Mayer
 *
 */
public interface HideHandler extends EventHandler {

	/**
	 * This method is called right before a widget is hidden.
	 */
	void onHide();
}
