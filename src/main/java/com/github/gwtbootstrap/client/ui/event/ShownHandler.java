package com.github.gwtbootstrap.client.ui.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler interface for {@link ShownEvent} events.
 * 
 * @since 2.0.2.1
 * 
 * @author Dominik Mayer
 *
 */
public interface ShownHandler extends EventHandler {

	/**
	 * This method is called when the widget is completely shown.
	 */
	void onShown();
}
