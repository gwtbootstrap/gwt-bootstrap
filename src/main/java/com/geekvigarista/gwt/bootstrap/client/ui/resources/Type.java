package com.geekvigarista.gwt.bootstrap.client.ui.resources;

/**
 * Disponible types for various components, like Buttons and Notifications.
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public enum Type {

	DEFAULT {
		@Override
		public String getType() {
			return "";
		}
	},
	PRIMARY {
		@Override
		public String getType() {
			return BootstrapCssResources.primary;
		}
	},
	INFO {
		@Override
		public String getType() {
			return BootstrapCssResources.info;
		}
	},
	SUCCESS {
		@Override
		public String getType() {
			return BootstrapCssResources.success;
		}
	},
	DANGER {
		@Override
		public String getType() {
			return BootstrapCssResources.danger;
		}
	};
	public abstract String getType();
}
