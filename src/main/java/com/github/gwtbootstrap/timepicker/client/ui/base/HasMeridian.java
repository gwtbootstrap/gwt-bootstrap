package com.github.gwtbootstrap.timepicker.client.ui.base;

/**
 * Define a element that will have the meridian property
 *
 * @author Carlos Alexandro Becker
 * @author Joshua Godi
 * @since 2.3.2.0
 */
public interface HasMeridian {


    /**
     * Determine if the element will meridian in some events.
     *
     * @param meridian: if true, set the meridian on, set of otherwise.
     *                  TRUE - 12hr mode
     *                  FALSE - 24hr mode
     */
    void setMeridian(boolean meridian);
}