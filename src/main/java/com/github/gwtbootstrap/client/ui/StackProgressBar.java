package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.ProgressBarBase;
import com.github.gwtbootstrap.client.ui.constants.Constants;

/**
 * Stack style ProgressBar
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <p/>
 * <pre>
 * {@code
 * <b:StackProgressBar type="ANIMATED">
 *  <b:Bar parcent="10"/>
 *  <b:Bar color="SUCCESS" percent="20"/>
 *  <b:Bar color="INFO" percent="30"/>
 * </b:StackProgressBar>
 * }
 * 
 * @since 2.2.1.0
 * @author ohashi keisuke
 * @see ProgressBar
 *
 */
public class StackProgressBar extends ProgressBarBase {

    /**
     * Create an empty StackProgressBar
     */
    public StackProgressBar() {
        super();
        setStylePrimaryName(Constants.PROGRESS);
        addStyleName(Constants.PROGRESS);
        setColor(Color.DEFAULT);
    }
    
    /**
     * Create an empty StackProgressBar with type
     * @param style ProgressBar type
     */
    public StackProgressBar(Style style) {
        this();
        setType(style);
    }
}
