package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.event.HiddenEvent;
import com.github.gwtbootstrap.client.ui.event.HiddenHandler;
import com.github.gwtbootstrap.client.ui.event.HideEvent;
import com.github.gwtbootstrap.client.ui.event.HideHandler;
import com.github.gwtbootstrap.client.ui.event.ShowEvent;
import com.github.gwtbootstrap.client.ui.event.ShowHandler;
import com.github.gwtbootstrap.client.ui.event.ShownEvent;
import com.github.gwtbootstrap.client.ui.event.ShownHandler;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 * Interface that defines a component has can be show or hidden.
 * 
 * @author Carlos A Becker
 *
 */
public interface HasVisibleHandlers {
	void show();

	void hide();

	void toggle();
	
	HandlerRegistration addHideHandler(HideHandler handler);
	
	HandlerRegistration addHiddenHandler(HiddenHandler handler);
	
	HandlerRegistration addShowHandler(ShowHandler handler);
	
	HandlerRegistration addShownHandler(ShownHandler handler);
}
