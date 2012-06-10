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
package com.github.gwtbootstrap.datepicker.client.ui.base;

import java.util.Date;

import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.base.HasVisibility;
import com.github.gwtbootstrap.client.ui.base.HasVisibleHandlers;
import com.github.gwtbootstrap.client.ui.event.HiddenEvent;
import com.github.gwtbootstrap.client.ui.event.HiddenHandler;
import com.github.gwtbootstrap.client.ui.event.HideEvent;
import com.github.gwtbootstrap.client.ui.event.HideHandler;
import com.github.gwtbootstrap.client.ui.event.ShowEvent;
import com.github.gwtbootstrap.client.ui.event.ShowHandler;
import com.github.gwtbootstrap.client.ui.event.ShownEvent;
import com.github.gwtbootstrap.client.ui.event.ShownHandler;
import com.github.gwtbootstrap.datepicker.client.ui.util.LocaleUtil;
import com.google.gwt.dom.client.Element;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

/**
 * Base DatePicker component.
 *
 * @author Carlos Alexandro Becker
 * @since 2.0.4.0
 */
public class DateBoxBase extends Widget implements HasValue<Date>, HasValueChangeHandlers<Date>, HasVisibility,
        HasVisibleHandlers, HasAllDatePickerHandlers, IsEditor<TakesValueEditor<Date>> {

    private final TextBox box;
    private String format;
    private String language;
    private DateTimeFormat dtf;
	private TakesValueEditor<Date> editor;

    public DateBoxBase() {
        this.box = new TextBox();
        setElement(box.getElement());
        setFormat("mm/dd/yyyy");
        this.language = LocaleUtil.getLanguage();
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

    public void setLanguage(String language) {
        this.language = language;
        LocaleUtil.forceLocale(language);
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
        try {
            return dtf != null && box.getValue() != null ? dtf.parse(box.getValue()) : null;
        } catch(Exception e) {
            return null;
        }
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
        box.setValue(value != null ? dtf.format(value) : null);
        
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
        w.getElement().setAttribute("data-date-language", language);
        configure(w.getElement());
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

    /**
     * call jquery datepicker plugin in a element.
     *
     * @param e: Element that will be transformed in a datepicker.
     */
    protected native void configure(Element e) /*-{
        var that = this;
        $wnd.jQuery(e).datepicker();
//        $wnd.jQuery(e).on('changeDate', function () {
//            that.@com.github.gwtbootstrap.datepicker.client.ui.base.DateBoxBase::onChange()();
//        });
//        $wnd.jQuery(e).on("show", function () {
//            that.@com.github.gwtbootstrap.datepicker.client.ui.base.DateBoxBase::show()();
//        });
//        $wnd.jQuery(e).on("hide", function () {
//            that.@com.github.gwtbootstrap.datepicker.client.ui.base.DateBoxBase::hide()();
//        });
    }-*/;

    private native void execute(Element e, String cmd) /*-{
        $wnd.jQuery(e).datepicker(cmd);
    }-*/;

    private void execute(String cmd) {
        execute(getElement(), cmd);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void show() {
        execute("show");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hide() {
        execute("hide");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void toggle() {
        // TODO toggle.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addHideHandler(HideHandler handler) {
        return addHandler(handler, HideEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addHiddenHandler(HiddenHandler handler) {
        return addHandler(handler, HiddenEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addShowHandler(ShowHandler handler) {
        return addHandler(handler, ShowEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addShownHandler(ShownHandler handler) {
        return addHandler(handler, ShownEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWeekStart(int start) {
        getElement().setAttribute("data-date-weekstart", start + "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStartDate(String startDate) {
        getElement().setAttribute("data-date-startdate", startDate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStartDate_(Date startDate) {
        setStartDate(dtf.format(startDate));
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void setEndDate(String endDate) {
        getElement().setAttribute("data-date-enddate", endDate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEndDate_(Date endDate) {
        setEndDate(dtf.format(endDate));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAutoClose(boolean autoclose) {
        getElement().setAttribute("data-date-autoclose", autoclose + "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStartView(ViewMode mode) {
        setStartView(mode.name());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStartView(String mode) {
        getElement().setAttribute("data-date-startview", mode.toLowerCase());
    }

	/**
	 * Retuen Editor
	 * @return editor
	 */
	@Override
	public TakesValueEditor<Date> asEditor() {
		if(editor == null){
			editor = TakesValueEditor.of(this);
		}
		return editor;
	}
}
