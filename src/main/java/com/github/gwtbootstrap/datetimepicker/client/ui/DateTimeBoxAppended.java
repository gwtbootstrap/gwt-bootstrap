/*
 *  Copyright 2012 GWT-Bootstrap
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.gwtbootstrap.datetimepicker.client.ui;

import com.github.gwtbootstrap.client.ui.AppendButton;
import com.github.gwtbootstrap.client.ui.base.AddOn;
import com.github.gwtbootstrap.client.ui.base.HasAlternateSize;
import com.github.gwtbootstrap.client.ui.base.HasIcon;
import com.github.gwtbootstrap.client.ui.base.HasVisibility;
import com.github.gwtbootstrap.client.ui.base.HasVisibleHandlers;
import com.github.gwtbootstrap.client.ui.constants.AlternateSize;
import com.github.gwtbootstrap.client.ui.constants.BaseIconType;
import com.github.gwtbootstrap.client.ui.constants.IconPosition;
import com.github.gwtbootstrap.client.ui.constants.IconSize;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.github.gwtbootstrap.client.ui.event.HiddenHandler;
import com.github.gwtbootstrap.client.ui.event.HideHandler;
import com.github.gwtbootstrap.client.ui.event.ShowHandler;
import com.github.gwtbootstrap.client.ui.event.ShownHandler;
import com.github.gwtbootstrap.datetimepicker.client.ui.base.DateTimeBoxBase;
import com.github.gwtbootstrap.datetimepicker.client.ui.base.HasAllDateTimePickerHandlers;
import com.github.gwtbootstrap.datetimepicker.client.ui.base.HasDateFormat;
import com.github.gwtbootstrap.datetimepicker.client.ui.base.PickerPosition;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;

import java.util.Date;

/**
 * DateTimeBoxAppended component.
 *
 * @author Carlos Alexandro Becker
 * @author Alain Penders
 * @since 2.1.1.0
 */
public class DateTimeBoxAppended
	extends AppendButton implements HasValue<Date>,
	                                HasDateFormat, HasIcon, HasValueChangeHandlers<Date>, HasVisibility,
        HasChangeHandlers, HasVisibleHandlers, HasAllDateTimePickerHandlers,
        HasAlternateSize, IsEditor<TakesValueEditor<Date>> {

    /**
     * An 'adapter' to change some aspects of the behavior of datepickerbase.
     */
    private class DateTimeBoxAppendedAdapter
	    extends DateTimeBoxBase {
        @Override
        protected void configure() {
            DateTimeBoxAppended that = DateTimeBoxAppended.this;
            that.addStyleName("date");
            super.configure(that);
        }
    }

    private final DateTimeBoxAppendedAdapter box;
    private AddOn icon;
    {
        this.box = new DateTimeBoxAppendedAdapter();
        icon = new AddOn();
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
    public void setAlternateSize(AlternateSize size) {
        box.setAlternateSize(size);
    }

    public void setAlignment(TextAlignment align) {
        box.setAlignment(align);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addValueChangeHandler(
            ValueChangeHandler<Date> dateValueChangeHandler) {
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
    public void setIcon(IconType type) {
        setBaseIcon(type);
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCustomIconStyle(String customIconStyle) {
        icon.setCustomIconStyle(customIconStyle);
    }

    /**
     * {@inheritDoc}
     *
     * @deprecated
     */
    @Override
    public void setIconPosition(IconPosition position) {
        icon.setIconPosition(position);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAutoClose(boolean autoclose) {
        box.setAutoClose(autoclose);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEndDate(String date) {
        box.setEndDate(date);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEndDate_(Date date) {
        box.setEndDate_(date);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLanguage(String language) {
        box.setLanguage(language);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStartDate(String date) {
        box.setStartDate(date);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStartDate_(Date date) {
        box.setStartDate_(date);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMinView(ViewMode mode) {
        box.setMinView(mode);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMinView(String mode) {
        box.setMinView(mode);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMaxView(ViewMode mode) {
        box.setMaxView(mode);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMaxView(String mode) {
        box.setMaxView(mode);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStartView(ViewMode mode) {
        box.setStartView(mode);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStartView(String mode) {
        box.setStartView(mode);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWeekStart(int start) {
        box.setWeekStart(start);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakesValueEditor<Date> asEditor() {
        return box.asEditor();
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

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addChangeHandler(ChangeHandler handler) {
        return box.addChangeHandler(handler);
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
    * @see com.google.gwt.user.client.ui.ValueBoxBase#isReadOnly()
    */
    public boolean isReadOnly() {
        return box.isReadOnly();
    }

    /**
     * @see com.google.gwt.user.client.ui.ValueBoxBase#setReadOnly(boolean) 
     */
    public void setReadOnly(boolean readonly) {
        box.setReadOnly(readonly);
    }


    @Override
    public void setDaysOfWeekDisabled(String value) {
        box.setDaysOfWeekDisabled(value);
    }


    @Override
    public void setMinuteStep(int minutes) {
        box.setMinuteStep(minutes);
    }


    @Override
    public void setShowTodayButton(boolean show) {
        box.setShowTodayButton(show);
    }


    @Override
    public void setHighlightToday(boolean highlight) {
        box.setHighlightToday(highlight);
    }

    public void setPickerPosition(PickerPosition pickerPosition) {
        box.setPickerPosition(pickerPosition);
    }

    public PickerPosition getPickerPosition() {
        return box.getPickerPosition();
    }
}
