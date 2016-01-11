package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.constants.Constants;

/**
 * Lead
 * 
 * @since 2.2.1.0
 * @author ohashi keisuke
 *
 */
public class Lead extends Paragraph {

    public Lead() {
        this("");
    }

    public Lead(String html) {
        super();
        addStyleName(Constants.LEAD);
        setText(html);
    }
    
}
