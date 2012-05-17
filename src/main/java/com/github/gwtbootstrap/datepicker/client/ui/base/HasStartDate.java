package com.github.gwtbootstrap.datepicker.client.ui.base;

import java.util.Date;

/**
 * Define a element to the startDateProperty
 *
 * @author Carlos Alexandro Becker
 * @since 2.0.3.0
 */
public interface HasStartDate {

    /**
     * Set the min date in the component.
     * @param date: the date format when the calendar will start
     */
    void setStartDate(String date);

    /**
     * Set the min date in the component.
     * @param date: the date format when the calendar will start
     */
    void setStartDate_(Date date);


}
