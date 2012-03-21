package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.google.gwt.user.client.ui.InlineLabel;

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
				return BootstrapCssResources.badge_success;
			}
		},
		WARNING {
			@Override
			String get() {
				return BootstrapCssResources.badge_warning;
			}
		},
		ERROR {
			@Override
			String get() {
				return BootstrapCssResources.badge_error;
			}
		},
		INFO {
			@Override
			String get() {
				return BootstrapCssResources.badge_info;
			}
		},
		INVERSE {
			@Override
			String get() {
				return BootstrapCssResources.badge_inverse;
			}
		};
		abstract String get();
	}
	
	public Badge() {
		super();
		setStyleName(BootstrapCssResources.badge);
	}
	
	public Badge(Type type) {
		this();
		addStyleName(type.get());
	}
	
	public void setType(String typename) {
		addStyleName("badge-" + typename);
	}
}
