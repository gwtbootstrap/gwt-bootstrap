package com.github.gwtbootstrap.timepicker.client.ui;

import java.util.Date;

import com.github.gwtbootstrap.client.ui.AppendButton;
import com.github.gwtbootstrap.client.ui.base.AddOn;
import com.github.gwtbootstrap.client.ui.base.HasIcon;
import com.github.gwtbootstrap.client.ui.base.HasPlaceholder;
import com.github.gwtbootstrap.client.ui.base.HasVisibility;
import com.github.gwtbootstrap.client.ui.constants.BaseIconType;
import com.github.gwtbootstrap.client.ui.constants.IconPosition;
import com.github.gwtbootstrap.client.ui.constants.IconSize;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.github.gwtbootstrap.client.ui.event.HasVisibleHandlers;
import com.github.gwtbootstrap.client.ui.event.HiddenHandler;
import com.github.gwtbootstrap.client.ui.event.HideHandler;
import com.github.gwtbootstrap.client.ui.event.ShowHandler;
import com.github.gwtbootstrap.client.ui.event.ShownHandler;
import com.github.gwtbootstrap.timepicker.client.ui.base.HasDefaultTime;
import com.github.gwtbootstrap.timepicker.client.ui.base.HasDisableFocus;
import com.github.gwtbootstrap.timepicker.client.ui.base.HasMeridian;
import com.github.gwtbootstrap.timepicker.client.ui.base.HasMinuteStep;
import com.github.gwtbootstrap.timepicker.client.ui.base.HasModalBackdrop;
import com.github.gwtbootstrap.timepicker.client.ui.base.HasSecondStep;
import com.github.gwtbootstrap.timepicker.client.ui.base.HasShowInputs;
import com.github.gwtbootstrap.timepicker.client.ui.base.HasShowSeconds;
import com.github.gwtbootstrap.timepicker.client.ui.base.HasTemplate;
import com.github.gwtbootstrap.timepicker.client.ui.base.TimeBoxBase;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;

/**
 * TimeBoxAppended component
 *
 * @author Carlos Alexandro Becker
 * @author Joshua Godi
 * @since 2.3.2.0
 */
public class TimeBoxAppended extends AppendButton implements HasValue<Date>, HasIcon, HasVisibility,
        HasVisibleHandlers, HasPlaceholder, HasTemplate, HasShowInputs, HasSecondStep,
        HasModalBackdrop, HasMinuteStep, HasDisableFocus, HasDefaultTime, HasShowSeconds, HasMeridian {

    /**
     * An 'adapter' to change some aspects of the behavior of timepickerbase.
     */
    private class TimeBoxAppendedAdapter extends TimeBoxBase {
        @Override
        protected void configure() {
            TimeBoxAppended that = TimeBoxAppended.this;
            that.addStyleName("add-on");
            super.configure(that);
            getBox().getElement().setAttribute("readonly", null);
        }
    }

    private final TimeBoxAppendedAdapter box;
    private AddOn icon;

    {
        this.box = new TimeBoxAppendedAdapter();
        icon = new AddOn();
        icon.setIcon(IconType.TIME);
        add(box);
        add(icon);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDefaultTime(DefaultTime defaultTime) {
        box.setDefaultTime(defaultTime);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDefaultTime(String defaultTime) {
        box.setDefaultTime(defaultTime);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDisableFocus(boolean disableFocus) {
        box.setDisableFocus(disableFocus);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMeridian(boolean meridian) {
        box.setMeridian(meridian);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMinuteStep(int minuteStep) {
        box.setMinuteStep(minuteStep);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setModalBackdrop(boolean modalBackdrop) {
        box.setModalBackdrop(modalBackdrop);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPlaceholder(String placeholder) {
        box.setPlaceholder(placeholder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPlaceholder() {
        return box.getPlaceholder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSecondStep(int secondStep) {
        box.setSecondStep(secondStep);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setShowInputs(boolean showInputs) {
        box.setShowInputs(showInputs);
    }

    @Override
    public void setShowSeconds(boolean showSeconds) {
        box.setShowSeconds(showSeconds);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTemplate(Template template) {
        box.setTemplate(template);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTemplate(String template) {
        box.setTemplate(template);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIcon(IconType type) {
        icon.setIcon(type);
    }

    @Override
    public void setBaseIcon(BaseIconType type) {
        icon.setBaseIcon(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconSize(IconSize size) {
        icon.setIconSize(size);
    }

    @Override
    public void setCustomIconStyle(String customIconStyle) {
        icon.setCustomIconStyle(customIconStyle);
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public void setIconPosition(IconPosition position) {
        icon.setIconPosition(position);
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
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Date> handler) {
        return box.addValueChangeHandler(handler);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void show() {
        box.show();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hide() {
        box.hide();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void toggle() {
        box.toggle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addHideHandler(HideHandler handler) {
        return box.addHideHandler(handler);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addHiddenHandler(HiddenHandler handler) {
        return box.addHiddenHandler(handler);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addShowHandler(ShowHandler handler) {
        return box.addShowHandler(handler);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addShownHandler(ShownHandler handler) {
        return box.addShownHandler(handler);
    }
}
