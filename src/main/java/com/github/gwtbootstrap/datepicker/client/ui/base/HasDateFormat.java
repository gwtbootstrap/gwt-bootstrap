package com.github.gwtbootstrap.datepicker.client.ui.base;

/**
 * Define a element to have the getter and setter of format (string).
 *
 * @author Carlos Alexandro Becker
 * @since 2.0.3.0
 */
public interface HasDateFormat {

    /**
     * Set the format in the component.
     * @param format: the date format (dd/mm/yyyy, e.g.)
     */
    void setFormat(String format);
}
