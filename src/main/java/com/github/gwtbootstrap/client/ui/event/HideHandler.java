package com.github.gwtbootstrap.client.ui.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler interface for {@link HideEvent} events.
 * 
 * @author Dominik Mayer
 *
 */
public interface HideHandler extends EventHandler {

  void onHide(HideEvent event);
}
