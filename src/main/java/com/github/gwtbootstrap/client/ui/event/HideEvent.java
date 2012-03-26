package com.github.gwtbootstrap.client.ui.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Represents an event that is fired immediately when a widget's 
 * <code>hide()</code> method is called.
 * 
 * @since 2.0.2.1
 * 
 * @author Dominik Mayer
 * 
 * @see {@link HiddenEvent}, {@link ShowEvent}, {@link ShownEvent}
 *
 */
public class HideEvent extends GwtEvent<HideHandler> {

	  private static final Type<HideHandler> TYPE = new Type<HideHandler>();

	  public static Type<HideHandler> getType() {
		  return TYPE;
	  }

	  public HideEvent() {
	  }

	  @Override
	  public final Type<HideHandler> getAssociatedType() {
		  return TYPE;
	  }

	  @Override
	  protected void dispatch(HideHandler handler) {
		  handler.onHide();
	  }

	}
