package com.geekvigarista.gwt.bootstrap.client.ui.resources;

import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.TextResource;

/**
 * Utility class to inject our resources into modules page. Use it to inject
 * JavaScript and CSS files.
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class BootstrapConfigurator {

	private static final Resources res = Resources.RESOURCES;

	/**
	 * Import the required styles and JSs to the head of modules HTML.
	 */
	public static void configure() {
		injectCss(res.bootstrap());
		injectJs(res.jquery());
	}

	public static void injectCss(TextResource r) {
		StyleInjector.inject(r.getText());
	}

	public static void injectJs(TextResource r) {
		JavaScriptInjector.inject(r.getText());
	}
}
