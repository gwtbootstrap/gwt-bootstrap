package com.github.gwtbootstrap.timepicker.client.ui.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Interface that provides the TimeBox resources.
 *
 * @author Carlos Alexandro Becker
 * @author Joshua Godi
 * @since 2.3.2.0
 */
public interface Resources extends ClientBundle {
    public static Resources RESOURCES = GWT.create(Resources.class);

    @Source("css/bootstrap-timepicker.css")
    TextResource timepickerCss();

    @Source("js/bootstrap-timepicker.js")
    TextResource timepickerJs();
}
