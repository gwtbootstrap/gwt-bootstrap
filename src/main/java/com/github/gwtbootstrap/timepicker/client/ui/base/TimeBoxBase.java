package com.github.gwtbootstrap.timepicker.client.ui.base;

import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.base.HasAlternateSize;
import com.github.gwtbootstrap.client.ui.base.HasId;
import com.github.gwtbootstrap.client.ui.base.HasPlaceholder;
import com.github.gwtbootstrap.client.ui.base.HasSize;
import com.github.gwtbootstrap.client.ui.base.HasStyle;
import com.github.gwtbootstrap.client.ui.base.HasVisibility;
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
import com.github.gwtbootstrap.client.ui.event.HasVisibleHandlers;
import com.github.gwtbootstrap.client.ui.event.HiddenEvent;
import com.github.gwtbootstrap.client.ui.event.HiddenHandler;
import com.github.gwtbootstrap.client.ui.event.HideEvent;
import com.github.gwtbootstrap.client.ui.event.HideHandler;
import com.github.gwtbootstrap.client.ui.event.ShowEvent;
import com.github.gwtbootstrap.client.ui.event.ShowHandler;
import com.github.gwtbootstrap.client.ui.event.ShownEvent;
import com.github.gwtbootstrap.client.ui.event.ShownHandler;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

import java.util.Date;

/**
 * Base TimePicker component.
 *
 * @author Carlos Alexandro Becker
 * @author Joshua Godi
 * @since 2.3.2.0
 */
public class TimeBoxBase extends Widget implements HasVisibleHandlers, HasPlaceholder, HasTemplate, HasShowInputs, HasSecondStep,
        HasModalBackdrop, HasMinuteStep, HasDisableFocus, HasDefaultTime, HasShowSeconds, HasMeridian, HasAlternateSize,
        IsSearchQuery, HasSize, HasId, IsResponsive, HasStyle, HasValue<Date>, HasEnabled, HasValueChangeHandlers<Date>, HasVisibility, HasTimeFormat {

    private final TextBox box;
    private String format;
    private DateTimeFormat dtf;

    // Defaults
    private Template template = Template.DROPDOWN;
    private int minuteStep = 15;
    private boolean showSeconds = false;
    private int secondStep = 15;
    private DefaultTime defaultTime = DefaultTime.CURRENT;
    private boolean showMeridian = false;
    private boolean showInputs = true;
    private boolean disableFocus = false;
    private boolean modalBackdrop = false;

    /**
     * placeholderHelper
     */
    private PlaceholderHelper placeholderHelper = GWT.create(PlaceholderHelper.class);

    public TimeBoxBase() {
        box = new TextBox();
        box.setStyleName("input-mini");
        setElement(box.getElement());
        setFormat("HH:mm:ss a");
        setValue(new Date());
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
     * Returns the internal instance of textbox element. Use only if know what you are doing.
     *
     * @return internal textbox intance.
     */
    protected TextBox getBox() {
        return box;
    }

    /**
     * Get un-transformed text
     *
     * @return text box value
     */
    public String getOriginalValue() {
        return box.getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getValue() {
        try {
            return dtf != null && box.getValue() != null ? dtf.parse(box.getValue()) : null;
        } catch (Exception e) {
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
    protected native void updateValue(Element e)/*-{
        if ($wnd.jQuery(e).data('changeTime.timepicker')) {
            $wnd.jQuery(e).data('changeTime.timepicker').update();
        }
    }-*/;

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

    /**
     * configure this timepicker
     */
    protected void configure() {
        configure(this);
    }

    /**
     * Configure the elements for a specific widget.
     * Use only if you know what you are doing.
     *
     * @param w: the widget to configure.
     */
    protected void configure(Widget w) {
        w.getElement().setAttribute("data-date-format", format);
        configure(w.getElement(), template.name().toLowerCase(), defaultTime.name().toLowerCase(), minuteStep, showSeconds, secondStep, showMeridian,
                showInputs, disableFocus, modalBackdrop);
    }

    /**
     * call jquery timepicker plugin in a element.
     *
     * @param e: Element that will be transformed in a timepicker.
     */
    protected native void configure(Element e, String template, String defaultTime, int minuteStep, boolean showSeconds, int secondStep,
                                    boolean showMeridian, boolean showInputs, boolean disableFocus, boolean modalBackdrop) /*-{
        $wnd.jQuery(e).timepicker(
            {
                template: template,
                defaultTime: defaultTime,
                minuteStep: minuteStep,
                showSeconds: showSeconds,
                secondStep: secondStep,
                showMeridian: showMeridian,
                showInputs: showInputs,
                disableFocus: disableFocus,
                modalBackdrop: modalBackdrop
            }
        );
    }-*/;

    private native void execute(Element e, String cmd) /*-{
        $wnd.jQuery(e).timepicker(cmd);
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

    @Override
    public void toggle() {
        execute("toggle");
    }

    /**
     * Safely removes data
     *
     * @param e: Element that will be cleared
     */
    protected native void removeDataIfExists(Element e) /*-{
        var $that = $wnd.jQuery(e);
        data = $that.data('timepicker');
        if (data) {
            picker = data.picker;
            $that.removeData('timepicker');
            picker.remove();
            $that.off();
        }
    }-*/;

    /**
     * Removes any data in the time picker and reconfigures it
     */
    public void reconfigure() {
        removeDataIfExists(getElement());
        configure(getElement(), template.name().toLowerCase(), defaultTime.name().toLowerCase(), minuteStep, showSeconds, secondStep, showMeridian,
                showInputs, disableFocus, modalBackdrop);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onLoad() {
        super.onLoad();
        configure(getElement(), template.name().toLowerCase(), defaultTime.name().toLowerCase(), minuteStep, showSeconds, secondStep, showMeridian,
                showInputs, disableFocus, modalBackdrop);
    }

    /**
     * This method is called immediately before a widget will be detached from the browser's document.
     */
    @Override
    protected void onUnload() {
        super.onUnload();
        execute("remove");
        removeDataIfExists(getElement());
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
    public void setTemplate(Template template) {
        this.template = template;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTemplate(String template) {
        this.template = Template.valueOf(template);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMeridian(boolean meridian) {
        this.showMeridian = meridian;
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
    public void setSize(int size) {
        SizeHelper.setSize(this, size);
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
    public void setShowOn(Device device) {
        ResponsiveHelper.setHideOn(this, device);
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
    public boolean isEnabled() {
        return box.isEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEnabled(boolean enabled) {
        box.setEnabled(enabled);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setShowSeconds(boolean showSeconds) {
        this.showSeconds = showSeconds;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDisableFocus(boolean disableFocus) {
        this.disableFocus = disableFocus;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setModalBackdrop(boolean modalBackdrop) {
        this.modalBackdrop = modalBackdrop;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setShowInputs(boolean showInputs) {
        this.showInputs = showInputs;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMinuteStep(int minuteStep) {
        this.minuteStep = minuteStep;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSecondStep(int secondStep) {
        this.secondStep = secondStep;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDefaultTime(DefaultTime defaultTime) {
        this.defaultTime = defaultTime;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDefaultTime(String defaultTime) {
        this.defaultTime = DefaultTime.valueOf(defaultTime);
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
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Date> handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }

    @Override
    public void setFormat(String format) {
        this.format = format;
        Date oldValue = getValue();
        this.dtf = DateTimeFormat.getFormat(format);
        if (oldValue != null) {
            setValue(oldValue);
        }
    }
}
