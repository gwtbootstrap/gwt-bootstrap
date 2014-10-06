package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * Simple Accordion style widget.
 * <p>
 * It's a container of {@link AccordionGroup}.
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <p/>
 * <pre>
 * {@code
 * <b:Accordion>
 *     <b:AccordionGroup heading="One">
 *         <b:Paragraph>one</b:Paragraph>
 *         <b:Paragraph>two</b:Paragraph>
 *     </b:AccordionGroup>
 *     
 *     <b:AccordionGroup heading="Defalut Open" defaultOpen="true">
 *         <b:Paragraph>The default opened Accordion</b:Paragraph>
 *     </b:AccordionGroup>
 *     
 *     <b:AccordionGroup defaultOpen="true" heading="With Icon" icon="GITHUB">
 *         <b:Paragraph>Icon style</b:Paragraph>
 *     </b:AccordionGroup>
 *     
 *     <b:AccordionGroup heading="With Custom Icon">
 *         <b:customTrigger>
 *             <b:Image addStyleNames="{style.icon}" resource="{res.logo}"/>
 *         </b:customTrigger>
 *         <b:Paragraph>Custom Icon Style</b:Paragraph>
 *     </b:AccordionGroup>
 * </b:Accordion>
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
public class Accordion extends DivWidget {

    /**
     * Create an empty widget.
     */
    public Accordion() {
        super(Constants.ACCORDION);
        getElement().setId(DOM.createUniqueId());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void add(IsWidget child) {
        if(child instanceof Collapse) {
            Collapse collapse = (Collapse)child;
            
            collapse.setParent("#" + getId());
        }
        super.add(child);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Widget w) {
        
        if(w instanceof AccordionGroup) {
            AccordionGroup accordionGroup = (AccordionGroup)w;
            
            accordionGroup.setParent("#" + getId());
        }
        
        super.add(w);
    }
}
