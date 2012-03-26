package com.github.gwtbootstrap.client.ui.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler interface for {@link HiddenEvent} events.
 * 
 * @since 2.0.2.1
 * 
 * @author Dominik Mayer
 *
 */
public interface HiddenHandler extends EventHandler {

	/**
	 * This method is called once the widget is hidden.
	 */
	void onHidden();
}
