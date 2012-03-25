package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.Close.DataDismiss;
import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.base.HasAnimateProperty;
import com.github.gwtbootstrap.client.ui.base.HasVisibleHandlers;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Event;
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
//		sinkEvents(Event.MOUSEEVENTS);
//		body.sinkEvents(Event.MOUSEEVENTS);//Event.getTypeInt(MouseOverEvent.getType().getName()));
		setVisible(false);
	}
	
//	@Override
//	public void onBrowserEvent(Event event) {
//		body.onBrowserEvent(event);
//	}
	
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
	
	@Override
	public void sinkEvents(int eventBitsToAdd) {
		body.sinkEvents(eventBitsToAdd);
	}
	
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
}
