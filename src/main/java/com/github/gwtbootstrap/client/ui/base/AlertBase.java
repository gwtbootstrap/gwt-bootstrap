/*
 *  Copyright 2012 GWT-Bootstrap
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
package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.Close;
import com.github.gwtbootstrap.client.ui.constants.AlertType;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.DismissType;
import com.github.gwtbootstrap.client.ui.event.CloseEvent;
import com.github.gwtbootstrap.client.ui.event.CloseHandler;
import com.github.gwtbootstrap.client.ui.event.ClosedEvent;
import com.github.gwtbootstrap.client.ui.event.ClosedHandler;
import com.github.gwtbootstrap.client.ui.event.HasCloseHandlers;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

/**
 * Base class for Alert widgets.
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * @author Carlos Alexandro Becker
 * 
 * @see <a
 *      href="http://twitter.github.com/bootstrap/components.html#alerts">Bootstrap
 *      documentation</a>
 */
public abstract class AlertBase extends HtmlWidget implements IsAnimated, HasCloseHandlers, HasType<AlertType> {

	private Close close;

	private String html = "";

	private String heading = "";

	private boolean fade;
	
	/**
	 * Initializes an Alert with a close icon.
	 */
	public AlertBase() {
		this("", true);
	}
	
	public AlertBase(String html) {
		this(html , true);
	}

	/**
	 * Initializes an Alert with an optional close icon.
	 * 
	 * @param hasClose
	 *            whether the Alert should have a close icon.
	 */
	public AlertBase(String html, boolean hasClose) {
		super("div", html);
		this.html = html;
		super.setStyleName(Constants.ALERT);
		setClose(hasClose);
		setHandlerFunctions(getElement());
	}

	/**
	 * Sets whether the Alert has a close icon or not.
	 * 
	 * @param hasClose
	 *            <code>false</code> if you don't want to have a close icon.
	 *            Default: <code>true</code>
	 */
	public void setClose(boolean hasClose) {
		if (hasClose) {
			close = new Close(DismissType.ALERT);
			add(close);
		} else {
			clear();
			close = null;
		}
		redraw();
	}

	/**
	 * Adds the Java functions that fire the Events to document. It is a
	 * convenience method to have a cleaner code later on.
	 */
	private native void setHandlerFunctions(Element e) /*-{
		var that = this;
		$wnd
				.jQuery(e)
				.bind(
						'close',
						function() {
							that.@com.github.gwtbootstrap.client.ui.base.AlertBase::onClose()();
						});
		$wnd
				.jQuery(e)
				.bind(
						'closed',
						function() {
							that.@com.github.gwtbootstrap.client.ui.base.AlertBase::onClosed()();
						});
	}-*/;

	/**
	 * This method is called immediately when the widget's close method is
	 * executed.
	 */
	protected void onClose() {
		fireEvent(new CloseEvent());
	}

	/**
	 * This method is called once the widget is completely closed.
	 */
	protected void onClosed() {
		fireEvent(new ClosedEvent());
	}

	/**
	 * Initializes an Alert of given Type with a close icon.
	 * 
	 * @param type
	 *            of the Alert
	 */
	public AlertBase(AlertType type) {
		this();
		setType(type);
	}

	/**
	 * Sets the type of the Alert.
	 * 
	 * @param type
	 */
	public void setType(AlertType type) {
		StyleHelper.changeStyle(this, type, AlertType.class);
		setFade();
	}

	/**
	 * Sets the text of an optional heading. The implementation depends on the
	 * subclass.
	 * 
	 * @param text
	 *            the new heading
	 */
	public void setHeading(String text) {
		heading = text;
		redraw();
	}

	/**
	 * Sets whether the Alert should be animated.
	 * 
	 * @param animated
	 *            <code>true</code> if the Alert should fade out. Default:
	 *            <code>false</code>
	 */
	public void setAnimation(boolean animated) {
		this.fade = animated;
		setFade();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean getAnimation() {
		return fade;
	}

	/**
	 * Delete the whole content of the Alert. This includes text, heading and
	 * close icon.
	 */
	@Override
	public void clear() {
		getElement().setInnerHTML("");
	}

	/**
	 * Redraws the Alert according to the specified settings.
	 */
	protected void redraw() {
		setHTML(html);
		configure(getElement());
	}

	/**
	 * Sets the classes that define whether the Alert fades or not.
	 */
	private void setFade() {
		if (fade) {
			addStyleName("fade");
			addStyleName("in");
		} else {
			removeStyleName("fade");
			removeStyleName("in");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return getHTML(); // TODO
	}

	/**
	 * {@inheritDoc}
	 */
	public void setText(String text) {
		setHTML(SafeHtmlUtils.htmlEscape(text));
	}

	/**
	 * {@inheritDoc}
	 */
	public String getHTML() {
		return html;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setHTML(String html) {
		String output = "";
		if (close != null)
			output = close.toString();
		output = output + heading + html;
		setHTMLOutput(html, output);
	}

	/**
	 * Sets the HTML of the Alert. Override this method to implement a custom
	 * formatting.
	 * 
	 * @param html
	 *            the html of the content without heading and close icon.
	 * @param output
	 *            the raw output to be put into the widget. Be careful!
	 */
	protected void setHTMLOutput(String html, String output) {
		this.html = html;
		getElement().setInnerHTML(output);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onLoad() {
		super.onLoad();
		configure(getElement());
	}

	private native void configure(Element e) /*-{
		$wnd.jQuery(e).alert(e);
	}-*/;
	
	/**
	 * Close this alert.
	 */
	public void close() {
		close(getElement());
	}
	
	private native void close(Element e)/*-{
		$wnd.jQuery(e).alert('close');
	}-*/;

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addCloseHandler(CloseHandler handler) {
		return addHandler(handler, CloseEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addClosedHandler(ClosedHandler handler) {
		return addHandler(handler, ClosedEvent.getType());
	}
}
