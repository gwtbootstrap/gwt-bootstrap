package com.github.gwtbootstrap.datepicker.client.ui.base;

/**
 * Define a element that have the autoclose property.
 *
 * @author Carlos Alexandro Becker
 * @since 2.0.3.0
 */
public interface HasAutoclose {

    /**
     * Determine if the element will autoclose in some events.
     *
     * @param autoclose: if true, set the autoclose on, set of otherwise.
     */
    void setAutoClose(boolean autoclose);
}
