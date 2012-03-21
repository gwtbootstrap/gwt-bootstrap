package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.Bootstrap;
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
				return Bootstrap.label_success;
			}
		},
		WARNING {
			@Override
			String get() {
				return Bootstrap.label_warning;
			}
		},
		IMPORTANT {
			@Override
			String get() {
				return Bootstrap.label_important;
			}
		},
		INFO {
			@Override
			String get() {
				return Bootstrap.label_info;
			}
		},
		INVERSE {
			@Override
			String get() {
				return Bootstrap.label_inverse;
			}
		};
		abstract String get();
	}

	public Label() {
		setStyleName(Bootstrap.label_default);
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
			setStyleName(Bootstrap.label_success);
		else if (typename.equalsIgnoreCase("warning"))
			setStyleName(Bootstrap.label_warning);
		else if (typename.equalsIgnoreCase("important"))
			setStyleName(Bootstrap.label_important);
		else if (typename.equalsIgnoreCase("info"))
			setStyleName(Bootstrap.label_info);
		else if (typename.equalsIgnoreCase("inverse"))
			setStyleName(Bootstrap.label_inverse);
		else
			setStyleName(Bootstrap.label_default);
	}

}
