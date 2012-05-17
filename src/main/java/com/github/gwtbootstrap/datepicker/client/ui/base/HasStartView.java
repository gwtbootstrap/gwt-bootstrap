package com.github.gwtbootstrap.datepicker.client.ui.base;

/**
 * Define a element that have the startView property.
 *
 * @author Carlos Alexandro Becker
 * @since 2.0.3.0
 */
public interface HasStartView {

    public static enum ViewMode {MONTH, YEAR, DECADE}

    /**
     * Set the view mode of the datepicker.
     *
     * @param mode: ViewMode.{MONTH,YEAR,DECADE}
     */
    void setStartView(ViewMode mode);

    /**
     * Set the view mode of the datepicker.
     *
     * @param mode: MONTH
     *              YEAR
     *              DECADE
     *              dont matter if lower or upper case.
     */
    void setStartView(String mode);
}
