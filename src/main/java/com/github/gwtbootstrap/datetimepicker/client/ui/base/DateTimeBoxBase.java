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
package com.github.gwtbootstrap.datetimepicker.client.ui.base;

import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.base.HasAlternateSize;
import com.github.gwtbootstrap.client.ui.base.HasId;
import com.github.gwtbootstrap.client.ui.base.HasPlaceholder;
import com.github.gwtbootstrap.client.ui.base.HasSize;
import com.github.gwtbootstrap.client.ui.base.HasStyle;
import com.github.gwtbootstrap.client.ui.base.HasVisibility;
import com.github.gwtbootstrap.client.ui.base.HasVisibleHandlers;
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
import com.github.gwtbootstrap.datetimepicker.client.ui.util.LocaleUtil;
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
 * Base DateTimePicker component.
 *
 * @author Carlos Alexandro Becker
 * @author ohashi keisuke
 * @author Alain Penders
 * @since 2.1.1.0
 */
public class DateTimeBoxBase
	extends Widget implements HasValue<Date>,HasEnabled, HasValueChangeHandlers<Date>, HasVisibility,
        HasChangeHandlers, HasVisibleHandlers,
        HasAllDateTimePickerHandlers, IsEditor<TakesValueEditor<Date>>, HasPlaceholder, HasAlternateSize, IsSearchQuery, HasSize, HasId, IsResponsive , HasStyle {

    private final TextBox box;
    private String format;
    private String language;
    private DateTimeFormat dtf;
    private TakesValueEditor<Date> editor;

    /** placeholderHelper */
    private PlaceholderHelper placeholderHelper = GWT.create(PlaceholderHelper.class);
    private boolean autoclose;
    private int minuteStep = 5;
    private boolean todayButton;
    private boolean highlightToday;
    private String minViewMode = ViewMode.HOUR.name().toLowerCase();
    private String startViewMode = ViewMode.MONTH.name().toLowerCase();
    private String maxViewMode = ViewMode.DECADE.name().toLowerCase();
    private PickerPosition pickerPosition = PickerPosition.BOTTOM_RIGHT;

    public DateTimeBoxBase() {
        this.box = new TextBox();
        this.language = LocaleUtil.getLanguage();
        setElement(box.getElement());
        setFormat("yyyy/mm/dd hh:ii");
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
        this.dtf = DateTimeFormat.getFormat(dpGlobalFormatToDateTimeFormat(format));
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
     * Get un-transformed text
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
        if($wnd.jQuery(e).data('datetimepicker')) {
            $wnd.jQuery(e).data('datetimepicker').update();
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

    /**
     * Configure the elements for a specific widget.
     * Use only if you know what you are doing.
     *
     * @param w: the widget to configure.
     */
    protected void configure(Widget w) {
        w.getElement().setAttribute("data-date-format", format);
        w.getElement().setAttribute("data-date-language", language);
        configure(w.getElement(), autoclose, minuteStep, todayButton, highlightToday,
                minViewMode, startViewMode, maxViewMode, pickerPosition.getValue());
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
     * configure this datetimepicker.
     */
    protected void configure() {
        configure(this);
    }

    protected native void removeDataIfExists(Element e) /*-{
        var $that = $wnd.jQuery(e);
        if($that.data('datetimepicker')) {
            console.log($that.data());
            $that.removeData('dateFormat');
            $that.removeData('dateLanguage');
            $that.removeData('dateWeekstart');
            $that.removeData('dateStartdate');
            $that.removeData('dateEnddate');
            $that.removeData('dateStartView');
            $that.removeData('datetimepicker');
            $that.off();
        }
    }-*/;

    /**
     * call jquery datetimepicker plugin in a element.
     *
     * @param e: Element that will be transformed in a datetimepicker.
     * @param autoclose  is autoclose?
     */
	@SuppressWarnings("ParameterHidesMemberVariable")
    protected native void configure(Element e,
	                                 boolean autoclose,
	                                 int minuteStep,
	                                 boolean todayButton,
	                                 boolean highlightToday,
                                    String minViewMode,
                                    String startViewMode,
                                    String maxViewMode,
                                    String pickerPosition) /*-{
        var that = this;
        $wnd.jQuery(e).datetimepicker({
            autoclose : autoclose,
            minuteStep : minuteStep,
            todayBtn : todayButton,
            todayHighlight : highlightToday,
            minView : minViewMode,
            startView : startViewMode,
            maxView : maxViewMode,
            pickerPosition: pickerPosition
        })
        .on('change' , function() {
            that.@com.github.gwtbootstrap.datetimepicker.client.ui.base.DateTimeBoxBase::onChange()();
        })
        .on('changeDate', function () {
            that.@com.github.gwtbootstrap.datetimepicker.client.ui.base.DateTimeBoxBase::onChange()();
        })
        .on("show", function (e) {
            that.@com.github.gwtbootstrap.datetimepicker.client.ui.base.DateTimeBoxBase::onShow(Lcom/google/gwt/user/client/Event;)(e);
        })
        .on("hide", function (e) {
            that.@com.github.gwtbootstrap.datetimepicker.client.ui.base.DateTimeBoxBase::onHide(Lcom/google/gwt/user/client/Event;)(e);
        });
    }-*/;

    private native void execute(Element e, String cmd) /*-{
        $wnd.jQuery(e).datetimepicker(cmd);
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
        //TODO 2012/06/21 ohashi keisuke should be support
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
        //TODO 2012/06/21 ohashi keisuke should be support
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
    	//TODO 2012/06/21 ohashi keisuke should be support
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
    public void setMinView(ViewMode mode) {
        setMinView(mode.name());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMinView(String mode) {
        this.minViewMode = mode.toLowerCase();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void setStartView(HasViewMode.ViewMode mode) {
        setStartView(mode.name());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStartView(String mode) {
        this.startViewMode = mode.toLowerCase();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMaxView(ViewMode mode) {
        setMaxView(mode.name());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMaxView(String mode) {
        this.maxViewMode = mode.toLowerCase();
    }


    /**
	 * Return Editor
     *
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


	@Override
	public void setDaysOfWeekDisabled(String value) {
		getElement().setAttribute("date-days-of-week-disabled", value);
	}


	@Override
	public void setMinuteStep(int minutes) {
//		getElement().setAttribute("date-days-of-week-disabled", value);
		this.minuteStep = minutes;
	}


	@Override
	public void setShowTodayButton(boolean show) {
		this.todayButton = show;
	}


	@Override
	public void setHighlightToday(boolean highlight) {
		this.highlightToday = highlight;
	}

    public PickerPosition getPickerPosition() {
        return pickerPosition;
    }

    public void setPickerPosition(PickerPosition pickerPosition) {
        this.pickerPosition = pickerPosition;
    }

    private String dpGlobalFormatToDateTimeFormat(String dpGlobalFormat)
    {
        if(dpGlobalFormat == null || dpGlobalFormat.length() == 0)
            return "";

        char current;
        char last = dpGlobalFormat.charAt(0);
        int count = 1;
        String out = "";

        for(int index = 1; index < dpGlobalFormat.length(); index++)
        {
            current = dpGlobalFormat.charAt(index);

            if(current == last)
            {
                count++;
                continue;
            }

            out += processToken(last, count);

            last = current;
            count = 1;
        }

        out += processToken(last, count);

        return out;
    }

    private String processToken(char token, int count)
    {
        if (token == 'y') {
            if (count == 2)
                return "yy";
            if(count == 4)
                return "yyyy";
        }
        else if(token == 'm') {
            if(count == 1)
                return "M";
            if(count == 2)
                return "MM";
        }
        else if(token == 'M') {
            if(count == 1)
                return "MMM";
            if(count == 2)
                return "MMMM";
        }
        else if(token == 'h') {
            token = 'H';
        }
        else if(token == 'i') {
            token = 'm';
        }

        String out = "";
        for(int i=0; i<count; i++)
            out += token;

        return out;

        // TODO: Support PHP format so we can do more complex formatting
    }

    /*
    DateTimeFormat

    G	era designator	Text	AD
    y	year	Number	1996
    M	month in year	Text or Number	July (or) 07
    d	day in month	Number	10
    h	hour in am/pm (1-12)	Number	12
    H	hour in day (0-23)	Number	0
    m	minute in hour	Number	30
    s	second in minute	Number	55
    S	fractional second	Number	978
    E	day of week	Text	Tuesday
    a	am/pm marker	Text	PM
    k	hour in day (1-24)	Number	24
    K	hour in am/pm (0-11)	Number	0
    z	time zone	Text	Pacific Standard Time
    Z	time zone (RFC 822)	Number	-0800
    v	time zone (generic)	Text	Pacific Time
    '	escape for text	Delimiter	'Date='
    ''	single quote	Literal	'o''clock'
     */
}
