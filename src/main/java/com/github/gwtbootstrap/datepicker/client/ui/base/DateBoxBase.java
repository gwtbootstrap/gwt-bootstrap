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

import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.base.HasAlternateSize;
import com.github.gwtbootstrap.client.ui.base.HasId;
import com.github.gwtbootstrap.client.ui.base.HasPlaceholder;
import com.github.gwtbootstrap.client.ui.base.HasSize;
import com.github.gwtbootstrap.client.ui.base.HasStyle;
import com.github.gwtbootstrap.client.ui.base.HasVisibility;
import com.github.gwtbootstrap.client.ui.event.HasVisibleHandlers;
import com.github.gwtbootstrap.client.ui.base.IsResponsive;
import com.github.gwtbootstrap.client.ui.base.IsSearchQuery;
import com.github.gwtbootstrap.client.ui.base.PlaceholderHelper;
import com.github.gwtbootstrap.client.ui.base.ResponsiveHelper;
import com.github.gwtbootstrap.client.ui.base.SearchQueryStyleHelper;
import com.github.gwtbootstrap.client.ui.base.SizeHelper;
import com.github.gwtbootstrap.client.ui.base.Style;
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.constants.AlternateSize;
import com.github.gwtbootstrap.client.ui.constants.Device;
import com.github.gwtbootstrap.client.ui.event.HiddenHandler;
import com.github.gwtbootstrap.client.ui.event.HideEvent;
import com.github.gwtbootstrap.client.ui.event.HideHandler;
import com.github.gwtbootstrap.client.ui.event.ShowEvent;
import com.github.gwtbootstrap.client.ui.event.ShowHandler;
import com.github.gwtbootstrap.client.ui.event.ShownHandler;
import com.github.gwtbootstrap.datepicker.client.ui.util.LocaleUtil;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;
import com.google.gwt.user.client.ui.Widget;

import java.util.Date;

/**
 * Base DatePicker component.
 *
 * @author Carlos Alexandro Becker
 * @author ohashi keisuke
 * @since 2.0.4.0
 */
public class DateBoxBase extends Widget implements HasValue<Date>,HasEnabled, HasValueChangeHandlers<Date>, HasVisibility,
        HasChangeHandlers, HasVisibleHandlers, HasAllDatePickerHandlers, IsEditor<TakesValueEditor<Date>>, HasPlaceholder, HasAlternateSize, IsSearchQuery, HasSize, HasId, IsResponsive , HasStyle {

    private final TextBox box;
    private String format;
    private String language;
    private DateTimeFormat dtf;
    private TakesValueEditor<Date> editor;

    /** placeholderHelper */
    private PlaceholderHelper placeholderHelper = GWT.create(PlaceholderHelper.class);
    private boolean autoclose = false;

    public DateBoxBase() {
        this.box = new TextBox();
        this.language = LocaleUtil.getLanguage();
        setElement(box.getElement());
        setFormat(DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_SHORT).getPattern().toLowerCase());
        setWeekStart(LocaleInfo.getCurrentLocale().getDateTimeFormatInfo().firstDayOfTheWeek());
        setValue(new Date());
    }

    public void setAlignment(TextAlignment align) {
        box.setAlignment(align);
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
     * Get un-tranceform text
     * @return text box value
     */
    public String getOriginalValue() {
        return box.getValue();
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

        updateValue(box.getElement());

        if (fireEvents) {
            ValueChangeEvent.fire(this, value);
        }
    }

    protected native void updateValue(Element e)/*-{
        if($wnd.jQuery(e).data('datepicker')) {
            $wnd.jQuery(e).data('datepicker').update();
        }
    }-*/;

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

    @Override
    protected void onUnload() {
        super.onUnload();
        execute("remove");
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
        configure(w.getElement(), autoclose);
    }

    /**
     * dateChange event handler.
     */
    public void onChange() {
        ValueChangeEvent.fire(this, getValue());
    }

    public void onShow(Event e) {
        fireEvent(new ShowEvent(e));
    }

    public void onHide(Event e) {
        fireEvent(new HideEvent(e));
    }
    public void reconfigure() {
        removeDataIfExists(getElement());
        configure();
    }

    /**
     * configure this datepicker.
     */
    protected void configure() {
        configure(this);
    }

    protected native void removeDataIfExists(Element e) /*-{
        var $that = $wnd.jQuery(e);
        if($that.data('datepicker')) {
            console.log($that.data());
            $that.removeData('dateFormat');
            $that.removeData('dateLanguage');
            $that.removeData('dateWeekstart');
            $that.removeData('dateStartdate');
            $that.removeData('dateEnddate');
            $that.removeData('dateStartView');
            $that.removeData('datepicker');
            $that.off();
        }
    }-*/;

    /**
     * call jquery datepicker plugin in a element.
     *
     * @param e: Element that will be transformed in a datepicker.
     * @param autoclose  is autoclose?
     */
    protected native void configure(Element e, boolean autoclose) /*-{
        var that = this;
        $wnd.jQuery(e).datepicker({autoclose : autoclose})
        .on('change' , function() {
            that.@com.github.gwtbootstrap.datepicker.client.ui.base.DateBoxBase::onChange()();
        })
        .on("show", function (e) {
            that.@com.github.gwtbootstrap.datepicker.client.ui.base.DateBoxBase::onShow(Lcom/google/gwt/user/client/Event;)(e);
        })
        .on("hide", function (e) {
            that.@com.github.gwtbootstrap.datepicker.client.ui.base.DateBoxBase::onHide(Lcom/google/gwt/user/client/Event;)(e);
        });
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
        //TODO 2012/06/21 ohashi keisuke shoud be support
        throw new UnsupportedOperationException("not support toggle");
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
        //TODO 2012/06/21 ohashi keisuke shoud be support
        throw new UnsupportedOperationException("not support hidden event");
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
    	//TODO 2012/06/21 ohashi keisuke shoud be support
        throw new UnsupportedOperationException("not support shown event");
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
        this.autoclose = autoclose;
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
        getElement().setAttribute("data-date-start-view", mode.toLowerCase());
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

    @Override
    public HandlerRegistration addChangeHandler(ChangeHandler handler) {
        return addHandler(handler, ChangeEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPlaceholder(String placeholder) {
        placeholderHelper.setPlaceholer(getElement(), placeholder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPlaceholder() {
        return placeholderHelper.getPlaceholder(getElement());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSearchQuery(boolean searchQuery) {
        SearchQueryStyleHelper.setSearchQuery(this, searchQuery);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSearchQuery() {
        return SearchQueryStyleHelper.isSearchQuery(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAlternateSize(AlternateSize size) {
        StyleHelper.changeStyle(this, size, AlternateSize.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSize(int size) {
        SizeHelper.setSize(this, size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return getElement().getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(String id) {
        getElement().setId(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setShowOn(Device device) {
        ResponsiveHelper.setShowOn(this, device);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHideOn(Device device) {
        ResponsiveHelper.setHideOn(this, device);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStyle(Style style) {
        StyleHelper.setStyle(this, style);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addStyle(Style style) {
        StyleHelper.addStyle(this, style);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeStyle(Style style) {
        StyleHelper.removeStyle(this, style);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnabled() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEnabled(boolean enabled) {
        box.setEnabled(enabled);
    }
}
