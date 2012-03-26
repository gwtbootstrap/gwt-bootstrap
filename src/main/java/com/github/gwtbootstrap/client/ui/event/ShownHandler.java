package com.github.gwtbootstrap.client.ui.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler interface for {@link ShownEvent} events.
 * 
 * @author Dominik Mayer
 *
 */
public interface ShownHandler extends EventHandler {

  void onShown(ShownEvent event);
}
