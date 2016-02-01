package com.github.gwtbootstrap.timepicker.client.ui.resources;

import com.github.gwtbootstrap.client.ui.resources.JavaScriptInjector;
import com.github.gwtbootstrap.client.ui.resources.ResourceInjector;
import com.google.gwt.resources.client.TextResource;

/**
 * Utility class to inject our resources into modules page. Use it to inject
 * JavaScript and CSS files.
 *
 * @author Carlos Alexandro Becker
 * @author Joshua Godi
 * @since 2.3.2.0
 */
public final class TimepickerResourceInjector {

	private TimepickerResourceInjector(){

	}
    /**
     * Injects the required CSS styles and JavaScript files into the document header.
     * <pre>
     * It's for NoStyle Module.
     * </pre>
     */
    public static void configureWithCssFile() {
        ResourceInjector.injectResourceCssAsFile("bootstrap-timepicker.css");
        configure();
    }


    /**
     * Injects the required CSS styles and JavaScript files into the document
     * header.
     */
    public static void configure() {
        Resources r = Resources.RESOURCES;
        injectJs(r.timepickerJs());
    }

    private static void injectJs(TextResource r) {
        JavaScriptInjector.inject(r.getText());
    }
}
