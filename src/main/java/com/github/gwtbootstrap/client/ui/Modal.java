package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.Close.DataDismiss;
import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.base.HasAnimateProperty;
import com.github.gwtbootstrap.client.ui.base.HasVisibleHandlers;
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
 * 
 */
public class Modal extends DivWidget implements HasVisibleHandlers,
		HasAnimateProperty {

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
		setAnimated(animated);
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

	public void setAnimated(boolean animated) {
		if (animated)
			addStyleName("fade");
		else
			removeStyleName("fade");
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
		if(w instanceof ModalFooter) {
			super.add(w);
		} else body.add(w);
	}
	
	@Override
	public void insert(Widget w, int beforeIndex) {
		body.insert(w, beforeIndex);
//		throw new UnsupportedOperationException("You can only add Widgets via " +
//				"\"add(Widget w)\"");
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		configure(getElement(), keyboard, backdrop, show);
		configured = true;
	}
	
//	@Override
//	public void sinkEvents(int eventBitsToAdd) {
//		body.sinkEvents(eventBitsToAdd);
//	}
	
	public void show() {
		changeVisibility("show");
	}

	public void hide() {
		changeVisibility("hide");
	}

	public void toggle() {
		changeVisibility("toggle");
	}
	
	private void changeVisibility(String visibility) {
		changeVisibility(getElement(), visibility);
	}
	
	public HandlerRegistration addHideHandler(HideHandler handler) {
		addHideHandler(getElement());
		return addHandler(handler, HideEvent.getType());
	}
	
	public HandlerRegistration addHiddenHandler(HiddenHandler handler) {
		addHiddenHandler(getElement());
		return addHandler(handler, HiddenEvent.getType());
	}
	
	public HandlerRegistration addShowHandler(ShowHandler handler) {
		addShowHandler(getElement());
		return addHandler(handler, ShowEvent.getType());
	}
	
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
		$wnd.jQuery(e).modal(visibility);
	}-*/;
	
	private native void setHandlerFunctions() /*-{
		var that = this;
		$wnd.fireHideEvent = $entry(function() {
          that.@com.github.gwtbootstrap.client.ui.Modal::fireHideEvent()();});
		$wnd.fireHiddenEvent = $entry(function() {
          that.@com.github.gwtbootstrap.client.ui.Modal::fireHiddenEvent()();});
		$wnd.fireShowEvent = $entry(function() {
          that.@com.github.gwtbootstrap.client.ui.Modal::fireShowEvent()();});
		$wnd.fireShownEvent = $entry(function() {
          that.@com.github.gwtbootstrap.client.ui.Modal::fireShownEvent()();});
	}-*/;

	private native void addHideHandler(Element e) /*-{
		$wnd.jQuery(e).on('hide', function() {
			$wnd.fireHideEvent();
		} );
	}-*/;

	private native void addHiddenHandler(Element e) /*-{
		$wnd.jQuery(e).on('hidden', function() {
			$wnd.fireHiddenEvent();
		} );
	}-*/;
	
	private native void addShowHandler(Element e) /*-{
		$wnd.jQuery(e).on('show', function() {
			$wnd.fireShowEvent();
		} );
	}-*/;
	
	private native void addShownHandler(Element e) /*-{
		$wnd.jQuery(e).on('shown', function() {
			$wnd.fireShownEvent();
		} );
	}-*/;
}
