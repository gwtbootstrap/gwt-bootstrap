package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.AbstractMarkupWidget;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * Markup widget of Affix.
 * @author k-ohashi
 *
 */
public class Affix extends AbstractMarkupWidget {
    
    private int offsetBottom;
    private int offsetTop;
    
    
    private OffsetHelper offsetHelper = new DefaultOffsetHelper();
    
    /**
     * The helper class for Affix offset .
     * @author k-ohashi
     */
    public interface OffsetHelper {
        /**
         * Get offset bottom.
         * @return offset bottom value.
         */
        public int bottom();

        /**
         * Get offset top.
         * @return offset top value.
         */
        public int top();
    }
    
    /**
     * Default Behavior Offset Helper.
     * @author k-ohashi
     */
    public class DefaultOffsetHelper implements OffsetHelper {

        /**
         * {@inheritDoc}
         */
        @Override
        public int bottom() {
            return offsetBottom;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int top() {
            return offsetTop;
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
                    reconfigure();
                }
            });
        }
        return super.asWidget();
    }
    
    
    public void reconfigure() {
        Element element = getWidget().getElement();
        removeDataIfExists(element);
        configure(element);
    }
    
    public native void configure(Element e) /*-{
        var $this = $wnd.jQuery(e);
        var that = this;
        $this.affix({
                offset : {
                    bottom : function(){
                        return that.@com.github.gwtbootstrap.client.ui.Affix::getOffsetBottom()();
                    },
                    top : function(){
                        return that.@com.github.gwtbootstrap.client.ui.Affix::getOffsetTop()();
                    }
                }
            });
    }-*/;


    public static native void removeDataIfExists(Element e) /*-{
        var $this = $wnd.jQuery(e);
        
        if(!$this.data("affix")) return;
        
        $this.removeData("offset")
                .removeData("offsetBottom")
                .removeData("offsetTop")
                .removeData("affix");
    }-*/;
    
    
    /**
     * Get offsetTop
     * @return offsetTop
     */
    public int getOffsetTop() {
        return offsetHelper.top();
    }

    /**
     * Set offsetTop
     * @param offsetTop offsetTop
     */
    public void setOffsetTop(int offsetTop) {
        this.offsetTop = offsetTop;
    }

    /**
     * Get offsetBottom
     * @return offsetBottom
     */
    public int getOffsetBottom() {
        return offsetHelper.bottom();
    }

    /**
     * Set offsetBottom
     * @param offsetBottom offsetBottom
     */
    public void setOffsetBottom(int offsetBottom) {
        this.offsetBottom = offsetBottom;
    }

    /**
     * Set offsetHelper
     * @param offsetHelper offsetHelper
     */
    public void setOffsetHelper(OffsetHelper offsetHelper) {
        assert offsetHelper != null;
        this.offsetHelper = offsetHelper;
    }
}
