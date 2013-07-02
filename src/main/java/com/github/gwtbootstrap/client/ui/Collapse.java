package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HasVisibility;
import com.github.gwtbootstrap.client.ui.event.HasVisibleHandlers;
import com.github.gwtbootstrap.client.ui.base.MarkupWidget;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.VisibilityChange;
import com.github.gwtbootstrap.client.ui.event.HiddenEvent;
import com.github.gwtbootstrap.client.ui.event.HiddenHandler;
import com.github.gwtbootstrap.client.ui.event.HideEvent;
import com.github.gwtbootstrap.client.ui.event.HideHandler;
import com.github.gwtbootstrap.client.ui.event.ShowEvent;
import com.github.gwtbootstrap.client.ui.event.ShowHandler;
import com.github.gwtbootstrap.client.ui.event.ShownEvent;
import com.github.gwtbootstrap.client.ui.event.ShownHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;

/**
 * Markup widget of Collapse
 * <p>
 * It's a markup widget (decorator widget).
 * it's can exchange child to Collapsible widget.
 * 
 * It's need trigger, You have 2 ways to create trigger.<br/>
 * <ol>
 *   <li> Using {@link CollapseTrigger}. </li>
 *   <li> Calling {@link #toggle()}. </li>
 * </ol>
 * </p>
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * </p>
 * <pre>
 * {@code
 * <b:Collapse b:id="toggle1" defaultOpen="true">
 *   <!-- it can be added any widget, but accept one wdiget.
 *   <b:Label>aaa</b:Label>
 * </b:Collapse>
 * }
 * </pre>
 * 
 * @since 2.2.1.0
 * @author ohashi keisuke
 * @see Accordion
 * @see Collapse
 * @see CollapseTrigger
 * @see <a href="http://twitter.github.com/bootstrap/javascript.html#collapse">Twitter Bootstrap document</a>
 * 
 *
 */
public class Collapse extends MarkupWidget implements HasVisibility, HasVisibleHandlers {

    private String parent;
    
    private boolean toggle = false;
    
    private boolean existTrigger = false;

    private boolean dafaultOpen;

    /**
     * Get parent selector
     * @return parent parent selector
     */
    public String getParent() {
        return parent;
    }

    /**
     * Set parent selector.
     * 
     * it only work with {@link AccordionGroup},
     * Please see <a href="https://github.com/twitter/bootstrap/issues/4988">this issue</a>.
     * 
     * @param parent parent selector
     */
    public void setParent(String parent) {
        this.parent = parent;
    }

    /**
     * is the collapsible element toggled on invocation
     * @return toggle true:toggled , false: un-toggled
     */
    public boolean isToggle() {
        return toggle;
    }

    /**
     * Toggles the collapsible element on invocation
     * @param toggle true: toggled on invocation , false : not-toggled
     */
    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }
    
    public void setDefaultOpen(boolean dafaultOpen) {
        this.dafaultOpen = dafaultOpen;
        
        if(widget != null && !widget.isAttached()) {
            widget.setStyleName(Constants.IN , dafaultOpen);
        }
        
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Widget asWidget() {
        
        if(widget != null) {
            Scheduler.get().scheduleDeferred(new ScheduledCommand() {
                
                @Override
                public void execute() {
                    if(!isExistTrigger()){
                        reconfigure();
                    } else {
                        configure(widget.getElement(), parent, toggle);
                        setHandlerFunctions(widget.getElement());
                    }
                }
            });
        }
        
        return getWidget();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setWidget(Widget w) {
        super.setWidget(w);
        
        if(widget != null) {
            widget.addStyleName(Constants.COLLAPSE);
        }
        
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addHideHandler(HideHandler handler) {
        return getWidget().addHandler(handler, HideEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addHiddenHandler(HiddenHandler handler) {
        return getWidget().addHandler(handler, HiddenEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addShowHandler(ShowHandler handler) {
        return getWidget().addHandler(handler, ShowEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addShownHandler(ShownHandler handler) {
        return getWidget().addHandler(handler, ShownEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    //@Override
    public void show(boolean autoShown) {
        changeVisibility(VisibilityChange.SHOW, autoShown);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void show() {
        changeVisibility(VisibilityChange.SHOW);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hide() {
        changeVisibility(VisibilityChange.HIDE);
    }

    /**
     * {@inheritDoc}
     */
    //@Override
    public void hide(boolean autoHidden) {
        changeVisibility(VisibilityChange.HIDE, autoHidden);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void toggle() {
        changeVisibility(VisibilityChange.TOGGLE);
    }

    /**
     * Change visibility
     * @param visibilityChange call method
     */
    protected void changeVisibility(VisibilityChange visibilityChange) {
        
        if(widget == null) return;
        
        changeVisibility(widget.getElement() , visibilityChange.get());
    }

    protected void changeVisibility(VisibilityChange visibilityChange, boolean autoTriggered) {

        if(widget == null) return;

        changeVisibility(widget.getElement() , visibilityChange.get(), autoTriggered);
    }
    
    /**
     * Is exist Trigger?
     * @return existTrigger
     */
    public boolean isExistTrigger() {
        return existTrigger;
    }

    /**
     * Is there the trigger(Collapse Trigger)
     * @param existTrigger exists:true, none:false
     */
    public void setExistTrigger(boolean existTrigger) {
        this.existTrigger = existTrigger;
    }
    
    /**
     * re configure setting
     */
    public void reconfigure() {
        
        if(widget == null) return;
        
        setDefaultOpen(dafaultOpen);
        
        removeDataIfExists(widget.getElement());
        
        setHandlerFunctions(widget.getElement());
        
        configure(widget.getElement(), parent, toggle);
    }
    
    //@fomatter:off
    /**
     * Configure collapse settings.
     * @param e element
     * @param parent parent selector
     * @param toggle is toggled on added document
     */
    public native void configure(Element e, String parent, boolean toggle) /*-{
        $wnd.jQuery(e).collapse({
            "parent" : parent || false,
            "toggle" : toggle
        });
    }-*/;
    
    /**
     * Configure collapse settings.
     * @param selector selector
     * @param parent parent selector
     * @param toggle is toggled on added document
     */
    public static native void configure(String selector, String parent, boolean toggle) /*-{
        $wnd.jQuery(selector).collapse({
            "parent" : parent || false,
            "toggle" : toggle
        });
        
    }-*/;

    /**
     * Remove data api.
     * @param e element
     */
    protected native void removeDataIfExists(Element e) /*-{
        var $this = $wnd.jQuery(e);
        if($this.data('collapse')) {
            $this.removeData('parent').removeData('toggle').removeData('collapse');
        }
    }-*/;
    
    /**
     * Links the Java functions that fire the events.
     */
    protected native void setHandlerFunctions(Element e) /*-{
        var that = this;
        var $this = $wnd.jQuery(e);

        var autoTriggeredCheck = function (event, removeProperty) {
            var collapse = $wnd.jQuery(event.target).data('collapse');
            if (collapse && collapse.autoTriggered) {
                event.autoTriggered = true;
                if (removeProperty)
                    collapse.autoTriggered = false;
            }
        };

        $this.off('show');
        $this.off('shown');
        $this.off('hide');
        $this.off('hidden');

        $this.on('hide', function(e) {
            if (e.target === this) {
                autoTriggeredCheck(e);
                that.@com.github.gwtbootstrap.client.ui.Collapse::onHide(Lcom/google/gwt/user/client/Event;)(e);
                e.stopPropagation();
            }
        });
        $this.on('hidden', function(e) {
            if (e.target === this) {
                autoTriggeredCheck(e, true);
                that.@com.github.gwtbootstrap.client.ui.Collapse::onHidden(Lcom/google/gwt/user/client/Event;)(e);
                e.stopPropagation();
            }
        });
        $this.on('show', function(e) {
            if (e.target === this) {
                autoTriggeredCheck(e);
                that.@com.github.gwtbootstrap.client.ui.Collapse::onShow(Lcom/google/gwt/user/client/Event;)(e);
                e.stopPropagation();
            }
        });
        $this.on('shown', function(e) {
            if (e.target === this) {
                autoTriggeredCheck(e, true);
                that.@com.github.gwtbootstrap.client.ui.Collapse::onShown(Lcom/google/gwt/user/client/Event;)(e);
                e.stopPropagation();
            }
        });
    }-*/;

    protected native void changeVisibility(Element e , String c) /*-{
        $wnd.jQuery(e).collapse(c);
    }-*/;

    protected native void changeVisibility(Element e, String visibility, boolean autoTriggered) /*-{
        var $e = $wnd.jQuery(e);

        var collapse = $e.data('collapse');
        if (collapse)
            collapse.autoTriggered = autoTriggered;

        $e.collapse(c);

    }-*/;
    
    public static native void changeVisibility(String target , String c) /*-{
        $wnd.jQuery(target).collapse(c);
    }-*/;

    public static native void changeVisibility(String target , String c, boolean autoTriggered) /*-{
        var $e = $wnd.jQuery(e);

        var collapse = $e.data('collapse');
        if (collapse)
            collapse.autoTriggered = autoTriggered;

        $e.collapse(c);
    }-*/;
    //@fomatter:on

    private native boolean getAutoTriggered(JavaScriptObject jso) /*-{
        // Prevent null result
        if (jso.autoTriggered) return true;
        return false;
    }-*/;

    /**
     * This method is called immediately when the widget's {@link #hide()}
     * method is executed.
     */
    protected void onHide(Event e) {
        widget.fireEvent(new HideEvent(e, getAutoTriggered(e)));
    }

    /**
     * This method is called once the widget is completely hidden.
     */
    protected void onHidden(Event e) {
        widget.fireEvent(new HiddenEvent(e, getAutoTriggered(e)));
    }

    /**
     * This method is called immediately when the widget's {@link #show()}
     * method is executed.
     */
    protected void onShow(Event e) {
        widget.fireEvent(new ShowEvent(e, getAutoTriggered(e)));
    }

    /**
     * This method is called once the widget is completely shown.
     */
    protected void onShown(Event e) {
        widget.fireEvent(new ShownEvent(e, getAutoTriggered(e)));
    }
}
