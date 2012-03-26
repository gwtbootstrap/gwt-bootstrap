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
public class ShowEvent extends GwtEvent<ShowHandler> {

	  private static final Type<ShowHandler> TYPE = new Type<ShowHandler>();

	  public static Type<ShowHandler> getType() {
		  return TYPE;
	  }

	  public ShowEvent() {
	  }

	  @Override
	  public final Type<ShowHandler> getAssociatedType() {
		  return TYPE;
	  }

	  @Override
	  protected void dispatch(ShowHandler handler) {
		  handler.onShow();
	  }

	}
