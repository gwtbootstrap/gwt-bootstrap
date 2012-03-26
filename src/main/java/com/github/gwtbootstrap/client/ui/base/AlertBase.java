package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.Close;
import com.github.gwtbootstrap.client.ui.event.CloseEvent;
import com.github.gwtbootstrap.client.ui.event.CloseHandler;
import com.github.gwtbootstrap.client.ui.event.ClosedEvent;
import com.github.gwtbootstrap.client.ui.event.ClosedHandler;
import com.github.gwtbootstrap.client.ui.event.HasCloseHandlers;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap.AlertStyle;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasHTML;

/**
 * Base class for Alert widgets.
 * 
 * @since 2.0.2.1
 * 
 * @author Dominik Mayer
 * @author Carlos Alexandro Becker
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#alerts">Bootstrap documentation</a>
 */
public abstract class AlertBase extends DivWidget implements HasHTML,
		IsAnimated, HasCloseHandlers {

	private Close close;

	private String html = "";

	private String heading = "";

	private boolean fade;

	/**
	 * Initializes an Alert with a close icon.
	 */
	public AlertBase() {
		this(true);
	}

	/**
	 * Initializes an Alert with an optional close icon.
	 * 
	 * @param hasClose whether the Alert should have a close icon.
	 */
	public AlertBase(boolean hasClose) {
		super.setStyle(AlertStyle.ALERT);
		setClose(hasClose);
		setHandlerFunctions();
	}
	
	/**
	 * Sets whether the Alert has a close icon or not.
	 * 
	 * @param hasClose <code>false</code> if you don't want to have a close icon.
	 * Default: <code>true</code> 
	 */
	public void setClose(boolean hasClose) {
		if (hasClose) {
			close = new Close(Close.DataDismiss.ALERT);
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
	private native void setHandlerFunctions() /*-{
		var that = this;
		$wnd.fireCloseEvent = $entry(function() {
          that.@com.github.gwtbootstrap.client.ui.base.AlertBase::fireCloseEvent()();});
		$wnd.fireClosedEvent = $entry(function() {
          that.@com.github.gwtbootstrap.client.ui.base.AlertBase::fireClosedEvent()();});
	}-*/;

	private void fireCloseEvent() {
		fireEvent(new CloseEvent());
	}

	private void fireClosedEvent() {
		fireEvent(new ClosedEvent());
	}

	/**
	 * Initializes an Alert with a close icon and the given style. 
	 * 
	 * @param style of the Alert
	 */
	public AlertBase(AlertStyle style) {
		this();
		setType(style);
	}

	/**
	 * Sets the type of the Alert.
	 * 
	 * @param style
	 */
	public void setType(AlertStyle style) {
		super.setStyle(Bootstrap.AlertStyle.ALERT);
		super.addStyle(style);
	}
	
	/**
	 * Sets the type of the Alert based on the Bootstrap class name.
	 * 
	 * @param typeName name of the class to add without the leading "alert-".
	 * 
	 * @deprecated This Method should never be called directly. It will break
	 * your implementation if any style names change. The only valid use is 
	 * inside UiBinder files where it processes the <code>style="..."</code>
	 * argument.
	 */
	@Deprecated
	public void setType(String typeName) {
		if (typeName.equalsIgnoreCase("error"))
			setType(Bootstrap.AlertStyle.ERROR);
		else if (typeName.equalsIgnoreCase("success"))
			setType(Bootstrap.AlertStyle.SUCCESS);
		else if (typeName.equalsIgnoreCase("info"))
			setType(Bootstrap.AlertStyle.INFO);

		setFade();
	}

	/**
	 * Sets the text of an optional heading. The implementation depends on the
	 * subclass.
	 * 
	 * @param text the new heading
	 */
	public void setHeading(String text) {
		heading = text;
		redraw();
	}

	/**
	 * Sets whether the Alert should be animated.
	 * 
	 * @param animated <code>true</code> if the Alert should fade out.
	 * Default: <code>false</code>
	 */
	public void setAnimated(boolean animated) {
		this.fade = animated;
		setFade();
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
		setHTML(text); // TODO
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
	 * @param html the html of the content without heading and close icon.  
	 * @param output the raw output to be put into the widget. Be careful!
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
	 * {@inheritDoc}
	 */
	public HandlerRegistration addCloseHandler(CloseHandler handler) {
		addCloseHandler(getElement());
		return addHandler(handler, CloseEvent.getType());
	}
	
	private native void addCloseHandler(Element e) /*-{
		$wnd.jQuery(e).bind('close', function() {
			$wnd.fireCloseEvent();
		} );
	}-*/;
	
	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addClosedHandler(ClosedHandler handler) {
		addClosedHandler(getElement());
		return addHandler(handler, ClosedEvent.getType());
	}

	private native void addClosedHandler(Element e) /*-{
		$wnd.jQuery(e).bind('closed', function() {
			$wnd.fireClosedEvent();
		} );
	}-*/;
}
