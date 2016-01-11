package com.github.gwtbootstrap.timepicker.client.ui.base;

/**
 * Define a element that will have the template property
 *
 * @author Carlos Alexandro Becker
 * @author Joshua Godi
 * @since 2.3.2.0
 */
public interface HasTemplate {

    public enum Template {DROPDOWN, MODAL, FALSE}

    /**
     * Set the template of the timepicker.
     *
     * @param template: Template.{DROPDOWN, MODAL, FALSE}
     */
    void setTemplate(Template template);

    /**
     * Set the template of the timepicker.
     *
     * @param template: DROPDOWN
     *                  MODAL
     *                  FALSE
     */
    void setTemplate(String template);

}