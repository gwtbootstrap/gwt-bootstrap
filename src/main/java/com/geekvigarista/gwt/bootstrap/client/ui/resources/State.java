package com.geekvigarista.gwt.bootstrap.client.ui.resources;

/**
 * Disponible States of a Component (enable and disable).
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public enum State {

	ENABLED {
		@Override
		public String getState() {
			return BootstrapCssResources.disabled;
		}
	},
	DISABLED {
		@Override
		public String getState() {
			return "";
		}
	};

	public abstract String getState();
}
