package com.geekvigarista.gwt.bootstrap.client.ui.buttons;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.State;
import com.google.gwt.safehtml.shared.SafeHtml;

/**
 * Base-Class for other BootStrap Buttons.
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public abstract class BootStrapButtonBase extends
		com.google.gwt.user.client.ui.Button {

	{
		removeStyleName("gwt-Button");
		setType(ButtonType.DEFAULT);
	}

	public BootStrapButtonBase() {

	}

	public BootStrapButtonBase(ButtonSize size) {
		setSize(size);
	}

	public BootStrapButtonBase(String html) {
		this();
		setHTML(html);
	}

	public BootStrapButtonBase(SafeHtml html) {
		this();
		setHTML(html);
	}

	public void setType(ButtonType type) {
		for (ButtonType t : ButtonType.values()) {
			if (!t.equals(ButtonType.DEFAULT)) {
				removeStyleName(t.getType());
			}
		}
		addStyleName(type.getType());
	}

	public void setSize(ButtonSize size) {
		for (ButtonSize s : ButtonSize.values()) {
			removeStyleName(s.getSize());
		}

		addStyleName(size.getSize());
	}

	@Override
	public void setEnabled(boolean enabled) {
		if (enabled) {
			removeStyleName(State.DISABLED.getState());
		} else {
			addStyleName(State.DISABLED.getState());
		}
	}

	public void setState(State state) {
		setEnabled(state != State.DISABLED);
	}
}
