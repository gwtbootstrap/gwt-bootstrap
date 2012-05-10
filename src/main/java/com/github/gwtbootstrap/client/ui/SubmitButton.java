package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HasType;
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.ButtonBase;

public class SubmitButton extends ButtonBase implements HasType<ButtonType>{

	public SubmitButton() {
		super(Document.get().createSubmitInputElement());
		setStyleName(Constants.BTN);
	}

	protected SubmitButton(Element element) {
		super(element);
		assert "submit".equalsIgnoreCase(element.<InputElement> cast().getType());
	}

	public SubmitButton(SafeHtml html,
		ClickHandler handler) {
		this(html.asString(), handler);
	}

	public SubmitButton(SafeHtml html) {
		this(html.asString());
	}

	public SubmitButton(String html,
		ClickHandler handler) {
		this(html);
		addClickHandler(handler);
	}

	/**
	 * Creates a button with the given HTML caption.
	 * 
	 * @param html
	 *            the HTML caption
	 */
	public SubmitButton(String html) {
		this();
		setHTML(html);
	}

	/**
	 * Programmatic equivalent of the user clicking the button.
	 */
	public void click() {
		getElement().<InputElement>cast().click();
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
}
