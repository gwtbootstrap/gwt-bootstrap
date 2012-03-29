/*
 *  Copyright 2012 GWT Bootstrap
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.Close.DataDismiss;
import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.base.HasVisibility;
import com.github.gwtbootstrap.client.ui.base.HasVisibleHandlers;
import com.github.gwtbootstrap.client.ui.base.IsAnimated;
import com.github.gwtbootstrap.client.ui.event.HiddenEvent;
import com.github.gwtbootstrap.client.ui.event.HiddenHandler;
import com.github.gwtbootstrap.client.ui.event.HideEvent;
import com.github.gwtbootstrap.client.ui.event.HideHandler;
import com.github.gwtbootstrap.client.ui.event.ShowEvent;
import com.github.gwtbootstrap.client.ui.event.ShowHandler;
import com.github.gwtbootstrap.client.ui.event.ShownEvent;
import com.github.gwtbootstrap.client.ui.event.ShownHandler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author Carlos A Becker
 * @author Dominik Mayer
 * 
 */
public class Modal extends DivWidget implements HasVisibility,
		HasVisibleHandlers, IsAnimated {

	private final DivWidget header = new DivWidget();
	private final DivWidget body = new DivWidget("modal-body");

	private boolean keyboard = true;
	private boolean backdrop = true;
	private boolean show = false;

	private boolean configured = false;

	public Modal() {
		super("modal");
		super.add(header);
		super.add(body);
		setVisible(false);
		RootPanel.get().add(this);
		setHandlerFunctions();
	}

	public Modal(boolean animated) {
		this();
		setAnimation(animated);
	}

	@Override
	public void setTitle(String title) {
		header.clear();
		if (title == null || title.isEmpty()) {
			showHeader(false);
		} else {
			header.add(new Close(DataDismiss.MODAL));
			header.add(new Heading(title, 3));
			showHeader(true);
		}
	}

	private void showHeader(boolean show) {
		if (show)
			header.setStyleName("modal-header");
		else
			header.removeStyleName("modal-header");
	}

	public void setAnimation(boolean animated) {
		if (animated)
			addStyleName("fade");
		else
			removeStyleName("fade");
	}

	public boolean getAnimation() {
		return getStyleName().contains("fade");
	}

	public void setShow(boolean show) {
		this.show = show;
		reconfigure();
	}

	public void setKeyboard(boolean keyboard) {
		this.keyboard = keyboard;
		reconfigure();
	}

	public void setBackdrop(boolean backdrop) {
		this.backdrop = backdrop;
		reconfigure();
	}

	public void reconfigure() {
		if (configured) {
			configure(getElement(), keyboard, backdrop, show);
		}
	}

	@Override
	public void add(Widget w) {
		if (w instanceof ModalFooter) {
			super.add(w);
		} else
			body.add(w);
	}

	@Override
	public void insert(Widget w, int beforeIndex) {
		body.insert(w, beforeIndex);
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		configure(getElement(), keyboard, backdrop, show);
		configured = true;
	}

	/**
	 * {@inheritDoc}
	 */
	public void show() {
		changeVisibility("show");
	}

	/**
	 * {@inheritDoc}
	 */
	public void hide() {
		changeVisibility("hide");
	}

	/**
	 * {@inheritDoc}
	 */
	public void toggle() {
		changeVisibility("toggle");
	}

	private void changeVisibility(String visibility) {
		changeVisibility(getElement(), visibility);
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addHideHandler(HideHandler handler) {
		addHideHandler(getElement());
		return addHandler(handler, HideEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addHiddenHandler(HiddenHandler handler) {
		addHiddenHandler(getElement());
		return addHandler(handler, HiddenEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addShowHandler(ShowHandler handler) {
		addShowHandler(getElement());
		return addHandler(handler, ShowEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addShownHandler(ShownHandler handler) {
		addShownHandler(getElement());
		return addHandler(handler, ShownEvent.getType());
	}

	private void fireHideEvent() {
		fireEvent(new HideEvent());
	}

	private void fireHiddenEvent() {
		fireEvent(new HiddenEvent());
	}

	private void fireShowEvent() {
		fireEvent(new ShowEvent());
	}

	private void fireShownEvent() {
		fireEvent(new ShownEvent());
	}

	/*
	 * native functions
	 */
	private native void configure(Element e, boolean k, boolean b, boolean s) /*-{
		$wnd.jQuery(e).modal({
			keyboard : k,
			backdrop : b,
			show : s
		});
	}-*/;

	private native void changeVisibility(Element e, String visibility) /*-{
		$wnd.jQuery(e).popover(visibility);
	}-*/;

	/**
	 * Adds the Java functions that fire the Events to document. It is a
	 * convenience method to have a cleaner code later on.
	 */
	private native void setHandlerFunctions() /*-{
		var that = this;
		$wnd.fireHideEvent = $entry(function() {
			that.@com.github.gwtbootstrap.client.ui.Modal::fireHideEvent()();
		});
		$wnd.fireHiddenEvent = $entry(function() {
			that.@com.github.gwtbootstrap.client.ui.Modal::fireHiddenEvent()();
		});
		$wnd.fireShowEvent = $entry(function() {
			that.@com.github.gwtbootstrap.client.ui.Modal::fireShowEvent()();
		});
		$wnd.fireShownEvent = $entry(function() {
			that.@com.github.gwtbootstrap.client.ui.Modal::fireShownEvent()();
		});
	}-*/;

	private native void addHideHandler(Element e) /*-{
		$wnd.jQuery(e).on('hide', function() {
			$wnd.fireHideEvent();
		});
	}-*/;

	private native void addHiddenHandler(Element e) /*-{
		$wnd.jQuery(e).on('hidden', function() {
			$wnd.fireHiddenEvent();
		});
	}-*/;

	private native void addShowHandler(Element e) /*-{
		$wnd.jQuery(e).on('show', function() {
			$wnd.fireShowEvent();
		});
	}-*/;

	private native void addShownHandler(Element e) /*-{
		$wnd.jQuery(e).on('shown', function() {
			$wnd.fireShownEvent();
		});
	}-*/;
}
