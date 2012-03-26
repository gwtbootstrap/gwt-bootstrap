package com.github.gwtbootstrap.client.ui.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler interface for {@link HiddenEvent} events.
 * 
 * @author Dominik Mayer
 *
 */
public interface HiddenHandler extends EventHandler {

  void onHidden(HiddenEvent event);
}
