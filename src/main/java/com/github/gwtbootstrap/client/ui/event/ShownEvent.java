package com.github.gwtbootstrap.client.ui.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Represents an event that is fired immediately when a widget's 
 * <code>show()</code> method is called.
 * 
 * @since 2.0.2.1
 * 
 * @author Dominik Mayer
 * 
 * @see {@link ShownEvent}, {@link HideEvent}, {@link HiddenEvent}
 *
 */
public class ShownEvent extends GwtEvent<ShownHandler> {

	  private static final Type<ShownHandler> TYPE = new Type<ShownHandler>();

	  public static Type<ShownHandler> getType() {
		  return TYPE;
	  }

	  public ShownEvent() {
	  }

	  @Override
	  public final Type<ShownHandler> getAssociatedType() {
		  return TYPE;
	  }

	  @Override
	  protected void dispatch(ShownHandler handler) {
		  handler.onShown();
	  }

	}
