package com.github.gwtbootstrap.datepicker.client.ui;

import com.github.gwtbootstrap.client.ui.AddOn;
import com.github.gwtbootstrap.client.ui.AppendButton;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.github.gwtbootstrap.datepicker.client.ui.base.DateBoxBase;
import com.github.gwtbootstrap.datepicker.client.ui.base.HasDateFormat;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;

import java.util.Date;

/**
 * DateBoxAppended component.
 *
 * @since 2.0.3.0
 * @author Carlos Alexandro Becker
 */
public class DateBoxAppended extends AppendButton implements HasValue<Date>, HasDateFormat {
    private final DateBoxAppendedAdapter box;

    {
        this.box = new DateBoxAppendedAdapter();
        AddOn icon = new AddOn();
        icon.setIcon(IconType.TH);
        add(box);
        add(icon);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getValue() {
        return box.getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setValue(Date value) {
        box.setValue(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setValue(Date value, boolean fireEvents) {
        box.setValue(value, fireEvents);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Date> dateValueChangeHandler) {
        return box.addValueChangeHandler(dateValueChangeHandler);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFormat(String format) {
        box.setFormat(format);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFormat() {
        return box.getFormat();
    }

    /**
     * An 'adapter' to change some aspects of the behavior of datepickerbase. //TODO may need refactor.
     */
    private class DateBoxAppendedAdapter extends DateBoxBase {
        @Override
        protected void configure() {
            DateBoxAppended that = DateBoxAppended.this;
            super.configure(that);
            getBox().getElement().setAttribute("readonly", null);
            that.addStyleName("date");
        }
    }
}
