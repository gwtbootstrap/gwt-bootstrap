package com.github.gwtbootstrap.client.ui.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler interface for {@link ShowEvent} events.
 * 
 * @author Dominik Mayer
 *
 */
public interface ShowHandler extends EventHandler {

  void onShow(ShowEvent event);
}
