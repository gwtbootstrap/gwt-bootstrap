package com.github.gwtbootstrap.client.ui.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Represents an event that is fired when a widget has been closed.
 * 
 * @since 2.0.2.1
 * 
 * @author Dominik Mayer
 * 
 * @see {@link CloseEvent}
 *
 */
public class ClosedEvent extends GwtEvent<ClosedHandler> {

	  private static final Type<ClosedHandler> TYPE = new Type<ClosedHandler>();

	  public static Type<ClosedHandler> getType() {
		  return TYPE;
	  }

	  public ClosedEvent() {
	  }

	  @Override
	  public final Type<ClosedHandler> getAssociatedType() {
		  return TYPE;
	  }

	  @Override
	  protected void dispatch(ClosedHandler handler) {
		  handler.onClosed();
	  }

	}
