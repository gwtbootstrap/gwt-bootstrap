package com.github.gwtbootstrap.datepicker.client.ui.base;

import java.util.Date;

/**
 * Define a element to the endDate Property
 *
 * @author Carlos Alexandro Becker
 * @since 2.0.3.0
 */
public interface HasEndDate {

    /**
     * Set the max date in the component.
     * @param date: the date format when the calendar will end
     */
    void setEndDate(String date);

    /**
     * Set the max date in the component.
     * @param date: the date format when the calendar will end
     */
    void setEndDate_(Date date);


}
