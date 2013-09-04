package com.github.gwtbootstrap.timepicker.client;

import com.github.gwtbootstrap.timepicker.client.ui.resources.TimepickerResourceInjector;
import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point of TimeBox Module.
 *
 * @author Carlos Alexandro Becker
 * @author Joshua Godi
 * @since 2.3.2.0
 */
public class Timepicker implements EntryPoint {
    @Override
    public void onModuleLoad() {
        TimepickerResourceInjector.configure();
    }
}
