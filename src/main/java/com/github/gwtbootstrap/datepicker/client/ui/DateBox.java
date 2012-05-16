package com.github.gwtbootstrap.datepicker.client.ui;

import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.dom.client.Element;

/**
 * DateBox component.
 *
 * @since 2.0.3.0
 * @author Carlos Alexandro Becker
 */
public class DateBox extends TextBox {

    private String format = "mm/dd/yyyy";

    public DateBox() {
        configure();
    }

    public DateBox(String format) {
        this.format = format;
        configure();
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        configure(getElement());
    }

    private final void configure() {
        getElement().setAttribute("data-date-format", format);
        configure(getElement());
    }

    private final native void configure(Element e) /*-{
        $wnd.jQuery(e).datepicker();
    }-*/;

}
