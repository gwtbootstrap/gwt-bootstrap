package com.github.gwtbootstrap.client.ui.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Represents an event that is fired when a widget is completely hidden.
 * 
 * @author Dominik Mayer
 * 
 * @see {@link HideEvent}, {@link ShowEvent}, {@link ShownEvent}
 *
 */
public class HiddenEvent extends GwtEvent<HiddenHandler> {

	  private static final Type<HiddenHandler> TYPE = new Type<HiddenHandler>();

	  public static Type<HiddenHandler> getType() {
	    return TYPE;
	  }

	  public HiddenEvent() {
	  }

	  @Override
	  public final Type<HiddenHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(HiddenHandler handler) {
	    handler.onHidden(this);
	  }

	}
