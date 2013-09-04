package com.github.gwtbootstrap.timepicker.client.ui.base;

/**
 * Define a element that will have the defaultTime property
 *
 * @author Carlos Alexandro Becker
 * @author Joshua Godi
 * @since 2.3.2.0
 */
public interface HasDefaultTime {

    public static enum DefaultTime {CURRENT, VALUE, FALSE}

    /**
     * Set the defaultTime of the component.
     *
     * @param defaultTime: DefaultTime.{CURRENT, VALUE, FALSE}
     */
    void setDefaultTime(DefaultTime defaultTime);

    /**
     * Set the defaultTime of the component.
     *
     * @param defaultTime: CURRENT
     *                     VALUE
     *                     FALSE
     */
    void setDefaultTime(String defaultTime);

}
