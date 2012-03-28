///*
// *  Copyright 2012 GWT Bootstrap
// *
// *  Licensed under the Apache License, Version 2.0 (the "License");
// *  you may not use this file except in compliance with the License.
// *  You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// *  Unless required by applicable law or agreed to in writing, software
// *  distributed under the License is distributed on an "AS IS" BASIS,
// *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// *  See the License for the specific language governing permissions and
// *  limitations under the License.
// */
//package com.github.gwtbootstrap.client.ui;
//
//import com.github.gwtbootstrap.client.ui.Close.DataDismiss;
//import com.github.gwtbootstrap.client.ui.base.DivWidget;
//import com.github.gwtbootstrap.client.ui.base.HoverBase;
//import com.google.gwt.dom.client.Element;
//import com.google.gwt.user.client.ui.RootPanel;
//import com.google.gwt.user.client.ui.Widget;
//
////@formatter:off
///**
// * Popover that 
// * 
// * @since 2.0.2.0
// * 
// * @author Carlos Alexandro Becker
// * 
// * @author Dominik Mayer
// * 
// * @see <a href="http://twitter.github.com/bootstrap/javascript.html#popovers">Bootstrap documentation</a>
// * @see Tooltip
// */
////@formatter:on
//public class Popover extends HoverBase {
//
//	private final DivWidget header = new DivWidget();
//	private final DivWidget body = new DivWidget("modal-body");
//
//	private String content;
//
//	private boolean configured = false;
//
//	public Popover() {
//		super("modal");
//		super.add(header);
//		super.add(body);
//		setVisible(false);
//		RootPanel.get().add(this);
//		setHandlerFunctions();
//	}
//
//	public Popover(boolean animated) {
//		this();
//		setAnimated(animated);
//	}
//
//	@Override
//	public void setTitle(String title) {
//		header.clear();
//		if (title == null || title.isEmpty()) {
//			showHeader(false);
//		} else {
//			header.add(new Close(DataDismiss.MODAL));
//			header.add(new Heading(title, 3));
//			showHeader(true);
//		}
//	}
//
//	private void showHeader(boolean show) {
//		if (show)
//			header.setStyleName("modal-header");
//		else
//			header.removeStyleName("modal-header");
//	}
//
//	public void setAnimated(boolean animated) {
//		if (animated)
//			addStyleName("fade");
//		else
//			removeStyleName("fade");
//	}
//
//	public void setShow(boolean show) {
//		this.show = show;
//		reconfigure();
//	}
//
//	public void setKeyboard(boolean keyboard) {
//		this.keyboard = keyboard;
//		reconfigure();
//	}
//
//	public void setBackdrop(boolean backdrop) {
//		this.backdrop = backdrop;
//		reconfigure();
//	}
//
//	public void reconfigure() {
//		if (configured) {
//			configure(getElement(), keyboard, backdrop, show);
//		}
//	}
//
//	@Override
//	public void add(Widget w) {
//		if (w instanceof ModalFooter) {
//			super.add(w);
//		} else
//			body.add(w);
//	}
//
//	@Override
//	public void insert(Widget w, int beforeIndex) {
//		body.insert(w, beforeIndex);
//	}
//
//	@Override
//	protected void onLoad() {
//		super.onLoad();
//		configure(getElement(), keyboard, backdrop, show);
//		configured = true;
//	}
//
//	/**
//	 * {@inheritDoc}
//	 */
//	public void show() {
//		changeVisibility("show");
//	}
//
//	/**
//	 * {@inheritDoc}
//	 */
//	public void hide() {
//		changeVisibility("hide");
//	}
//
//	/**
//	 * {@inheritDoc}
//	 */
//	public void toggle() {
//		changeVisibility("toggle");
//	}
//
//	private void changeVisibility(String visibility) {
//		changeVisibility(getElement(), visibility);
//	}
//
//	private native void configure(Element e, boolean k, boolean b, boolean s) /*-{
//		$wnd.jQuery(e).modal({
//			keyboard : k,
//			backdrop : b,
//			show : s
//		});
//	}-*/;
//
//	private native void changeVisibility(Element e, String visibility) /*-{
//		$wnd.jQuery(e).modal(visibility);
//	}-*/;
//
//}
