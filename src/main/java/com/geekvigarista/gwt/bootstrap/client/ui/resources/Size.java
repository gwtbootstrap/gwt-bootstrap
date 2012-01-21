package com.geekvigarista.gwt.bootstrap.client.ui.resources;

/**
 * Disponible Sizes of various BootStrap components.
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public enum Size {

	DEFAULT {
		@Override
		public String getSize() {
			return "";
		}
	},
	LARGE {
		@Override
		public String getSize() {
			return BootstrapCssResources.large;
		}
	},
	SMALL {
		@Override
		public String getSize() {
			return BootstrapCssResources.small;
		}
	};

	public abstract String getSize();
}
