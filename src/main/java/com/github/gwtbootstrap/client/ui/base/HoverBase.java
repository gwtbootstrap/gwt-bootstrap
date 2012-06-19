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

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.github.gwtbootstrap.client.ui.constants.Placement;
import com.github.gwtbootstrap.client.ui.constants.Trigger;
import com.github.gwtbootstrap.client.ui.constants.VisibilityChange;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off
/**
* Base class for widgets that hover above other widgets.
* 
* @since 2.0.4.0
* 
* @author Dominik Mayer
* 
* @see <a href="http://twitter.github.com/bootstrap/javascript.html#popovers">Bootstrap documentation</a>
*/
//@formatter:on
public abstract class HoverBase extends ComplexWidget implements HasWidgets, HasOneWidget, IsAnimated, HasTrigger, HasPlacement, HasText, HasShowDelay, HasVisibility {

	Widget widget;

	/**
	 * Whether the widget is animated or not.
	 */
	protected boolean animated = true;

	/**
	 * The placement of the widget relative to its trigger element.
	 */
	protected Placement placement = Placement.TOP;

	/**
	 * The action that triggers the widget.
	 */
	protected Trigger trigger = Trigger.HOVER;

	/**
	 * The delay until the widget is shown.
	 */
	protected int showDelayInMilliseconds = 0;

	/**
	 * The delay until the widget is hidden.
	 */
	protected int hideDelayInMilliseconds = 0;

	/**
	 * Creates a new widget based on the provided HTML tag.
	 */
	public HoverBase() {
		super("span");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onLoad() {
		super.onLoad();
		
		removeDataIfExists();
		
		reconfigure();
	}
	
	protected void removeDataIfExists() {
		removeDataIfExists(getWidget().getElement(), getDataName());
	}
	
	protected native void removeDataIfExists(Element e, String dataName) /*-{
		if($wnd.jQuery(e).data(dataName)) {
			var data = $wnd.jQuery(e).data(dataName);
			var eventIn, eventOut;
			if (data.options.trigger != 'manual') {
				eventIn  = data.options.trigger == 'hover' ? 'mouseenter' : 'focus'
				eventOut = data.options.trigger == 'hover' ? 'mouseleave' : 'blur'
				data.$element.off(eventIn);
				data.$element.off(eventOut);
			}
			$wnd.jQuery(e).removeData(dataName);
		}
	}-*/;

	/**
	 * Adds an HTML data attribute to the widget's tag.
	 * 
	 * @param e target element
	 * 
	 * @param attribute
	 *            the name of the attribute without leading <code>"data-"</code>
	 * @param value
	 *            the value to be stored
	 */
	protected void setDataAttribute(Element e , String attribute, String value) {
		e.setAttribute("data-" + attribute, value);
	}

	/**
	 * Returns the data stored in one of the widget's HTML data attributes.
	 * 
	 * @param attribute
	 *            the name of the attribute without leading <code>"data-"</code>
	 * @return the value stored in the tag
	 */
	protected String getDataAttribute(String attribute) {
		return getElement().getAttribute("data-" + attribute);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setAnimation(boolean animated) {
		this.animated = animated;
	}

	/**
	 * Redraws the widget with the currently set options. This must <b>not</b>
	 * be called when a parameter is updated because it would deactivate all
	 * other parameters. No idea why...
	 */
	public abstract void reconfigure();

	/**
	 * {@inheritDoc}
	 */
	public boolean getAnimation() {
		return animated;
	}

	/**
	 * {@inheritDoc} Relative to its trigger element.
	 */
	public void setPlacement(Placement placement) {
		this.placement = placement;
	}

	/**
	 * {@inheritDoc}
	 */
	public Placement getPlacement() {
		return placement;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setTrigger(Trigger trigger) {
		this.trigger = trigger;
	}

	/**
	 * {@inheritDoc}
	 */
	public Trigger getTrigger() {
		return trigger;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setShowDelay(int delayInMilliseconds) {
		showDelayInMilliseconds = delayInMilliseconds;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getShowDelay() {
		return showDelayInMilliseconds;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setHideDelay(int delayInMilliseconds) {
		hideDelayInMilliseconds = delayInMilliseconds;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getHideDelay() {
		return hideDelayInMilliseconds;
	}

	/**
	 * {@inheritDoc}
	 */
	public void show() {
		changeVisibility(VisibilityChange.SHOW);
	}

	/**
	 * {@inheritDoc}
	 */
	public void hide() {
		changeVisibility(VisibilityChange.HIDE);
	}

	/**
	 * {@inheritDoc}
	 */
	public void toggle() {
		changeVisibility(VisibilityChange.TOGGLE);
	}

	/**
	 * Changes the visibility of the widget.
	 * 
	 * @param visibilityChange
	 *            the action to be performed
	 */
	protected abstract void changeVisibility(VisibilityChange visibilityChange);

	/**
	 * Adds a widget to this panel.
	 * 
	 * @param w
	 *            the child widget to be added
	 */
	@Override
	public void add(Widget w) {
		// Can't add() more than one widget to a SimplePanel.
		if (getWidget() != null) {
			throw new IllegalStateException("SimplePanel can only contain one child widget");
		}
		setWidget(w);
	}

	/**
	 * Gets the panel's child widget.
	 * 
	 * @return the child widget, or <code>null</code> if none is present
	 */
	public Widget getWidget() {
		return widget;
	}

	public Iterator<Widget> iterator() {
		// Return a simple iterator that enumerates the 0 or 1 elements in this
		// panel.
		return new Iterator<Widget>() {

			boolean hasElement = widget != null;

			Widget returned = null;

			public boolean hasNext() {
				return hasElement;
			}

			public Widget next() {
				if (!hasElement || (widget == null)) {
					throw new NoSuchElementException();
				}
				hasElement = false;
				return (returned = widget);
			}

			public void remove() {
				if (returned != null) {
					HoverBase.this.remove(returned);
				}
			}
		};
	}

	@Override
	public boolean remove(Widget w) {
		// Validate.
		if (widget != w) {
			return false;
		}

		// Orphan.
		try {
			orphan(w);
		} finally {
			// Physical detach.
			getContainerElement().removeChild(w.getElement());

			// Logical detach.
			widget = null;
		}
		return true;
	}

	public void setWidget(IsWidget w) {
		setWidget(asWidgetOrNull(w));
	}
	
	/**
	 * Sets this panel's widget. Any existing child widget will be removed.
	 * 
	 * @param w
	 *            the panel's new widget, or <code>null</code> to clear the
	 *            panel
	 */
	public void setWidget(Widget w) {
		// Validate
		if (w == widget) {
			return;
		}
		
		if(w.getParent() != null) {
			if(widget != null) {
				remove(widget);
			}
			widget = w;
			return;
		}

		// Detach new child.
		if (w != null) {
			w.removeFromParent();
		}

		// Remove old child.
		if (widget != null) {
			remove(widget);
		}

		// Logical attach.
		widget = w;

		if (w != null) {
			// Physical attach.
			DOM.appendChild(getContainerElement(), widget.getElement());

			adopt(widget);
		}
	}

	/**
	 * Override this method to specify that an element other than the root
	 * element be the container for the panel's child widget. This can be useful
	 * when you want to create a simple panel that decorates its contents.
	 * 
	 * Note that this method continues to return the
	 * {@link com.google.gwt.user.client.Element} class defined in the
	 * <code>User</code> module to maintain backwards compatibility.
	 * 
	 * @return the element to be used as the panel's container
	 */
	protected com.google.gwt.user.client.Element getContainerElement() {
		return getElement();
	}
	
	/**
	 * Get data name of JS Data API.
	 * @return data name
	 */
	protected abstract String getDataName();
}
