package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.Close.DataDismiss;
import com.geekvigarista.gwt.bootstrap.client.ui.base.DivWidget;
import com.geekvigarista.gwt.bootstrap.client.ui.base.HasAnimateProperty;
import com.geekvigarista.gwt.bootstrap.client.ui.base.HasVisibleHandlers;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author Carlos A Becker
 * 
 */
public class Modal extends DivWidget implements HasVisibleHandlers,
		HasAnimateProperty {

	private final DivWidget header;
	private final DivWidget body;
	private final DivWidget footer;

	private boolean keyboard = true;
	private boolean backdrop = true;
	private boolean show = false;

	private boolean configured = false;

	{
		setStyleName("modal");
		header = new DivWidget("modal-header");
		body = new DivWidget("modal-body");
		footer = new DivWidget("modal-footer");
		super.add(header);
		super.add(body);
		super.add(footer);
		setVisible(false);
	}

	public @UiConstructor
	Modal() {
		
	}

	public void setTitle(String title) {
		header.clear();
		header.add(new Close(DataDismiss.MODAL));
		header.add(new Heading(title, 3));
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
		body.add(w);
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		configure(getElement(), keyboard, backdrop, show);
		configured = true;
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
