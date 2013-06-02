package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HasPlacement;
import com.github.gwtbootstrap.client.ui.base.HasShowDelay;
import com.github.gwtbootstrap.client.ui.base.HasTrigger;
import com.github.gwtbootstrap.client.ui.base.IsAnimated;
import com.github.gwtbootstrap.client.ui.constants.Placement;
import com.github.gwtbootstrap.client.ui.constants.Trigger;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasText;

import java.util.Set;

/**
 * Cell decorator as a Tooltip.
 * @author ohashi keisuke
 *
 * @param <C> Decorated Cell Parameter
 */
public class TooltipCellDecorator<C> implements Cell<C> ,IsAnimated, HasTrigger, HasPlacement, HasText, HasShowDelay{

    /**
     * Whether the widget is animated or not.
     */
    protected boolean animated = true;

    /**
     * The placement of the widget relative to its trigger element.
     */
    protected Placement placement = Placement.TOP;

    /**
     * The action that triggers the widget.
     */
    protected Trigger trigger = Trigger.HOVER;

    /**
     * The delay until the widget is shown.
     */
    protected int showDelayInMilliseconds = 0;

    /**
     * The delay until the widget is hidden.
     */
    protected int hideDelayInMilliseconds = 0;

    /**
     * Appends the popover to a specific element.
     */
    protected String container;

    interface Template extends SafeHtmlTemplates {
        @Template("<span class='gb-tooltip-cell' id='{0}'>{1}</span>")
        SafeHtml span(String id , SafeHtml content);
        
    }
    
    private static Template template = GWT.create(Template.class);

    private final Cell<C> cell;

    private String tooltip;
    
    /**
     * Create Decorator cell
     * @param cell decorated cell
     */
    public TooltipCellDecorator(Cell<C> cell) {
        this.cell = cell;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean dependsOnSelection() {
        return cell.dependsOnSelection();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<String> getConsumedEvents() {
        return cell.getConsumedEvents();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean handlesSelection() {
        return cell.handlesSelection();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEditing(com.google.gwt.cell.client.Cell.Context context,
            Element parent, C value) {
        return cell.isEditing(context, getCellParent(parent), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBrowserEvent(com.google.gwt.cell.client.Cell.Context context,
            Element parent, C value, NativeEvent event,
            ValueUpdater<C> valueUpdater) {
        cell.onBrowserEvent(context, getCellParent(parent), value, event, valueUpdater);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(final com.google.gwt.cell.client.Cell.Context context,
            final C value, SafeHtmlBuilder sb) {
        
        SafeHtmlBuilder cellBuilder = new SafeHtmlBuilder();

        cell.render(context, value, cellBuilder);

        final String id = DOM.createUniqueId();
        sb.append(template.span(id, cellBuilder.toSafeHtml()));
        
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
            
            @Override
            public void execute() {
                
                Tooltip.configure("#" + id + "> :first-child",
                    getTooltipText(context, value),
                    getAnimation(context, value),
                    getPlacement(context, value).get(),
                    getTrigger(context, value).get(),
                    getShowDelay(context, value),
                    getHideDelay(context, value),
                    getContainer()
                );
                
           };
           
        });
    }
    @Override
    public boolean resetFocus(com.google.gwt.cell.client.Cell.Context context,
            Element parent, C value) {
        return cell.resetFocus(context, getCellParent(parent), value);
    }

    @Override
    public void setValue(com.google.gwt.cell.client.Cell.Context context,
            Element parent, C value) {
        cell.setValue(context, getCellParent(parent), value);
    }

    /**
     * {@inheritDoc}
     */
    public void setAnimation(boolean animated) {
        this.animated = animated;
    }

    /**
     * {@inheritDoc}
     */
    public boolean getAnimation() {
        return animated;
    }
    
    protected boolean getAnimation(Context context,C value) {
        return getAnimation();
    }

    /**
     * {@inheritDoc} Relative to its trigger element.
     */
    public void setPlacement(Placement placement) {
        
        assert placement != null : "should not be null";
        
        this.placement = placement;
    }

    /**
     * {@inheritDoc}
     */
    public Placement getPlacement() {
        return placement;
    }
    
    protected Placement getPlacement(Context context, C value) {
        return getPlacement();
    }

    /**
     * {@inheritDoc}
     */
    public void setTrigger(Trigger trigger) {
        assert trigger != null : "should not be null";
        this.trigger = trigger;
    }

    /**
     * {@inheritDoc}
     */
    public Trigger getTrigger() {
        return trigger;
    }
    
    protected Trigger getTrigger(Context context,C value) {
        return getTrigger();
    }

    /**
     * {@inheritDoc}
     */
    public void setShowDelay(int delayInMilliseconds) {
        showDelayInMilliseconds = delayInMilliseconds;
    }

    /**
     * {@inheritDoc}
     */
    public int getShowDelay() {
        return showDelayInMilliseconds;
    }
    
    protected int getShowDelay(Context context, C value) {
        return getShowDelay();
    }

    /**
     * {@inheritDoc}
     */
    public void setHideDelay(int delayInMilliseconds) {
        hideDelayInMilliseconds = delayInMilliseconds;
    }

    /**
     * {@inheritDoc}
     */
    public int getHideDelay() {
        return hideDelayInMilliseconds;
    }
    
    protected int getHideDelay(Context context, C value) {
        return getHideDelay();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText() {
        return this.tooltip;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setText(String text) {
        assert text != null : "should not be null";
        this.tooltip = text;
    }
    
    protected String getTooltipText(Context context, C value) {
        return getText();
    }

    /**
     * Get the parent element of the decorated cell.
     * 
     * @param parent the parent of this cell
     * @return the decorated cell's parent
     */
    private Element getCellParent(Element parent) {
      return parent.getFirstChildElement().cast();
    }

    /**
     * @return Specific element the Popover/Tooltip is appended to
     */
    public String getContainer() {
        return container;
    }

    /**
     * Set specific element the Popover/Tooltip is appended to
     * @param container  Specific element the Popover/Tooltip is appended to. E.g. 'body' or null.
     */
    public void setContainer(String container) {
        this.container = container;
    }
}
