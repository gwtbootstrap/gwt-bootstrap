package com.github.gwtbootstrap.timepicker.client.ui.base;

/**
 * Define a element to have the setter of format (string).
 *
 * @author Carlos Alexandro Becker
 * @author Joshua Godi
 * @since 2.3.2.0
 */
public interface HasTimeFormat {
    /**
     * Set the format in the component.
     * @param format: the time format (HH:mm:ss a, e.g.)
     */
    void setFormat(String format);
}
