package com.github.gwtbootstrap.datepicker.client.ui.base;

/**
 * Define the element to have language support.
 *
 * @author Carlos Alexandro Becker
 * @since 2.0.3.0
 */
public interface HasLanguage {

    /**
     * Setup the language of the component.
     * Depend on the JS plugin behavior, it can not work after the widget is already visible.
     *
     * @param language: the language.
     */
    void setLanguage(String language);

}
