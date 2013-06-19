package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;

public class ProgressBarBase extends DivWidget {

    public enum Style implements com.github.gwtbootstrap.client.ui.base.Style {

        DEFAULT(""),

        STRIPED(Bootstrap.progress_striped),
        
        ANIMATED(Bootstrap.progress_animated);
        
        private final String styleName;

        private Style(String styleName) {
            this.styleName = styleName;
            
        }

        public String get() {
            return this.styleName;
        }
    }
    
    public enum Color implements com.github.gwtbootstrap.client.ui.base.Style {
        DEFAULT(""),
        INFO("progress-info"),
        SUCCESS("progress-success"),
        DANGER("progress-danger"),
        WARNING("progress-warning")
        ;
        
        private final String styleName;

        private Color(String styleName) {
            this.styleName = styleName;
        }

        @Override
        public String get() {
            return this.styleName;
        }
        
    }

    public ProgressBarBase() {
        super();
    }

    public ProgressBarBase(String styleName) {
        super(styleName);
    }

    public void setType(Style style) {
        StyleHelper.changeStyle(this, style, Style.class);
        setActive(Style.ANIMATED == style);
    }

    /**
     * Set progress bar color
     * @param color color
     */
    public void setColor(Color color) {
        StyleHelper.changeStyle(this, color, Color.class);
    }

    /**
     * Set active style.
     * <p>
     * if set type {@link Style#STRIPED} and this set true, bar is animated
     * @param active true:active false:deactive
     */
    public void setActive(boolean active) {
        setStyleName(Constants.ACTIVE , active);
    }

}