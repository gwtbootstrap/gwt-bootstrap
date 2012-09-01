package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HtmlWidget;
import com.github.gwtbootstrap.client.ui.constants.Constants;

public class Caption extends HtmlWidget {

    /**
     * Creates an empty paragraph.
     */
    public Caption() {
        this("");
    }
    
    /**
     * Creates a widget with  the html set..
     * @param html content html
     */
    public Caption(String html) {
        this("div", html);
    }
    
    protected Caption(String tag,String html) {
        super(tag , html);
        setStyleName(Constants.CAPTION);
    }

}
