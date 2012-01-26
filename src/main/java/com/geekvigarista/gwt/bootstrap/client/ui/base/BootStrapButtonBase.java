package com.geekvigarista.gwt.bootstrap.client.ui.base;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Size;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.State;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Type;
import com.google.gwt.safehtml.shared.SafeHtml;

/**
 * Base-Class for other BootStrap Buttons.
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class BootStrapButtonBase extends com.google.gwt.user.client.ui.Button {

	{
		setStyleName(BootstrapCssResources.btn);
	}

	public BootStrapButtonBase() {

	}

	public BootStrapButtonBase(String html) {
		this();
		setHTML(html);
	}

	public BootStrapButtonBase(SafeHtml html) {
		this();
		setHTML(html);
	}

	public void setType(Type type) {
		addStyleName(type.getType());
	}

	public void setSize(Size size) {
		addStyleName(size.getSize());
	}

	@Override
	public void setEnabled(boolean enabled) {
		if (enabled) {
			removeStyleName(State.ENABLED.getState());
		} else {
			addStyleName(State.DISABLED.getState());
		}
	}

	public void setState(State state) {
		setEnabled(state == State.ENABLED);
	}
}
