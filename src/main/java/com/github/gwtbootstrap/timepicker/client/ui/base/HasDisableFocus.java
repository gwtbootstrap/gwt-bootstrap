package com.github.gwtbootstrap.timepicker.client.ui.base;

/**
 * Define a element that will have the disableFocus property
 *
 * @author Carlos Alexandro Becker
 * @author Joshua Godi
 * @since 2.3.2.0
 */
public interface HasDisableFocus {

    /**
     * Sets the disableFocus property component
     *
     * @param disableFocus: if true it will disable the focus of the component
     *                      - useful to hide keyboard popup on mobile devices
     */
    public void setDisableFocus(boolean disableFocus);

}
