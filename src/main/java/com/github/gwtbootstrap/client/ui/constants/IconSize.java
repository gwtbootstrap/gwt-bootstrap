package com.github.gwtbootstrap.client.ui.constants;

import com.github.gwtbootstrap.client.ui.base.Style;

/**
 * @author: Carlos A Becker
 */
public enum IconSize implements Style {

    LARGE("large"), SMALL("small"), DEFAULT("");

    String style;


    IconSize(String style) {
        this.style = style;
    }

    @Override
    public String get() {
        return "icon-" + style;
    }
}
