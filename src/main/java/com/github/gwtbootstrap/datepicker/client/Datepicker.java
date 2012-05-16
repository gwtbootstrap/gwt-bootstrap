package com.github.gwtbootstrap.datepicker.client;

import com.github.gwtbootstrap.datepicker.client.ui.resources.DatepickerResourceInjector;
import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point of DateBox Module.
 *
 * @since 2.0.3.0
 * @author Carlos Alexandro Becker
 */
public class Datepicker implements EntryPoint{
    @Override
    public void onModuleLoad() {
        DatepickerResourceInjector.configure();
    }
}
