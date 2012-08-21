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
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HasType;
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;

/**
 * A SubmitButton for Bootstrap form.
 * 
 * @since 2.0.4.0
 * @author ohashi keisuke
 */
public class SubmitButton extends FocusWidget implements HasType<ButtonType>, HasValue<String>, HasText, HasName, HasChangeHandlers {

	private boolean valueChangeHandlerInitialized;

	/**
	 * Creates an submit button with no caption.
	 */
	public SubmitButton() {
		super(Document.get().createSubmitInputElement());
		setStyleName(Constants.BTN);
	}

	private InputElement asInputElement() {
		return getElement().cast();
	}

	/**
	 * This constructor may be used by subclasses to explicitly use an existing
	 * element. This element must be a &lt;input type="submit"&gt; element.
	 * 
	 * @param element
	 *            the element to be used
	 */
	protected SubmitButton(Element element) {
		super(element);
		assert "submit".equalsIgnoreCase(element.<InputElement> cast().getType());
	}

	/**
	 * Creates a button with the given HTML caption and click listener.
	 * 
	 * @param html
	 *            the HTML caption
	 * @param handler
	 *            the click handler
	 */
	public SubmitButton(SafeHtml html,
		ClickHandler handler) {
		this(html.asString(), handler);
	}

	/**
	 * Creates a button with the given HTML caption.
	 * 
	 * @param html
	 *            the HTML caption
	 */
	public SubmitButton(SafeHtml html) {
		this(html.asString());
	}

	/**
	 * Creates a button with the given Text caption and click listener.
	 * 
	 * @param text
	 *            the Text caption
	 * @param handler
	 *            the click handler
	 */
	public SubmitButton(String text,
		ClickHandler handler) {
		this(text);
		addClickHandler(handler);
	}

	/**
	 * Creates a button with the given Text caption.
	 * 
	 * @param text
	 *            the Text caption
	 */
	public SubmitButton(String text) {
		this();
		setValue(text);
	}

	/**
	 * Programmatic equivalent of the user clicking the button.
	 */
	public void click() {
		getElement().<InputElement> cast().click();
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
		StyleHelper.changeStyle(this, type, ButtonType.class);
	}

	/**
	 * Sets the size of the Button.
	 * 
	 * @param size
	 *            the size of the Button.
	 */
	public void setSize(ButtonSize size) {
		StyleHelper.changeStyle(this, size, ButtonSize.class);
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addChangeHandler(ChangeHandler handler) {
		return addDomHandler(handler, ChangeEvent.getType());
	}

	/**
	 * @see com.google.gwt.event.logical.shared.HasValueChangeHandlers#addValueChangeHandler(com.google.gwt.event.logical.shared.ValueChangeHandler)
	 */
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
		if (!valueChangeHandlerInitialized) {
			valueChangeHandlerInitialized = true;
			addChangeHandler(new ChangeHandler() {

				public void onChange(ChangeEvent event) {
					ValueChangeEvent.fire(SubmitButton.this, getValue());
				}
			});
		}
		return addHandler(handler, ValueChangeEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setName(String name) {
		asInputElement().setName(name);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return asInputElement().getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText() {
		return asInputElement().getValue();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setText(String text) {
		setValue(text);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getValue() {
		return asInputElement().getValue();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(String value) {
		this.setValue(value , false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(String value, boolean fireEvents) {
		String oldValue = getValue();
		asInputElement().setValue(value);
		if (fireEvents) {
			ValueChangeEvent.fireIfNotEqual(this, oldValue, value);
		}
	}
	
    /**
     * Set element as a Block Level Button
     * @param block true:Block Level false:Default
     */
    public void setBlock(boolean block) {
        setStyleName(Constants.BTN_BLOCK, block);
    }
}
