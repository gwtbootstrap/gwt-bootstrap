package com.github.gwtbootstrap.datepicker.client.ui.base;

import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.base.HasVisibility;
import com.github.gwtbootstrap.client.ui.base.HasVisibleHandlers;
import com.github.gwtbootstrap.client.ui.event.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Base DatePicker component.
 *
 * @author Carlos Alexandro Becker
 * @since 2.0.3.0
 */
public class DatePickerBase extends Widget implements HasValue<Date>, HasValueChangeHandlers<Date>, HasDateFormat, HasVisibility,
        HasVisibleHandlers {

    private final TextBox box;
    private String format;
    private DateTimeFormat dtf;
    private Map<String, String> options = new HashMap<String, String>();

    public DatePickerBase() {
        this.box = new TextBox();
        setElement(box.getElement());
        setFormat("mm/dd/yyyy");
        setValue(new Date());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFormat(String format) {
        this.format = format;
        Date oldValue = getValue();
        this.dtf = DateTimeFormat.getFormat(format.replaceAll("mm", "MM"));
        if (oldValue != null) {
            setValue(oldValue);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFormat() {
        return format;
    }

    /**
     * Returns the internal instance of textbox element. Use only if know what you are doing.
     *
     * @return internal textbox intance.
     */
    protected TextBox getBox() {
        return box;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getValue() {
        return dtf != null ? dtf.parse(box.getValue()) : null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setValue(Date value) {
        setValue(value, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setValue(Date value, boolean fireEvents) {
        box.setValue(dtf.format(value));
        if (fireEvents) {
            ValueChangeEvent.fire(this, value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Date> dateValueChangeHandler) {
        return addHandler(dateValueChangeHandler, ValueChangeEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onLoad() {
        super.onLoad();
        configure();
    }

    /**
     * Configure the elements for a specific widget.
     * Use only if you know what you are doing.
     *
     * @param w: the widget to configure.
     */
    protected void configure(Widget w) {
        w.getElement().setAttribute("data-date-format", format);
        configure(w.getElement(), options);
    }

    /**
     * dateChange event handler.
     */
    public void onChange() {
        ValueChangeEvent.fire(this, getValue());
    }

    /**
     * configure this datepicker.
     */
    protected void configure() {
        configure(this);
    }

    public void setAutoClose(boolean autoClose) {
        options.put("autoclose", Boolean.toString(autoClose));
        configure();
    }

    /**
     * call jquery datepicker plugin in a element.
     *
     * @param e: Element that will be transformed in a datepicker.
     */
    protected native void configure(Element e, Map<String, String> opts) /*-{
        var that = this;
        $wnd.alert(opts);
        $wnd.jQuery(e).datepicker(opts);
//        $wnd.jQuery(e).on('changeDate', function () {
//            that.@com.github.gwtbootstrap.datepicker.client.ui.base.DatePickerBase::onChange()();
//        });
//        $wnd.jQuery(e).on("show", function () {
//            that.@com.github.gwtbootstrap.datepicker.client.ui.base.DatePickerBase::show()();
//        });
//        $wnd.jQuery(e).on("hide", function () {
//            that.@com.github.gwtbootstrap.datepicker.client.ui.base.DatePickerBase::hide()();
//        });
    }-*/;

    private native void execute(Element e, String cmd) /*-{
        $wnd.jQuery(e).datepicker(cmd);
    }-*/;

    private void execute(String cmd) {
        execute(getElement(), cmd);
    }

    @Override
    public void show() {
        execute("show");
    }

    @Override
    public void hide() {
        execute("hide");
    }

    @Override
    public void toggle() {
        if (options.containsKey("show")) {
            hide();
        } else {
            show();
        }
    }

    @Override
    public HandlerRegistration addHideHandler(HideHandler handler) {
        return addHandler(handler, HideEvent.getType());
    }

    @Override
    public HandlerRegistration addHiddenHandler(HiddenHandler handler) {
        return addHandler(handler, HiddenEvent.getType());
    }

    @Override
    public HandlerRegistration addShowHandler(ShowHandler handler) {
        return addHandler(handler, ShowEvent.getType());
    }

    @Override
    public HandlerRegistration addShownHandler(ShownHandler handler) {
        return addHandler(handler, ShownEvent.getType());
    }
}
