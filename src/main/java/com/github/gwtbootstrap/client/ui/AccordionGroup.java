package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.base.HasIcon;
import com.github.gwtbootstrap.client.ui.base.HasVisibility;
import com.github.gwtbootstrap.client.ui.event.HasVisibleHandlers;
import com.github.gwtbootstrap.client.ui.base.IconAnchor;
import com.github.gwtbootstrap.client.ui.constants.*;
import com.github.gwtbootstrap.client.ui.event.HiddenHandler;
import com.github.gwtbootstrap.client.ui.event.HideHandler;
import com.github.gwtbootstrap.client.ui.event.ShowHandler;
import com.github.gwtbootstrap.client.ui.event.ShownHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.user.client.ui.Widget;

/**
 * Collapsible Widget like accordion.
 * <p>
 * Please see {@link Accordion}
 * </p>
 * @since 2.2.1.0
 * @author ohashi keisuke
 * @see Accordion
 * @see Collapse
 * @see CollapseTrigger
 * @see <a href="http://twitter.github.com/bootstrap/javascript.html#collapse">Twitter Bootstrap document</a>
 *
 */
public class AccordionGroup extends DivWidget implements HasIcon, HasVisibility, HasVisibleHandlers  {

    private DivWidget innerBody = new DivWidget(Constants.ACCORDION_INNER);
    
    private IconAnchor trigger = new IconAnchor();

    private Collapse collapse;

    private CollapseTrigger collapseTrigger;
    
    private boolean defaultOpen;
    
    public AccordionGroup() {
        super(Constants.ACCORDION_GROUP);
        
        DivWidget body = new DivWidget(Constants.ACCORDION_BODY);
        
        body.add(innerBody);

        collapse = new Collapse();
        
        collapse.setWidget(body);
        
        collapse.setExistTrigger(true);
        
        trigger.addStyleName(Constants.ACCORDION_TOGGLE);
        
        collapseTrigger = new CollapseTrigger("#" + collapse.getId());

        collapseTrigger.setAccordionTrigger(true);

        collapseTrigger.setWidget(trigger);

        DivWidget heading = new DivWidget(Constants.ACCORDION_HEADING);
        
        heading.add(collapseTrigger);

        super.add(heading);
        
        super.add(collapse.asWidget());
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
        trigger.setBaseIcon(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconSize(IconSize size) {
        trigger.setIconSize(size);
    }
    
    public void setParent(String parent) {
        collapseTrigger.setParent(parent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addHideHandler(HideHandler handler) {
        return collapse.addHideHandler(handler);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addHiddenHandler(HiddenHandler handler) {
        return collapse.addHiddenHandler(handler);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addShowHandler(ShowHandler handler) {
        return collapse.addShowHandler(handler);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addShownHandler(ShownHandler handler) {
        return collapse.addShownHandler(handler);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void show() {
        collapse.show();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hide() {
        collapse.hide();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void toggle() {
        collapse.toggle();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Widget w) {
        innerBody.add(w);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        innerBody.clear();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Widget w) {
        return innerBody.remove(w);
    }
    
    /**
     * Add a widget to trigger anchor
     * @param w added widget
     */
    @UiChild(limit=1,tagname="customTrigger")
    public void addCustomTrigger(Widget w) {
        trigger.insert(w, 0);
    }

    /**
     * is opened on attached.
     * @return defaultOpen true:open false:close
     */
    public boolean isDefaultOpen() {
        return defaultOpen;
    }

    /**
     * Set is opened on attached.
     * @param defaultOpen true:open false:close
     */
    public void setDefaultOpen(boolean defaultOpen) {
        this.defaultOpen = defaultOpen;
        
        if(!isAttached()) {
            collapse.getWidget().setStyleName("in", defaultOpen);
        }
        
    }
    
    public void setHeading(String heading) {
        trigger.setText(heading);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCustomIconStyle(String customIconStyle) {
        trigger.setCustomIconStyle(customIconStyle);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconPosition(IconPosition position) {
        trigger.setIconPosition(position);
    }
    
}
