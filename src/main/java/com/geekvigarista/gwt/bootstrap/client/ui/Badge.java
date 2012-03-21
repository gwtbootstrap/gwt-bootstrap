package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.ui.InlineLabel;

/**
 * A Badge to show some kind of count.
 * 
 * @author Dominik Mayer
 */
public class Badge extends InlineLabel {

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
				return Bootstrap.badge_success;
			}
		},
		WARNING {
			@Override
			String get() {
				return Bootstrap.badge_warning;
			}
		},
		ERROR {
			@Override
			String get() {
				return Bootstrap.badge_error;
			}
		},
		INFO {
			@Override
			String get() {
				return Bootstrap.badge_info;
			}
		},
		INVERSE {
			@Override
			String get() {
				return Bootstrap.badge_inverse;
			}
		};
		abstract String get();
	}
	
	public Badge() {
		super();
		setStyleName(Bootstrap.badge);
	}
	
	public Badge(Type type) {
		this();
		addStyleName(type.get());
	}
	
	public void setType(String typename) {
		addStyleName("badge-" + typename);
	}
}
