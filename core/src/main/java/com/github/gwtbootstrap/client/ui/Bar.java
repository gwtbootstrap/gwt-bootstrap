package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.base.Style;
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.dom.client.Style.Unit;

/**
 * The Bar of ProgressBar.
 * 
 * @since 2.2.1.0
 * @author ohashi keisuke
 * 
 * @see StackProgressBar
 */
public class Bar extends DivWidget {

    /**
     * Create an Empty widget.
     */
    public Bar() {
        super(Constants.BAR);
    }
    
    /**
     * The Color of {@link Bar}
     * 
     * @since 2.2.1.0
     * @author ohashi keisuke
     *
     */
    public enum Color implements Style {
        /** DEFAULT Color */
        DEFAULT,
        /** INFO Color */
        INFO,
        /** SUCCESS Color */
        SUCCESS,
        /** DANGER Color */
        DANGER,
        /** WARNING Color */
        WARNING
        ;
        
        /**
         * {@inheritDoc}
         */
        @Override
        public String get() {
            return DEFAULT.equals(this) ? "" : "bar-" +name().toLowerCase();
        }
    }
    
    /**
     * Set bar width as a percent unit
     * @param percent percent
     */
    public void setPercent(double percent) {
        this.getElement().getStyle().setWidth(percent, Unit.PCT);
    }
    
    /**
     * Get bar width as a percent unit
     * @return percent
     */
    public double getPercent() {
        String width = this.getElement().getStyle().getWidth();
        if (width == null)
            return 0;
        else
            return Double.valueOf(width.substring(0, width.indexOf("%")));
    }
    
    /**
     * Set bar color
     * @param color color
     */
    public void setColor(Color color) {
        StyleHelper.changeStyle(this, color, Color.class);
    }

    /**
     * Set bar text
     * @param text bar text
     */
    public void setText(String text) {
        getElement().setInnerText(text);
    }
}

