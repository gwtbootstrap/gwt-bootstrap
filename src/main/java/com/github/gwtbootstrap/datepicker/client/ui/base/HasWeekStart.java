package com.github.gwtbootstrap.datepicker.client.ui.base;

import java.util.Date;

/**
 * Define a element that have a day of week to start.
 *
 * @author Carlos Alexandro Becker
 * @since 2.0.3.0
 */
public interface HasWeekStart {

    /**
     * Define the first day of week in the datepicker.
     *
     * @param start: 0 is sunday, 6 is saturday, so you can set the 0..6 interval.
     */
    void setWeekStart(int start);
}
