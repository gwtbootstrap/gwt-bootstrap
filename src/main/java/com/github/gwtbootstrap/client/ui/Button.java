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

import com.github.gwtbootstrap.client.ui.base.HasType;
import com.github.gwtbootstrap.client.ui.base.IconAnchor;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.DragEndEvent;
import com.google.gwt.event.dom.client.DragEndHandler;
import com.google.gwt.event.dom.client.DragEnterEvent;
import com.google.gwt.event.dom.client.DragEnterHandler;
import com.google.gwt.event.dom.client.DragEvent;
import com.google.gwt.event.dom.client.DragHandler;
import com.google.gwt.event.dom.client.DragLeaveEvent;
import com.google.gwt.event.dom.client.DragLeaveHandler;
import com.google.gwt.event.dom.client.DragOverEvent;
import com.google.gwt.event.dom.client.DragOverHandler;
import com.google.gwt.event.dom.client.DragStartEvent;
import com.google.gwt.event.dom.client.DragStartHandler;
import com.google.gwt.event.dom.client.DropEvent;
import com.google.gwt.event.dom.client.DropHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.GestureChangeEvent;
import com.google.gwt.event.dom.client.GestureChangeHandler;
import com.google.gwt.event.dom.client.GestureEndEvent;
import com.google.gwt.event.dom.client.GestureEndHandler;
import com.google.gwt.event.dom.client.GestureStartEvent;
import com.google.gwt.event.dom.client.GestureStartHandler;
import com.google.gwt.event.dom.client.HasAllDragAndDropHandlers;
import com.google.gwt.event.dom.client.HasAllFocusHandlers;
import com.google.gwt.event.dom.client.HasAllGestureHandlers;
import com.google.gwt.event.dom.client.HasAllKeyHandlers;
import com.google.gwt.event.dom.client.HasAllMouseHandlers;
import com.google.gwt.event.dom.client.HasAllTouchHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasDoubleClickHandlers;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.dom.client.TouchCancelEvent;
import com.google.gwt.event.dom.client.TouchCancelHandler;
import com.google.gwt.event.dom.client.TouchEndEvent;
import com.google.gwt.event.dom.client.TouchEndHandler;
import com.google.gwt.event.dom.client.TouchMoveEvent;
import com.google.gwt.event.dom.client.TouchMoveHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasEnabled;

//@formatter:off
/**
 * Button with optional icon.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code <b:Button icon="TRASH" type="ERROR">Delete</b:Button>}
 * </pre>
 * 
 * All arguments are optional.
 * </p>
 * 
 * @since 2.0.2.0
 * 
 * @author Carlos Alexandro Becker
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/base-css.html#buttons">Bootstrap documentation</a>
 * @see ButtonGroup
 * @see ButtonToolbar
 * @see DropdownButton
 * @see SplitDropdownButton
 * @see NavbarButton
 */
//@formatter:on
public class Button extends IconAnchor implements HasClickHandlers,
		HasDoubleClickHandlers, HasEnabled, HasType<ButtonType>,
		HasAllDragAndDropHandlers, HasAllFocusHandlers, HasAllGestureHandlers,
		HasAllKeyHandlers, HasAllMouseHandlers, HasAllTouchHandlers {

	/**
	 * Creates an empty Button.
	 */
	public Button() {
		super();
		addStyleName(Constants.BTN);
	}

	/**
	 * Creates a Button with the given caption.
	 * 
	 * @param caption
	 *            the caption of the Button
	 */
	public Button(String caption) {
		this();
		setText(caption);
	}

	/**
	 * Creates a Button with the given caption and icon.
	 * 
	 * @param caption
	 *            the caption of the Button
	 * @param icon
	 *            the Icon on the caption's left
	 */
	public Button(String caption, IconType icon) {
		this(caption);
		setIcon(icon);
	}

	/**
	 * Sets the type of the Button.
	 * <p>
	 * Different types give the button a different look.
	 * 
	 * @param type
	 *            the type of the Button.
	 */
	public void setType(ButtonType type) {
		for (ButtonType t : ButtonType.values())
			removeStyle(t);
		addStyle(type);
	}

	/**
	 * Sets the size of the Button.
	 * 
	 * @param size
	 *            the size of the Button.
	 */
	public void setSize(ButtonSize size) {
		for (ButtonSize s : ButtonSize.values())
			removeStyle(s);
		addStyle(size);
	}

	/**
	 * Whether the Button is enabled or disabled.
	 * <p>
	 * A disabled widget cannot be used.
	 * 
	 * @return <code>false</code> if the Button is disabled.
	 */
	public boolean isEnabled() {
		return getStyleName().contains(Constants.DISABLED);
	}

	/**
	 * Sets whether the Button is enabled or disabled.
	 * <p>
	 * A disabled widget cannot be used.
	 * 
	 * @param enabled
	 *            <code>false</code> if the Button should be disabled. Default:
	 *            <code>true</code>
	 */
	public void setEnabled(boolean enabled) {
		if (enabled)
			removeStyleName(Constants.DISABLED);
		else
			addStyleName(Constants.DISABLED);
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration
			addDoubleClickHandler(DoubleClickHandler handler) {
		return addDomHandler(handler, DoubleClickEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addDragEndHandler(DragEndHandler handler) {
		return addDomHandler(handler, DragEndEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addDragEnterHandler(DragEnterHandler handler) {
		return addDomHandler(handler, DragEnterEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addDragLeaveHandler(DragLeaveHandler handler) {
		return addDomHandler(handler, DragLeaveEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addDragHandler(DragHandler handler) {
		return addDomHandler(handler, DragEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addDragOverHandler(DragOverHandler handler) {
		return addDomHandler(handler, DragOverEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addDragStartHandler(DragStartHandler handler) {
		return addDomHandler(handler, DragStartEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addDropHandler(DropHandler handler) {
		return addDomHandler(handler, DropEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addFocusHandler(FocusHandler handler) {
		return addDomHandler(handler, FocusEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addBlurHandler(BlurHandler handler) {
		return addDomHandler(handler, BlurEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addGestureStartHandler(
			GestureStartHandler handler) {
		return addDomHandler(handler, GestureStartEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addGestureChangeHandler(
			GestureChangeHandler handler) {
		return addDomHandler(handler, GestureChangeEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addGestureEndHandler(GestureEndHandler handler) {
		return addDomHandler(handler, GestureEndEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addKeyUpHandler(KeyUpHandler handler) {
		return addDomHandler(handler, KeyUpEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
		return addDomHandler(handler, KeyDownEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addKeyPressHandler(KeyPressHandler handler) {
		return addDomHandler(handler, KeyPressEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addMouseDownHandler(MouseDownHandler handler) {
		return addDomHandler(handler, MouseDownEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addMouseUpHandler(MouseUpHandler handler) {
		return addDomHandler(handler, MouseUpEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
		return addDomHandler(handler, MouseOutEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
		return addDomHandler(handler, MouseOverEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addMouseMoveHandler(MouseMoveHandler handler) {
		return addDomHandler(handler, MouseMoveEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addMouseWheelHandler(MouseWheelHandler handler) {
		return addDomHandler(handler, MouseWheelEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addTouchStartHandler(TouchStartHandler handler) {
		return addDomHandler(handler, TouchStartEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addTouchMoveHandler(TouchMoveHandler handler) {
		return addDomHandler(handler, TouchMoveEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addTouchEndHandler(TouchEndHandler handler) {
		return addDomHandler(handler, TouchEndEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration
			addTouchCancelHandler(TouchCancelHandler handler) {
		return addDomHandler(handler, TouchCancelEvent.getType());
	}

}
