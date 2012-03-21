package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.google.gwt.user.client.ui.InlineLabel;

/**
 * A Inline Label Component. You could have multiple types :)
 * 
 * @author Carlos Alexandro Becker
 * @author Dominik Mayer
 * @since 23/01/2012
 */
public class Label extends InlineLabel {

	public enum Type {

		DEFAULT {
			@Override
			String get() {
				return "";
			}
		},
		SUCCESS {
			@Override
			String get() {
				return BootstrapCssResources.label_success;
			}
		},
		WARNING {
			@Override
			String get() {
				return BootstrapCssResources.label_warning;
			}
		},
		IMPORTANT {
			@Override
			String get() {
				return BootstrapCssResources.label_important;
			}
		},
		INFO {
			@Override
			String get() {
				return BootstrapCssResources.label_info;
			}
		},
		INVERSE {
			@Override
			String get() {
				return BootstrapCssResources.label_inverse;
			}
		};
		abstract String get();
	}

	public Label() {
		setStyleName(BootstrapCssResources.label_default);
	}

	public Label(String text) {
		this();
		setText(text);
	}

	public Label(String text, Type type) {
		setText(text);
		setType(type);
	}

	public void setType(Type type) {
		assert type != null : "type should not be null";
		
		setStyleName(type.get());
	}
	
	public void setType(String typename) {
		if (typename.equalsIgnoreCase("success"))
			setStyleName(BootstrapCssResources.label_success);
		else if (typename.equalsIgnoreCase("warning"))
			setStyleName(BootstrapCssResources.label_warning);
		else if (typename.equalsIgnoreCase("important"))
			setStyleName(BootstrapCssResources.label_important);
		else if (typename.equalsIgnoreCase("info"))
			setStyleName(BootstrapCssResources.label_info);
		else if (typename.equalsIgnoreCase("inverse"))
			setStyleName(BootstrapCssResources.label_inverse);
		else
			setStyleName(BootstrapCssResources.label_default);
	}

}
