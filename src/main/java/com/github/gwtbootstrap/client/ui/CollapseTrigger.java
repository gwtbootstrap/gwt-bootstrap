package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.MarkupWidget;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.user.client.Element;
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
 * @since 2.1.1.0
 * @author ohashi keisuke
 * @see Accordion
 * @see Collapse
 * @see CollapseTrigger
 * @see <a href="http://twitter.github.com/bootstrap/javascript.html#collapse">Twitter Bootstrap document</a>
 *
 */
public class CollapseTrigger extends MarkupWidget {

    private String target;
    
    private String parent;
    
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
            element.setAttribute(Constants.DATA_TOGGLE, Constants.COLLAPSE);
            element.setAttribute(Constants.DATA_TARGET, target);
            
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
     * Please see <a href="https://github.com/twitter/bootstrap/issues/4988">this issue</a>.
     * 
     * @param parent parent selector
     */
    public void setParent(String parent) {
        this.parent = parent;
        
        if(widget != null) {
            widget.getElement().setAttribute("data-parent", parent);
        }
        
    }
    
}
