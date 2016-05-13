package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.AbstractMarkupWidget;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * Markup widget of CollapseTrigger
 * <p>
 * It's a markup widget (decorator widget).
 * it's can exchange child to {@link Collapse}'s toggle trigger widget.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * </p>
 * <pre>
 * {@code
 * <b:CollapseTrigger target="#toggle1">
 *      <b:Button>Collapse Trigger</b:Button>
 * </b:CollapseTrigger>
 *
 * <!-- if use collapse trigger, you must set existTrigger=true attribute to Collapse tag. -->
 * <b:Collapse existTrigger="true" b:id="toggle1" defaultOpen="true">
 *     <b:FluidRow>
 *         <b:Column size="12">
 *             <b:Alert close="false" animation="true" heading="collapsible1">
 *                 <b:Paragraph>
 *                     Hello :D
 *                 </b:Paragraph>
 *             </b:Alert>
 *         </b:Column>
 *     </b:FluidRow>
 * </b:Collapse>
 * }
 * </pre>
 * 
 * @since 2.2.1.0
 * @author ohashi keisuke
 * @see Accordion
 * @see Collapse
 * @see CollapseTrigger
 * @see <a href="http://getbootstrap.com/2.3.2/javascript.html#collapse">Bootstrap document</a>
 *
 */
public class CollapseTrigger extends AbstractMarkupWidget {

    private String target;
    
    private String parent;

    private boolean isAccordionTrigger = false;

    /**
     * Create an empty widget with target selector
     * @param target selector (eg: #myCollapse)
     */
    public CollapseTrigger(String target) {
        this.target = target;
    }
    
    /**
     * Create an empty widget.
     */
    public CollapseTrigger() {
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Widget asWidget() {
        
        if(widget != null) {
            Element element = widget.getElement();

            if (isAccordionTrigger) {
                element.setAttribute(Constants.DATA_TOGGLE, Constants.COLLAPSE);
                element.removeAttribute(Constants.DATA_TARGET);
                element.setAttribute("href", target);
                if(parent != null && !parent.isEmpty()) {
                    setParent(parent);
                }
                Scheduler.get().scheduleDeferred(new ScheduledCommand() {
                    @Override
                    public void execute() {
                        Collapse.configure(target, parent, false);
                    }
                });
                return super.asWidget();
            }

            if(element.hasAttribute(Constants.DATA_TOGGLE)
                    && widget instanceof HasClickHandlers
                    && !widget.isAttached()) {
                Scheduler.get().scheduleDeferred(new ScheduledCommand() {

                    @Override
                    public void execute() {
                        Collapse.configure(target, parent, false);
                        ((HasClickHandlers)widget).addClickHandler(new ClickHandler() {

                            @Override
                            public void onClick(ClickEvent event) {
                                Collapse.changeVisibility(target, "toggle");
                            }
                        });
                    }
                });
                return super.asWidget();
            }

            element.setAttribute(Constants.DATA_TARGET, target);
            element.setAttribute(Constants.DATA_TOGGLE, Constants.COLLAPSE);

            if(parent != null && !parent.isEmpty()) {
                setParent(parent);
            }
            
        }
        
        return super.asWidget();
    }
    
    /**
     * Set target collapse selector.
     * @param target selector of target. (eg:#myCollapse)
     */
    public void setTarget(String target) {
        this.target = target;
        
        if(widget != null) {
            Element element = widget.getElement();
            element.setAttribute(Constants.DATA_TARGET, target);
        }
    }
    
    /**
     * Get target collapse selector.
     * @return selector.
     */
    public String getTarget(){
        return this.target;
    }


    /**
     * Set parent selector.
     * 
     * it only work with {@link AccordionGroup},
     * Please see <a href="https://github.com/twbs/bootstrap/issues/4988">this issue</a>.
     * 
     * @param parent parent selector
     */
    public void setParent(String parent) {
        this.parent = parent;
        
        if(widget != null) {
            widget.getElement().setAttribute("data-parent", parent);
        }
        
    }

    protected boolean isAccordionTrigger() {
        return isAccordionTrigger;
    }

    protected void setAccordionTrigger(boolean accordionTrigger) {
        isAccordionTrigger = accordionTrigger;
    }
}
